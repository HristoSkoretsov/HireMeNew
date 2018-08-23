package org.ico.hireme.web.controllers;

import org.ico.hireme.domain.entities.WorkerProfile;
import org.ico.hireme.domain.entities.WorkerRequirement;
import org.ico.hireme.services.UserService;
import org.ico.hireme.services.WorkerProfileService;
import org.ico.hireme.services.WorkerRequirementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController extends BaseController{

    private final UserService userService;
    private final WorkerProfileService workerProfileService;
    private final WorkerRequirementService workerRequirementService;
    private final ModelMapper modelMapper;

    @Autowired
    public ProfileController(UserService userService, WorkerProfileService workerProfileService,
                             WorkerRequirementService workerRequirementService, ModelMapper modelMapper) {
        this.userService = userService;
        this.workerProfileService = workerProfileService;
        this.workerRequirementService = workerRequirementService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/user-details/{id}")
    public ModelAndView userDetails(ModelAndView model, @PathVariable String id) {

        WorkerProfile workerProfile = this.workerProfileService.findById(id).orElse(null);
        WorkerRequirement workerRequirement = this.workerRequirementService.findById(id).orElse(null);
        workerProfile.setViews(workerProfile.getViews()+1);
        this.workerProfileService.saveAndFlush(workerProfile);
        String category = workerRequirement.getJobCategory().toString();
        model.addObject("workerProfile",workerProfile);
        model.addObject("workerRequirement",workerRequirement);
        model.addObject("category",category);

        return this.view("user-details",model);
    }



}
