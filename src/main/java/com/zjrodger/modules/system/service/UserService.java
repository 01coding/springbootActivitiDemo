package com.zjrodger.modules.system.service;

import com.zjrodger.modules.system.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    User findByUsername(@Param("username") String username);
}
