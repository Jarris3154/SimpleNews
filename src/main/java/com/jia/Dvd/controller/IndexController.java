package com.jia.Dvd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/addDvd")
    public String add(){
        return "add";
    }

    @RequestMapping("/returnDvd")
    public String returnDvd(){
        return "returnDvd";
    }
}
