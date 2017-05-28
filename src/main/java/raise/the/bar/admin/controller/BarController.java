package raise.the.bar.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import raise.the.bar.admin.model.*;
import raise.the.bar.admin.service.barTiming.BarTimingOperationWithNewEntry;
import raise.the.bar.admin.service.barTiming.BarTimingOperationWithNoEntry;
import raise.the.bar.admin.write.aws.AmazonAWSS3Operation;
import raise.the.bar.admin.write.service.BarService;
import raise.the.bar.admin.write.service.BarTimingService;
import raise.the.bar.admin.write.service.ItemService;
import raise.the.bar.admin.write.service.SpecialService;

import java.io.IOException;
import java.util.List;

import static raise.the.bar.admin.helper.RTBConstant.APPLICATION_NAME;

/**
 * Created by Sujeet on 1/18/17.
 */


@Controller
@SessionAttributes({"ownerDetail","barDetail","singleBarDetails","itemDetails","singleItemDetails","specialDetails","barWeekTimingDetails"})
public class BarController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private BarService barService;

    @Autowired
    private SpecialService specialService;

    @Autowired
    private BarTimingService barTimingService;

    @Autowired
    private BarTimingForWeek barTimingForWeek;

    @Autowired
    private BarTimingOperationWithNoEntry barTimingOperationWithNoEntry;

    @Autowired
    private BarTimingOperationWithNewEntry barTimingOperationWithNewEntry;

    @Autowired
    private AmazonAWSS3Operation amazonAWSS3Operation;

    @RequestMapping(value ="/bar/{barId:.+}",method = RequestMethod.GET)
    public String getBarInfo(@PathVariable("barId") Integer barId, ModelMap modelMap){

        List<BarTimingModel> barTimingModelList = barTimingService.findAllByBarId(barId);
        if ((barTimingModelList == null || barTimingModelList.size()== 0) && modelMap.get("barWeekTimingDetails") == null){
            barTimingForWeek.setWeekTiming(barTimingOperationWithNoEntry.generateEmptyList(barId).getWeekTiming());
            modelMap.put("barWeekTimingDetails",barTimingForWeek);
        }else if(barTimingModelList != null && barTimingModelList.size() != 0) {
            barTimingForWeek.setWeekTiming(barTimingModelList);
            modelMap.put("barWeekTimingDetails", barTimingForWeek);
        }
        OwnerModel ownerModel = (OwnerModel) modelMap.get("ownerDetail");
        BarModel barModel = barService.findOne(barId);
        List<ItemModel> itemModelList = itemService.findAll(barId);
        List<SpecialModel> specialModelList = specialService.findAll(barId);
        System.out.println(specialModelList.size()+" size ");
        modelMap.put("singleBarDetails",barModel);
        modelMap.put("specialDetails",specialModelList);
        modelMap.put("itemDetails",itemModelList);
        System.out.println("  printing barTimingForWeek.size() "+barTimingForWeek.getWeekTiming().size());
        return "bar";
    }

    @RequestMapping(value ="/addNewBar",method = RequestMethod.POST)
    public String addNewBar(BarModel barModel, @RequestParam("logo") MultipartFile logo,
                            @RequestParam("picture") MultipartFile picture, ModelMap modelMap) throws IOException {

        OwnerModel ownerModel = (OwnerModel) modelMap.get("ownerDetail");
        barModel.setOwnerId(ownerModel.getOwnerId());
        barModel.setDayOFWeek(1);
        barModel.setAmCloseTime(barModel.getPmCloseTime());
        barModel.setPmOpenTime(barModel.getPmCloseTime());


        BarModel savedBarModel = barService.saveOne(barModel);
        String bucketName = APPLICATION_NAME + savedBarModel.getBarId().toString();
        amazonAWSS3Operation.createNewBucket(bucketName);

        barService.updateBarLogoAndBarPicture(savedBarModel.getBarId(),amazonAWSS3Operation.uploadFilesToS3(picture,bucketName),
                amazonAWSS3Operation.uploadFilesToS3(picture,bucketName));

        List<BarModel> barModelList = barService.findBarByOwnerId(ownerModel.getOwnerId());

        for (BarModel barModel1 : barModelList) {
            System.out.println(" after new bar added ");
            System.out.println(barModel1.getName()+" "+barModel1.getBarPicture());
        }
        modelMap.put("barDetail", barModelList);

        return "redirect:/home";
    }

    @RequestMapping(value ="/bar/{barId:.+}/additems",method = RequestMethod.POST)
    public String addNewItem(@PathVariable("barId") Integer barId, ItemModel itemModel, ModelMap modelMap){

        System.out.println(" bar "+itemModel.getName()+" bar id "+barId);
        itemModel.setBarId(barId);
        itemService.saveOne(itemModel);
        //modelMap.put("singleItemDetails",barModel);
        return "redirect:/bar/"+barId;
    }

    @RequestMapping(value ="/bar/{barId:.+}/addspecial",method = RequestMethod.POST)
    public String addNewSpecial(@PathVariable("barId") Integer barId, SpecialModel specialModel, ModelMap modelMap){

        specialModel.setBarId(barId);
        specialService.saveOne(specialModel);
        return "redirect:/bar/"+barId;
    }

    @RequestMapping(value ="/editBar/{barId:.+}",method = RequestMethod.POST)
    public String editBar(@PathVariable("barId") Integer barId,BarModel barModel, ModelMap modelMap){

        barModel.setBarId(barId);
        OwnerModel ownerModel = (OwnerModel) modelMap.get("ownerDetail");
        barModel.setOwnerId(ownerModel.getOwnerId());
        barModel.setDayOFWeek(1);
        barModel.setAmCloseTime(barModel.getPmCloseTime());
        barModel.setPmOpenTime(barModel.getPmCloseTime());
        barModel.setBarPicture("http://ella.ils.indiana.edu/~kumasuje/Kilroys.jpg");
        barModel.setBarLogo("http://ella.ils.indiana.edu/~kumasuje/Kilroys.jpg");
        barService.updateAllExceptMedia(barModel);

        return "redirect:/bar/"+barId;
    }


    @RequestMapping(value ="/editBarTiming/{barId:.+}",method = RequestMethod.POST)
    public String editBarTiming(@PathVariable("barId") Integer barId, @ModelAttribute("barWeekTimingDetails") BarTimingForWeek barTimingForWeek1, ModelMap modelMap){


        barTimingService.reinsertAll(barTimingOperationWithNewEntry.generateEmptyList(barTimingForWeek1).getWeekTiming(),barId);

        return "redirect:/bar/"+barId;
    }

    @RequestMapping(value ="/bar/item/edit",method = RequestMethod.POST)
    public String editBarItem(ItemModel itemModel, ModelMap modelMap){

        itemService.edit(itemModel);

        return "redirect:/home";
    }

    @RequestMapping(value ="/bar/special/edit",method = RequestMethod.POST)
    public String editBarSpecial(SpecialModel specialModel, ModelMap modelMap){

        specialService.editOne(specialModel);
        return "redirect:/home";
    }
}