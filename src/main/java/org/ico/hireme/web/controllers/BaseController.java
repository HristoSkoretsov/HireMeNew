package org.ico.hireme.web.controllers;

import org.springframework.web.servlet.ModelAndView;

public class BaseController {

    protected ModelAndView view(String view, ModelAndView modelAndView) {
        modelAndView.setViewName(view);
        return modelAndView;
    }

    protected ModelAndView view(String view) {

        return this.view(view, new ModelAndView());
    }

    protected ModelAndView redirect(String route) {
        return this.view("redirect:" + route);
    }
}

