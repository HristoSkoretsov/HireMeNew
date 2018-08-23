package org.ico.hireme.config;

import org.ico.hireme.interceptors.UserGreetingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements
        WebMvcConfigurer {

    private final HandlerInterceptor titleInterceptor;
    private final HandlerInterceptor adminUsersTotal;

    @Autowired
    public WebMvcConfiguration(UserGreetingInterceptor titleInterceptor, @Qualifier("adminInfoAboutUsers") HandlerInterceptor adminUsersTotal) {
        this.titleInterceptor = titleInterceptor;
        this.adminUsersTotal = adminUsersTotal;
    }

    @Override

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.titleInterceptor);
        registry.addInterceptor(this.adminUsersTotal);

    }
}
