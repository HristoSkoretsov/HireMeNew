package org.ico.hireme.config;

import org.ico.hireme.interceptors.UserGreetingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements
        WebMvcConfigurer {

    private final HandlerInterceptor titleInterceptor;
    private final HandlerInterceptor viewsCounterInterceptor;

    @Autowired
    public WebMvcConfiguration(UserGreetingInterceptor titleInterceptor, HandlerInterceptor viewsCounterInterceptor) {
        this.titleInterceptor = titleInterceptor;
        this.viewsCounterInterceptor = viewsCounterInterceptor;
    }

    @Override

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.titleInterceptor);
    }
}
