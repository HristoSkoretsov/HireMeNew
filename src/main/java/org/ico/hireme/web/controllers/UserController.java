package org.ico.hireme.web.controllers;

import org.ico.hireme.domain.entities.WorkerProfile;
import org.ico.hireme.domain.entities.WorkerRequirement;
import org.ico.hireme.models.binding.UserRegisterBindingModel;
import org.ico.hireme.models.view.WorkerProfileViewModel;
import org.ico.hireme.models.view.WorkerRequirementViewModel;
import org.ico.hireme.services.UserService;
import org.ico.hireme.services.WorkerProfileService;
import org.ico.hireme.services.WorkerRequirementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class UserController extends BaseController {

    private final UserService userService;
    private final WorkerProfileService workerProfileService;
    private final WorkerRequirementService workerRequirementService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, WorkerProfileService workerProfileService, WorkerRequirementService workerRequirementService, ModelMapper modelMapper) {
        this.userService = userService;
        this.workerProfileService = workerProfileService;
        this.workerRequirementService = workerRequirementService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    @PreAuthorize("isAnonymous()")
    public ModelAndView login() {
        return this.view("login");
    }

    @GetMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ModelAndView register() {
        return this.view("register");
    }

    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
      public ModelAndView registerConfirm(@ModelAttribute UserRegisterBindingModel userRegisterBindingModel) {
        if (!userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword())) {
            return this.view("register");
        }
        this.userService.createUser(userRegisterBindingModel);
        return this.redirect("/login");
    }

    @GetMapping("/delete")
    public ModelAndView delete(ModelAndView model) {
        model.addObject("user", this.userService.getCurrentUser());
        return this.view("user-delete", model);
    }

    @PostMapping("/delete")
    public ModelAndView deleteProfile(ModelAndView model) {
        WorkerProfile workerProfile = this.workerProfileService.findById(this.userService.getCurrentUser().getId()).orElse(null);
        WorkerRequirement workerRequirement = this.workerRequirementService.findById(this.userService.getCurrentUser().getId()).orElse(null);
        workerProfileService.delete(workerProfile);
        workerRequirementService.delete(workerRequirement);
        userService.delete(this.userService.getCurrentUser());
        return this.view("register");
    }

}
