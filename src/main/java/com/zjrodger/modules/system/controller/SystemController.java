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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class SystemController {

    private final Logger logger = LoggerFactory.getLogger(SystemController.class);

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized(){
        return "unauthorized";
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        if(null != subject){
            subject.logout();
        }
        return "login";
    }

    @RequestMapping("/resource01")
//    @ResponseBody
    public String resource01() {
        return "resource01";
    }

    @RequestMapping("/adminResource01")
    @ResponseBody
    public String adminResource01() {
        return "adminResource01 Success";
    }

    /**
     * 两种获取前端用户传参的方法：
     * 1、通过@RequestParam注解
     * 2、通过User实体直接封装
     */
    //    public String loginUser(User user) {
    @RequestMapping("/loginUser")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpSession session) {
        logger.info("进入登录方法，组装Shiro要用的参数。{}， {}", username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
            // 登陆成功后，将user信息存储在session中。
            User user = (User) subject.getPrincipal();
            session.setAttribute("user", user);
            return "index";
        } catch (Exception e) {
            logger.error("具体异常信息：", e);
            // 若权限校验失败，则返回给用户登录界面。
            return "login";
        }
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


