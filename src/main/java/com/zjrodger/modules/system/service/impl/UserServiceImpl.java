package com.zjrodger.modules.system.service.impl;

import com.zjrodger.modules.system.dao.UserMapper;
import com.zjrodger.modules.system.entity.User;
import com.zjrodger.modules.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangjian
 * @create 2018-08-21
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
