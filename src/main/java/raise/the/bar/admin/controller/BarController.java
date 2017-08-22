package raise.the.bar.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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

        logger.info("Request to /bar/{}", barId);

        List<BarTimingModel> barTimingModelList = barTimingService.findAllByBarId(barId);

        //ToDo fix this timing
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
        modelMap.put("singleBarDetails",barModel);
        modelMap.put("specialDetails",specialModelList);
        modelMap.put("itemDetails",itemModelList);

        logger.info("Returning bar view with barId as {}", barId);
        return "bar";
    }

    @RequestMapping(value ="/addNewBar",method = RequestMethod.POST)
    public String addNewBar(BarModel barModel, @RequestParam("logo") MultipartFile logo,
                            @RequestParam("picture") MultipartFile picture, ModelMap modelMap) throws IOException {

        logger.info("Request to /addNewBar");

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

        modelMap.put("barDetail", barModelList);

        logger.info("A New bar added with owner ID as {} , Redirecting the request to Home Page",ownerModel.getOwnerId());
        return "redirect:/home";
    }

    @RequestMapping(value ="/bar/{barId:.+}/additems",method = RequestMethod.POST)
    public String addNewItem(@PathVariable("barId") Integer barId, ItemModel itemModel, ModelMap modelMap){

        logger.info("Request to /bar/{}/additems ",barId);
        itemModel.setBarId(barId);
        ItemModel storedItem = itemService.saveOne(itemModel);
        //modelMap.put("singleItemDetails",barModel);
        logger.info("Successfully stored New Item with Item ID as {} , Redirecting the Bar page with bar ID as {}",storedItem.getItemId(),barId);
        return "redirect:/bar/"+barId;
    }

    @RequestMapping(value ="/bar/{barId:.+}/addspecial",method = RequestMethod.POST)
    public String addNewSpecial(@PathVariable("barId") Integer barId, SpecialModel specialModel, ModelMap modelMap){

        logger.info("Request to /bar/{}/addspecial ",barId);
        specialModel.setBarId(barId);
        SpecialModel storedNewSpecial = specialService.saveOne(specialModel);
        logger.info("Successfully stored a new Special with special ID as {} , Redirecting the Bar page with bar ID as {}" , storedNewSpecial.getItemId(),barId);
        return "redirect:/bar/"+barId;
    }

    @RequestMapping(value ="/editBar/{barId:.+}",method = RequestMethod.POST)
    public String editBar(@PathVariable("barId") Integer barId,BarModel barModel, ModelMap modelMap){

        logger.info("Request to /editBar/{}",barId);
        barModel.setBarId(barId);
        OwnerModel ownerModel = (OwnerModel) modelMap.get("ownerDetail");
        barModel.setOwnerId(ownerModel.getOwnerId());
        barModel.setDayOFWeek(1);
        barModel.setAmCloseTime(barModel.getPmCloseTime());
        barModel.setPmOpenTime(barModel.getPmCloseTime());
        barModel.setBarPicture("http://ella.ils.indiana.edu/~kumasuje/Kilroys.jpg");
        barModel.setBarLogo("http://ella.ils.indiana.edu/~kumasuje/Kilroys.jpg");
        barService.updateAllExceptMedia(barModel);
        logger.info("Successfully Updated Bar information , Redirecting to Bar Page with bar ID as {} ",barId);
        return "redirect:/bar/"+barId;
    }


    @RequestMapping(value ="/editBarTiming/{barId:.+}",method = RequestMethod.POST)
    public String editBarTiming(@PathVariable("barId") Integer barId, @ModelAttribute("barWeekTimingDetails") BarTimingForWeek barTimingForWeek1, ModelMap modelMap){

        logger.info("Request to /editBarTiming/{}",barId);
        barTimingService.reinsertAll(barTimingOperationWithNewEntry.generateEmptyList(barTimingForWeek1).getWeekTiming(),barId);
        logger.info("Successfully Updated Bar Timing information , Redirecting to Bar Page with bar ID as {} ",barId);

        return "redirect:/bar/"+barId;
    }

    @RequestMapping(value ="/bar/item/edit",method = RequestMethod.POST)
    public String editBarItem(ItemModel itemModel, ModelMap modelMap){

        logger.info("Request to /bar/item/edit with ItemID as {}",itemModel.getItemId());
        itemService.edit(itemModel);
        logger.info("Successfully Updated Bar Item with ItemID as {}, Redirecting to Bar Page with bar ID as {} ",itemModel.getItemId(),itemModel.getBarId());

        return "redirect:/bar/"+itemModel.getBarId();
    }

    @RequestMapping(value ="/bar/special/edit",method = RequestMethod.POST)
    public String editBarSpecial(SpecialModel specialModel, ModelMap modelMap){

        logger.info("Request to /bar/special/edit with  Special Item ID as {}",specialModel.getItemId());
        specialService.editOne(specialModel);
        logger.info("Successfully Updated Bar Special Item with Special ItemID as {}, Redirecting to Bar Page with bar ID as {} ",specialModel.getItemId(),specialModel.getBarId());
        return "redirect:/home";
    }
}