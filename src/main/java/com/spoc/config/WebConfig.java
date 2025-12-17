package com.spoc.config;

import com.spoc.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.io.File;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 获取绝对路径
        String path = new File("./files/").getAbsolutePath();

        // 映射 URL: /files/** -> 本地目录: ./files/
        // 注意：file: 后面的路径必须以 / 结尾
        registry.addResourceHandler("/files/**")
                .addResourceLocations("file:" + path + File.separator);
    }

    // ★ 新增：注册拦截器

    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")  // 拦截所有
                .excludePathPatterns(
                        "/login",           // 放行 Web端登录
                        "/app/login",       // 放行 App端登录 (等下新建)
                        "/common/upload",   // 放行上传 (可选，看需求)
                        "/files/**"         // 放行静态资源访问
                );
    }
}