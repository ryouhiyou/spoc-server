package com.spoc.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {

    // 密钥 (随便写长一点)
    private static final String SECRET = "SpocSystemSecretKey123456";
    // 过期时间 (这里设为 24 小时)
    private static final long EXPIRATION = 86400000L;

    /**
     * 生成令牌
     */
    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    /**
     * 解析令牌 (获取 Claims)
     */
    public static Claims parseToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            return null; // 解析失败（过期或篡改）
        }
    }
}