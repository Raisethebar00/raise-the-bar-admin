package raise.the.bar.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import raise.the.bar.admin.model.BarModel;
import raise.the.bar.admin.model.LoginModel;
import raise.the.bar.admin.model.OwnerModel;
import raise.the.bar.admin.write.aws.AmazonAWSS3Operation;
import raise.the.bar.admin.write.service.BarService;
import raise.the.bar.admin.write.service.OwnerService;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static raise.the.bar.admin.helper.RTBConstant.*;

/**
 * Created by Sujeet on 1/18/17.
 */


@Controller
@SessionAttributes({"ownerDetail","barDetail","singleBarDetails"})
public class LoginController {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private BarService barService;

    @Autowired
    private AmazonAWSS3Operation amazonAWSS3Operation;


    @RequestMapping(value ="/home",method = RequestMethod.POST)
    public String login(LoginModel loginModel, ModelMap modelMap){

        OwnerModel ownerModel = ownerService.findOneOwner(loginModel);
        System.out.println(ownerModel.getOwnerId()+" - "+ownerModel.getEmailId());
        List<BarModel> barModelList = barService.findBarByOwnerId(ownerModel.getOwnerId());
        System.out.println(barModelList.get(0).getOwnerId()+" -- "+barModelList.get(0).getBarId());
        modelMap.addAttribute("ownerDetail", ownerModel);
        modelMap.addAttribute("barDetail", barModelList);

        if(ownerModel == null){
            // ToDo Error handling
            System.out.println(" ERROR");
        }
        return "home";
    }


    @RequestMapping(value ="/home",method = RequestMethod.GET)
    public String homePage(LoginModel loginModel, ModelMap modelMap){

        return "home";
    }

    @RequestMapping(value ="/editBar/{barId:.+}/picture",method = RequestMethod.POST)
    public String updateBarPicture(@PathVariable("barId") Integer barId, @RequestParam("picture") MultipartFile picture,
                                   ModelMap modelMap) throws IOException {

        String bucketName = APPLICATION_NAME + barId;

        barService.updateBarPicture(barId,amazonAWSS3Operation.uploadFilesToS3(picture,bucketName));
        return "home";
    }


    @RequestMapping(value ="/editBar/{barId:.+}/logo",method = RequestMethod.POST)
    public String updateBarLogo(@PathVariable("barId") Integer barId, @RequestParam("logo") MultipartFile logo,
                                   ModelMap modelMap) throws IOException {

        String bucketName = APPLICATION_NAME + barId;

        barService.updateBarLogo(barId,amazonAWSS3Operation.uploadFilesToS3(logo,bucketName));
        return "home";
    }

    @RequestMapping(value = "/logout")
    public String doLogout(HttpSession session, Model model) {
        session.invalidate();
        model.asMap().clear();

        System.out.println("Logout controller called.");
        return "index";
    }


}