package com.jmu.lodgesystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class myWebMvcConfig implements WebMvcConfigurer {
    //配置资源映射路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/temp-rainy/**").addResourceLocations("file:D:/temp-rainy/");
        //registry.addResourceHandler("/temp-rainy/**").addResourceLocations("file:"+"/root/temp-rainy/");
    }
}
