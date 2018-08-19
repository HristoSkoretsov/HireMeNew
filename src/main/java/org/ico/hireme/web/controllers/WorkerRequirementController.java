package org.ico.hireme.web.controllers;

import org.ico.hireme.domain.entities.User;
import org.ico.hireme.domain.entities.WorkerRequirement;
import org.ico.hireme.models.binding.WorkerRequirementBindingModel;
import org.ico.hireme.services.UserService;
import org.ico.hireme.services.WorkerRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView add(ModelAndView modelAndView) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String id = user.getId();
        WorkerRequirement workerRequirement = workerRequirementService.findById(id).orElse(null);
        assert workerRequirement != null;
        modelAndView.addObject("workerRequirement", workerRequirement);
        return this.view("user-requirement", modelAndView);
    }

    @PostMapping("/user-requirement")
    public ModelAndView editProfile(WorkerRequirementBindingModel worker) {

        WorkerRequirement workerRequirement = workerRequirementService.findById(this.userService.getCurrentUser().getId()).orElse(null);
        assert workerRequirement != null;
        workerRequirement.setJobCategory(worker.getJobCategory());
        workerRequirement.setExpectedJobLocation(worker.getExpectedJobLocation());
        workerRequirement.setExpectedWorkTime(worker.getExpectedWorkTime());
        workerRequirement.setExpectedStartingPosition(worker.getExpectedStartingPosition());
        workerRequirement.setExpectedSalary(worker.getExpectedSalary());
        workerRequirement.setAdditionalRequirements(worker.getAdditionalRequirements());
        workerRequirementService.saveAndFlush(workerRequirement);
        return this.redirect("/home");
    }
}


