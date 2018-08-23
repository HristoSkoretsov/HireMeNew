package org.ico.hireme.interceptors;

import org.ico.hireme.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AdminInfoAboutUsers extends
        HandlerInterceptorAdapter {

    private final UserRepository userRepository;

    @Autowired
    public AdminInfoAboutUsers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        int total = this.userRepository.findAll().size();
        request.setAttribute("total", total);
        return true;
    }
}