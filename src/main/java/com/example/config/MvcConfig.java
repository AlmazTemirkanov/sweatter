package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("main");
        registry.addViewController("/filter").setViewName("filter");
        registry.addViewController("/prepaid").setViewName("prepaid");
        registry.addViewController("/postpaid").setViewName("postpaid");
        registry.addViewController("/postpaid_filter").setViewName("postpaid_filter");
        registry.addViewController("/prepaid_filter").setViewName("prepaid_filter");
        registry.addViewController("/privet").setViewName("privet");
        registry.addViewController("/privet_filter").setViewName("privet_filter");
        registry.addViewController("/login").setViewName("login");
    }

}