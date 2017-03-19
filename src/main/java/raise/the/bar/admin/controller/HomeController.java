package raise.the.bar.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Sujeet on 1/18/17.
 */


@Controller
public class HomeController {

    @RequestMapping(value ="/")
    public String home(){

        return "index";
    }


}