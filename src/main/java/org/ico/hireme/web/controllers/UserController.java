package org.ico.hireme.web.controllers;

import org.ico.hireme.domain.entities.User;
import org.ico.hireme.domain.entities.WorkerProfile;
import org.ico.hireme.domain.entities.WorkerRequirement;
import org.ico.hireme.models.binding.UserRegisterBindingModel;
import org.ico.hireme.models.service.WorkerProfileServiceModel;
import org.ico.hireme.models.service.WorkerRequirementServiceModel;
import org.ico.hireme.services.RecaptchaService;
import org.ico.hireme.services.UserService;
import org.ico.hireme.services.WorkerProfileService;
import org.ico.hireme.services.WorkerRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
public class UserController extends BaseController {

    private final UserService userService;
    private final WorkerProfileService workerProfileService;
    private final WorkerRequirementService workerRequirementService;
    private final RecaptchaService recaptchaService;

    @Autowired
    public UserController(UserService userService, WorkerProfileService workerProfileService, WorkerRequirementService workerRequirementService, RecaptchaService recaptchaService) {
        this.userService = userService;
        this.workerProfileService = workerProfileService;
        this.workerRequirementService = workerRequirementService;
        this.recaptchaService = recaptchaService;
    }

    @GetMapping("/login")
    @PreAuthorize("isAnonymous()")
    public ModelAndView login(ModelAndView modelAndView) {
        return this.view("login");
    }

    @GetMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ModelAndView register(ModelAndView modelAndView) {

        return this.view("register");
    }

    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ModelAndView registerConfirm(@Valid @ModelAttribute ("userRegisterBindingModel")UserRegisterBindingModel userRegisterBindingModel,
                                        @RequestParam(name = "g-recaptcha-response") String gRecaptchaResponse,
                                        HttpServletRequest request, BindingResult binding) {
        if(binding.hasErrors()){
            return this.view("error/user-error");
        }

        if (this.recaptchaService
                .verifyRecaptcha(request.getRemoteAddr()
                        , gRecaptchaResponse) == null) {
            return this.view("/register");
        }

        if (!userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword())) {
            return this.view("error/user-error");
        }

        Set<User> users = this.userService.getAllUsers();
        for (User u: users) {
            if(u.getUsername().equals(userRegisterBindingModel.getUsername())){
                return this.view("error/user-error");
            }
        }

        try{
            this.userService.createUser(userRegisterBindingModel);
            return this.redirect("/login");}
            catch (Exception e)
        {
            return this.view("error/user-error");
        }

    }

    @GetMapping("/delete")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView delete(ModelAndView model) {
        model.addObject("user", this.userService.getCurrentUser());
        return this.view("user-delete", model);
    }

    @PostMapping("/delete")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView deleteProfile(ModelAndView model, HttpSession session) {
        WorkerProfile workerProfile = this.workerProfileService.findById(this.userService.getCurrentUser().getId()).orElse(null);
        WorkerRequirement workerRequirement = this.workerRequirementService.findById(this.userService.getCurrentUser().getId()).orElse(null);
        User user = this.userService.findById(workerRequirement.getId()).orElse(null);
        workerProfileService.delete(workerProfile);
        workerRequirementService.delete(workerRequirement);
        userService.delete(this.userService.getCurrentUser());
        session.invalidate();
        return this.redirect("/register");
    }

    @GetMapping("/delete-user")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView deleteUser(ModelAndView model) {
        Set<User> allUsers = this.userService.getAllUsers();

        Set<WorkerProfileServiceModel> workerProfile = this.workerProfileService.getAllWorkersProfile();
        Set<WorkerRequirementServiceModel> workerRequirement = this.workerRequirementService.getAllWorkersRequirements();

        model.addObject("allUsers", allUsers);
        model.addObject("workerProfile", workerProfile);
        model.addObject("workerRequirement", workerRequirement);

        return this.view("delete-user", model);
    }

    @PostMapping("/delete-user/{id}")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView deleteUserProcess(@PathVariable String id) {

        WorkerProfile workerProfile = this.workerProfileService.findById(id).orElse(null);
        WorkerRequirement workerRequirement = this.workerRequirementService.findById(id).orElse(null);
        User user = this.userService.findById(id).orElse(null);
        this.workerProfileService.delete(workerProfile);
        this.workerRequirementService.delete(workerRequirement);
        this.userService.delete(user);

        return this.redirect("/home");
    }
}
