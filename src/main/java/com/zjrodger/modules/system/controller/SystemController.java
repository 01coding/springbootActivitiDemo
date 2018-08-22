package com.zjrodger.modules.system.controller;

import com.zjrodger.modules.system.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SystemController {

    private final Logger logger = LoggerFactory.getLogger(SystemController.class);

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(User user) {
        logger.info("进入登录方法，组装Shiro要用的参数。{}， {}", user.getUsername(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            subject.login(token);
        } catch (Exception e) {
            // 若权限校验失败，则返回给用户登录界面。
            logger.error("具体异常信息：", e);
            return "login";
        }
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


