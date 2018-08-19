package org.ico.hireme.web.controllers;

import org.ico.hireme.models.binding.CompanyBindingModel;
import org.ico.hireme.models.view.CompanyViewModel;
import org.ico.hireme.services.CloudinaryService;
import org.ico.hireme.services.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class CompanyController extends BaseController{

    private final CompanyService companyService;
    private final CloudinaryService cloudinaryService;
    private final ModelMapper modelMapper;

    @Autowired
    public CompanyController(CompanyService companyService, CloudinaryService cloudinaryService, ModelMapper modelMapper) {
        this.companyService = companyService;
        this.cloudinaryService = cloudinaryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/create-company")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView create() {
        return this.view("create-company");
    }

    @PostMapping("/create-company")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView createProcess(ModelAndView model, @ModelAttribute CompanyBindingModel companyBindingModel) throws IOException {

        String pictureUrl = this.cloudinaryService.uploadImage(companyBindingModel.getEventPicture());

        if (pictureUrl == null) {
            throw new IllegalArgumentException("Event Picture upload failed.");
        }
        companyBindingModel.setImage(pictureUrl);
        this.companyService.createUser(companyBindingModel);
        return this.redirect("/");
    }

    @GetMapping("/all-companies")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView allCompanies(ModelAndView modelAndView) {

        Set<CompanyViewModel> companies = this.companyService
                .getAll()
                .stream()
                .map(x -> this.modelMapper.map(x, CompanyViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("companies", companies);
        return this.view("all-companies",modelAndView);
    }



}
