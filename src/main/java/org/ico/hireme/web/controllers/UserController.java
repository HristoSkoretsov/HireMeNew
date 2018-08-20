package org.ico.hireme.web.controllers;

import org.ico.hireme.domain.entities.User;
import org.ico.hireme.domain.entities.WorkerProfile;
import org.ico.hireme.domain.entities.WorkerRequirement;
import org.ico.hireme.models.binding.UserRegisterBindingModel;
import org.ico.hireme.models.service.WorkerProfileServiceModel;
import org.ico.hireme.models.service.WorkerRequirementServiceModel;
import org.ico.hireme.services.UserService;
import org.ico.hireme.services.WorkerProfileService;
import org.ico.hireme.services.WorkerRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Set;

@Controller
public class UserController extends BaseController {

    private final UserService userService;
    private final WorkerProfileService workerProfileService;
    private final WorkerRequirementService workerRequirementService;

    @Autowired
    public UserController(UserService userService, WorkerProfileService workerProfileService, WorkerRequirementService workerRequirementService) {
        this.userService = userService;
        this.workerProfileService = workerProfileService;
        this.workerRequirementService = workerRequirementService;
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
    public ModelAndView deleteUser(ModelAndView model) {
        Set<User> allUsers = this.userService.getAllUsers();

        Set<WorkerProfileServiceModel> workerProfile = this.workerProfileService.getAllWorkersProfile();
        Set<WorkerRequirementServiceModel> workerRequirement = this.workerRequirementService.getAllWorkersRequirements();

        model.addObject("allUsers",allUsers);
        model.addObject("workerProfile",workerProfile);
        model.addObject("workerRequirement",workerRequirement);

        return this.view("delete-user",model);
    }

    @PostMapping("/delete-user/{id}")
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
