package com.spoc.service.impl;

import com.spoc.entity.User;
import com.spoc.mapper.UserMapper;
import com.spoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User loginUser) {
        // 1. 查数据库
        User user = userMapper.selectByUsername(loginUser.getUsername());

        // 2. 校验账号
        if (user == null) {
            throw new RuntimeException("账号不存在");
        }

        // 3. 校验密码
        if (!user.getPassword().equals(loginUser.getPassword())) {
            throw new RuntimeException("密码错误");
        }

        // 4. 登录成功，抹掉密码防止泄露
        user.setPassword(null);
        return user;
    }
}