package com.spoc.service;

import com.spoc.entity.User;

public interface UserService {
    /**
     * 登录业务
     * @param loginUser 包含用户名和密码的对象
     * @return 登录成功的用户信息
     */
    User login(User loginUser);
}