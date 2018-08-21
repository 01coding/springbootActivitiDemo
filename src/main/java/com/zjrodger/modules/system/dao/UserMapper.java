package com.zjrodger.modules.system.dao;

import com.zjrodger.modules.system.entity.User;

/**
 * @author zhangjian
 * @create 2018-08-21
 */
public interface UserMapper {
    User findByUsername(String username);
}
