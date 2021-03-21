package com.example.microservice.infra.config;

import com.example.microservice.infra.aspect.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 钟玖林
 * @Date 2020/12/9 22:11
 * @Version 1.0
 * 前后端分离支持跨域
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 配置跨域请求
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new JwtInterceptor());
        // 需拦截的路径
        interceptorRegistration.addPathPatterns("/**");
        // 需放行的路径
        interceptorRegistration.excludePathPatterns("/**/login", "/**/unlogin", "/error");
    }
}
