package com.ucar.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping({"/", "/home", "/null"})
    public String getHome(){
        return "home";
    }

    @RequestMapping("/main")
    public String getMain(){
        return "wrap/main";
    }
}
