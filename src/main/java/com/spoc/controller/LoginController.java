package com.spoc.controller;

import com.spoc.common.Result;
import com.spoc.entity.User;
import com.spoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<User> login(@RequestBody User loginUser) {
        try {
            // 调用 Service 执行登录逻辑
            User user = userService.login(loginUser);
            return Result.success(user);
        } catch (Exception e) {
            // 捕获 Service 抛出的 "账号不存在" 或 "密码错误" 异常
            return Result.error(e.getMessage());
        }
    }
}