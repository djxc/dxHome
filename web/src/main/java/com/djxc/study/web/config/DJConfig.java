package com.djxc.study.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置springbootmvc
 * 1、添加拦截器
 */
@Configuration
public class DJConfig implements WebMvcConfigurer {

    @Autowired
    APIHanderInterceptor apiHanderInterceptor;

    /**
     * 添加拦截器
     * 拦截除了login以外的所有方法
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiHanderInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/login", "/error", "/**/*.ico");
    }
}
