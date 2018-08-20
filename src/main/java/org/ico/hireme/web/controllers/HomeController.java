package org.ico.hireme.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class HomeController extends BaseController {

    @GetMapping("/")
    public ModelAndView index() {
        return this.view("index");
    }

    @GetMapping("/home")
    public ModelAndView home(Principal principal, ModelAndView modelAndView) {
        modelAndView.addObject("username", principal.getName());

        return this.view("user-home", modelAndView);
    }
}