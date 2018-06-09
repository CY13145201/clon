package com.xieke.test.interceptor.config;

import com.xieke.test.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 添加拦截规则
        // excludePathPatterns 排除拦截
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/test/*");
        super.addInterceptors(registry);
    }

}