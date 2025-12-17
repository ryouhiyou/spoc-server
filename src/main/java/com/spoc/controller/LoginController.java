package com.spoc.controller;

import com.spoc.common.Result;
import com.spoc.entity.User;
import com.spoc.service.UserService;
import com.spoc.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 1. Web 端登录接口 (教师/管理员)
     * 逻辑：如果查到是学生 (role=2)，直接报错拦截
     */
    @PostMapping("/login")
    public Result<Map<String, Object>> loginWeb(@RequestBody User loginUser) {
        User user = userService.login(loginUser);

        // ★ 核心隔离逻辑：如果是学生，禁止登录 Web 后台
        if (user.getRole() == 2) {
            return Result.error("学生账号请使用手机 App 登录");
        }

        // 生成 Token
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("username", user.getUsername());
        claims.put("role", user.getRole());
        String token = JwtUtils.generateToken(claims);

        // 返回 User信息 + Token
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("token", token);

        return Result.success(map);
    }

    /**
     * 2. App 端登录接口 (学生)
     * 逻辑：如果查到是老师，禁止登录 App (或者允许，看您需求)
     */
    @PostMapping("/app/login")
    public Result<Map<String, Object>> loginApp(@RequestBody User loginUser) {
        User user = userService.login(loginUser);

        // ★ 核心隔离逻辑：只允许学生登录
        if (user.getRole() != 2) {
            return Result.error("非学生账号无法登录");
        }

        // 生成 Token
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("username", user.getUsername());
        claims.put("role", user.getRole());
        String token = JwtUtils.generateToken(claims);

        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("token", token);

        return Result.success(map);
    }
}