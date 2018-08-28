package org.ico.hireme.web.controllers;

import org.ico.hireme.domain.entities.User;
import org.ico.hireme.domain.entities.WorkerRequirement;
import org.ico.hireme.models.binding.CompanyBindingModel;
import org.ico.hireme.models.binding.WorkerRequirementBindingModel;
import org.ico.hireme.services.UserService;
import org.ico.hireme.services.WorkerRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class WorkerRequirementController extends BaseController {

    private final WorkerRequirementService workerRequirementService;
    private final UserService userService;

    @Autowired
    public WorkerRequirementController(WorkerRequirementService workerRequirementService, UserService userService) {
        this.workerRequirementService = workerRequirementService;
        this.userService = userService;
    }

    @GetMapping("/user-requirement")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView add(ModelAndView modelAndView) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String id = user.getId();
        WorkerRequirement workerRequirement = workerRequirementService.findById(id).orElse(null);
        assert workerRequirement != null;
        modelAndView.addObject("workerRequirement", workerRequirement);
        return this.view("user-requirement", modelAndView);
    }

    @PostMapping("/user-requirement")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView editProfile(WorkerRequirementBindingModel worker,  @Valid @ModelAttribute ("workerRequirement") WorkerRequirementBindingModel workerRequirementBinding,
                                    BindingResult binding) {

        if(binding.hasErrors()){
            return this.view("error/user-requirement-error");
        }

        WorkerRequirement workerRequirement = workerRequirementService.findById(this.userService.getCurrentUser().getId()).orElse(null);
        assert workerRequirement != null;
        try{
        workerRequirement.setJobCategory(worker.getJobCategory());
        workerRequirement.setExpectedJobLocation(worker.getExpectedJobLocation());
        workerRequirement.setExpectedWorkTime(worker.getExpectedWorkTime());
        workerRequirement.setExpectedStartingPosition(worker.getExpectedStartingPosition());
        workerRequirement.setExpectedSalary(worker.getExpectedSalary());
        workerRequirement.setAdditionalRequirements(worker.getAdditionalRequirements());
        workerRequirementService.saveAndFlush(workerRequirement);
        return this.redirect("/home");}
        catch (Exception e){
            return this.view("error/user-requirement-error");
        }
    }
}


