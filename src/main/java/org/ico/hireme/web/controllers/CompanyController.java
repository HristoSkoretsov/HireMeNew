package org.ico.hireme.web.controllers;

import org.ico.hireme.domain.entities.Company;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class CompanyController extends BaseController {

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

        if (!companyBindingModel.getEventPicture().isEmpty()) {
            String pictureUrl = this.cloudinaryService.uploadImage(companyBindingModel.getEventPicture());
            companyBindingModel.setImage(pictureUrl);
        }
        try {
            this.companyService.createUser(companyBindingModel);

        } catch (Exception e) {
            return this.view("error/company-error");
        }
        return this.redirect("/home");
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
        return this.view("all-companies", modelAndView);
    }

    @GetMapping("/delete-company")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView deleteCompanies(ModelAndView modelAndView) {

        Set<CompanyViewModel> companies = this.companyService
                .getAll()
                .stream()
                .map(x -> this.modelMapper.map(x, CompanyViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("companies", companies);
        return this.view("delete-company", modelAndView);
    }

    @GetMapping("/delete-company/{id}")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView deleteCompanyProcess(@PathVariable String id) {

        Company company = companyService.findById(id).orElse(null);
        this.companyService.deleteCompany(company);
        return this.redirect("/home");
    }


}
