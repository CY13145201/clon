package com.xieke.test;

import com.xieke.test.filter.TestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringbootFilterInterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFilterInterceptorApplication.class, args);
    }

    /**
     * 第二种方式(推荐使用)
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        List<String> urlPatterns = new ArrayList<>();
        TestFilter testFilter = new TestFilter();   //new过滤器
        urlPatterns.add("/test/*");      //指定需要过滤的url
        filterRegistrationBean.setFilter(testFilter);       //set
        filterRegistrationBean.setUrlPatterns(urlPatterns);     //set
        return filterRegistrationBean;
    }

}
