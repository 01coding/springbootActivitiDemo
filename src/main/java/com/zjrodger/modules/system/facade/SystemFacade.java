package com.zjrodger.modules.system.facade;

import com.zjrodger.modules.system.entity.User;
import com.zjrodger.modules.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhangjian
 * @create 2018-08-21
 */
@RestController
@RequestMapping("/systemFacade")
public class SystemFacade {

    private static final Logger logger = LoggerFactory.getLogger(SystemFacade.class);

    @Autowired
    @Qualifier("userServiceImpl")
//    @Resource(name = "userServiceImpl")
    private UserService userService;

    @RequestMapping("/queryByUsername")
    public User queryByUsername() {
        User user = userService.findByUsername("admin");
        logger.info("查询到用户：{}", user.toString());
        return user;
    }
}
