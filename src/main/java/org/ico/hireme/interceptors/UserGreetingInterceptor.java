package org.ico.hireme.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserGreetingInterceptor extends
        HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler) throws Exception {

        request.setAttribute("greeting", "WELCOME");
        return true;
    }

   }

