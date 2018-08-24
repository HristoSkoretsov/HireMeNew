package org.ico.hireme.web.controllers;

import org.ico.hireme.domain.entities.WorkerProfile;
import org.ico.hireme.models.binding.WorkerProfileBindingModel;
import org.ico.hireme.models.view.WorkerProfileViewModel;
import org.ico.hireme.services.CloudinaryService;
import org.ico.hireme.services.UserService;
import org.ico.hireme.services.WorkerProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class WorkerProfileController extends BaseController {

    private final WorkerProfileService workerProfileService;
    private final ModelMapper modelMapper;
    private final CloudinaryService cloudinaryService;
    private final UserService userService;

    @Autowired
    public WorkerProfileController(WorkerProfileService workerProfileService, ModelMapper modelMapper, CloudinaryService cloudinaryService, UserService userService) {
        this.workerProfileService = workerProfileService;
        this.modelMapper = modelMapper;
        this.cloudinaryService = cloudinaryService;
        this.userService = userService;
    }

    @GetMapping("/user-profile")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView add(ModelAndView modelAndView) {
        WorkerProfileViewModel workerProfile1 = this.modelMapper.map(this.workerProfileService.getWorkerProfile(), WorkerProfileViewModel.class);
        WorkerProfileBindingModel workerProfileBindingModel = this.modelMapper.map(this.workerProfileService.getWorkerProfile(), WorkerProfileBindingModel.class);
        modelAndView.addObject("workerProfile1", workerProfile1);
        modelAndView.addObject("workerProfileBindingModel", workerProfileBindingModel);
        return this.view("user-profile", modelAndView);
    }

    @PostMapping("/user-profile")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView editProfile(WorkerProfile worker, @ModelAttribute WorkerProfileBindingModel workerProfileBindingModel) throws IOException {

        WorkerProfile workerProfile = workerProfileService.findById(this.userService.getCurrentUser().getId()).orElse(null);
        assert workerProfile != null;

        try {

        if (!workerProfileBindingModel.getEventPicture().isEmpty()) {
            String pictureUrl = this.cloudinaryService.uploadImage(workerProfileBindingModel.getEventPicture());
            workerProfile.setImage(pictureUrl);
        }
        workerProfile.setFirstName(worker.getFirstName());
        workerProfile.setCurrentJob(worker.getCurrentJob());
        workerProfile.setEmail(worker.getEmail());
        workerProfile.setAge(worker.getAge());
        workerProfile.setAdditionalInformation(worker.getAdditionalInformation());
        workerProfile.setPreviousJob1(worker.getPreviousJob1());
        workerProfile.setPreviousJob2(worker.getPreviousJob2());
        workerProfile.setGender(worker.getGender());
        workerProfile.setLastName(worker.getLastName());
        workerProfile.setTelephoneNumber(worker.getTelephoneNumber());
        workerProfileService.saveAndFlush(workerProfile);
        return this.redirect("/home"); }
        catch (Exception e){
           return this.view("error/user-profile-error");
        }
    }
}
