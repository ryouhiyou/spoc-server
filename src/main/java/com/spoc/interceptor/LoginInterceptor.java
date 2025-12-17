package com.spoc.interceptor;

import com.spoc.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 放行 OPTIONS 请求 (跨域预检)
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        // 2. 获取 Header 里的 token
        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            response.setStatus(401);
            return false;
        }

        // 3. 验证 token
        Claims claims = JwtUtils.parseToken(token);
        if (claims == null) {
            response.setStatus(401);
            return false;
        }

        // 4. 将用户信息存入 request (ThreadLocal)，方便 Controller 用
        // request.setAttribute("userId", claims.get("id"));
        return true; // 放行
    }
}