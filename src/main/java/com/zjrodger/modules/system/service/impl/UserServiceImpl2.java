package com.zjrodger.modules.system.service.impl;

import com.zjrodger.modules.system.dao.UserMapper;
import com.zjrodger.modules.system.entity.User;
import com.zjrodger.modules.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl2 implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
