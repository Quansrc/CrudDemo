package com.quan.crud.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/console")
    public String consoleIndex() {
        System.out.println("aaaaa");
        return "home/console";
    }

}
