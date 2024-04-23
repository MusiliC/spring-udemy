package com.ceetech.mycoolapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // create mapping for hello
    @GetMapping()
    public String getMethodName(Model theModel) {
        theModel.addAttribute("theDate", new java.util.Date());
        return "homepage";
    }

    @GetMapping("/leaders")
    public String leaders(Model theModel) {
        theModel.addAttribute("theDate", new java.util.Date());
        return "leaders";
    }

    @GetMapping("/system")
    public String admins(Model theModel) {
        theModel.addAttribute("theDate", new java.util.Date());
        return "admin";
    }

    @GetMapping("/not-found")
    public String notFound(Model theModel) {
        theModel.addAttribute("theDate", new java.util.Date());
        return "accessdenied";
    }

}
