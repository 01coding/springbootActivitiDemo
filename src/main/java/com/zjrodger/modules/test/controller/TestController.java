package com.zjrodger.modules.test.controller;


import com.alibaba.fastjson.JSON;
import com.zjrodger.modules.test.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@RestController
@RequestMapping("/testController")
//@Controller
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/test01", method = RequestMethod.POST)
    public void test01(HttpServletRequest request, HttpServletResponse response, @RequestBody UserVO userVo){
        try{
            logger.info("服务器端获得请求参数：{}", userVo.toString());
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(userVo));
            writer.flush();
        } catch(Exception e){
            logger.info(e.getMessage());
        }
//        return JSON.toJSONString(userVo);
    }

    @RequestMapping(value = "/app/test02", method = RequestMethod.POST)
    public String test02(HttpServletRequest request, @RequestBody UserVO userVo){
        try{
            logger.info("服务器端获得请求参数：{}", userVo.toString());
        } catch(Exception e){
            logger.info(e.getMessage());
        }
        return JSON.toJSONString(userVo);
    }

}
