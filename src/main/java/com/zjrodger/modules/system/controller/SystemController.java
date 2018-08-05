package com.zjrodger.modules.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SystemController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/userWindow")
    public String userWindow() {
        return "activiti/userWindow";
    }


    @RequestMapping("/busTree")
    public String busTree() {
        return "activiti/busTree";
    }

    @RequestMapping("/doActTask")
    public String doActTask() {
        return "activiti/doActTask";
    }

    @RequestMapping("/extendActModelList")
    public String extendActModelList() {
        return "activiti/extendActModelList";
    }


}


