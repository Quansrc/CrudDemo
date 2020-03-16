package com.quan.crud.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/console")
    public String consoleIndex() {
        return "home/console";
    }

    @RequestMapping("/homepage1")
    public String homePage1Index(){
        return "home/homepage1";
    }

    @RequestMapping("/userlist")
    public String userList(){
        return "user/user/userlist";
    }
}
