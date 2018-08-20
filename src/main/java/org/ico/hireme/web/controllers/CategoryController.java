package org.ico.hireme.web.controllers;

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
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class CategoryController extends BaseController {

    private final UserService userService;
    private final WorkerProfileService workerProfileService;
    private final WorkerRequirementService workerRequirementService;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryController(UserService userService, WorkerProfileService workerProfileService, WorkerRequirementService workerRequirementService, ModelMapper modelMapper) {
        this.userService = userService;
        this.workerProfileService = workerProfileService;
        this.workerRequirementService = workerRequirementService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/users-art")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView artsWorkers(ModelAndView modelAndView) {

        Set<WorkerProfileViewModel> workersArtProfiles = this.workerProfileService
                .getAllWorkersProfileWithArts()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerProfileArt", workersArtProfiles);
        Set<WorkerRequirementViewModel> workersArtRequirements = this.workerRequirementService
                .getAllWorkersRequirementsWithArts()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerRequirementsArt", workersArtRequirements);

        return this.view("categories/all-arts",modelAndView);
    }

    @GetMapping("/users-education")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView educationWorkers(ModelAndView modelAndView) {

        Set<WorkerProfileViewModel> workersEducationProfiles = this.workerProfileService
                .getAllWorkersProfileWithEducation()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerProfileEducation", workersEducationProfiles);
        Set<WorkerRequirementViewModel> workersEducationRequirements = this.workerRequirementService
                .getAllWorkersRequirementsWithEducation()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerRequirementsEducation", workersEducationRequirements);

        return this.view("categories/all-education",modelAndView);
    }

    @GetMapping("/users-engineering")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView engineeringWorkers(ModelAndView modelAndView) {

        Set<WorkerProfileViewModel> workersEngineeringProfiles = this.workerProfileService
                .getAllWorkersProfileWithEngineering()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerProfileEngineering", workersEngineeringProfiles);
        Set<WorkerRequirementViewModel> workersEngineeringRequirements = this.workerRequirementService
                .getAllWorkersRequirementsWithEngineering()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerRequirementsEngineering", workersEngineeringRequirements);

        return this.view("categories/all-engineering",modelAndView);
    }

    @GetMapping("/users-finance")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView financeWorkers(ModelAndView modelAndView) {

        Set<WorkerProfileViewModel> workersFinanceProfiles = this.workerProfileService
                .getAllWorkersProfileWithFinance()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerProfileFinance", workersFinanceProfiles);
        Set<WorkerRequirementViewModel> workersFinanceRequirements = this.workerRequirementService
                .getAllWorkersRequirementsWithFinance()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerRequirementsFinance", workersFinanceRequirements);

        return this.view("categories/all-finance",modelAndView);
    }

    @GetMapping("/users-government")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView governmentWorkers(ModelAndView modelAndView) {

        Set<WorkerProfileViewModel> workersGovernmentProfiles = this.workerProfileService
                .getAllWorkersProfileWithGovernment()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerProfileGovernment", workersGovernmentProfiles);
        Set<WorkerRequirementViewModel> workersGovernmentRequirements = this.workerRequirementService
                .getAllWorkersRequirementsWithGovernment()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerRequirementsGovernment", workersGovernmentRequirements);

        return this.view("categories/all-government",modelAndView);
    }

    @GetMapping("/users-health")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView healthWorkers(ModelAndView modelAndView) {

        Set<WorkerProfileViewModel> workersHealthProfiles = this.workerProfileService
                .getAllWorkersProfileWithHealth()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerProfileHealth", workersHealthProfiles);
        Set<WorkerRequirementViewModel> workersHealthRequirements = this.workerRequirementService
                .getAllWorkersRequirementsWithHealth()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerRequirementsHealth", workersHealthRequirements);

        return this.view("categories/all-health",modelAndView);
    }

    @GetMapping("/users-it")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView itWorkers(ModelAndView modelAndView) {

        Set<WorkerProfileViewModel> workersItProfiles = this.workerProfileService
                .getAllWorkersProfileWithIt()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerProfileIt", workersItProfiles);
        Set<WorkerRequirementViewModel> workersItRequirements = this.workerRequirementService
                .getAllWorkersRequirementsWithIt()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerRequirementsIt", workersItRequirements);

        return this.view("categories/all-it",modelAndView);
    }

    @GetMapping("/users-management")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView managementWorkers(ModelAndView modelAndView) {

        Set<WorkerProfileViewModel> workersManagementProfiles = this.workerProfileService
                .getAllWorkersProfileWithManagement()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerProfileManagement", workersManagementProfiles);
        Set<WorkerRequirementViewModel> workersManagementRequirements = this.workerRequirementService
                .getAllWorkersRequirementsWithManagement()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerRequirementsManagement", workersManagementRequirements);

        return this.view("categories/all-management",modelAndView);
    }

    @GetMapping("/users-pleasure")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView pleasureWorkers(ModelAndView modelAndView) {

        Set<WorkerProfileViewModel> workersPleasureProfiles = this.workerProfileService
                .getAllWorkersProfileWithPleasure()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerProfilePleasure", workersPleasureProfiles);
        Set<WorkerRequirementViewModel> workersPleasureRequirements = this.workerRequirementService
                .getAllWorkersRequirementsWithPleasure()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerRequirementsManagement", workersPleasureRequirements);

        return this.view("categories/all-pleasure",modelAndView);
    }

    @GetMapping("/users-security")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView securityWorkers(ModelAndView modelAndView) {

        Set<WorkerProfileViewModel> workersSecurityProfiles = this.workerProfileService
                .getAllWorkersProfileWithSecurity()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerProfileSecurity", workersSecurityProfiles);
        Set<WorkerRequirementViewModel> workersSecurityRequirements = this.workerRequirementService
                .getAllWorkersRequirementsWithSecurity()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerRequirementsSecurity", workersSecurityRequirements);

        return this.view("categories/all-security",modelAndView);
    }

    @GetMapping("/users-service")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView serviceWorkers(ModelAndView modelAndView) {

        Set<WorkerProfileViewModel> workersServiceProfiles = this.workerProfileService
                .getAllWorkersProfileWithServices()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerProfileService", workersServiceProfiles);
        Set<WorkerRequirementViewModel> workersServiceRequirements = this.workerRequirementService
                .getAllWorkersRequirementsWithServices()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerRequirementsService", workersServiceRequirements);

        return this.view("categories/all-service",modelAndView);
    }

    @GetMapping("/users-other")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView otherWorkers(ModelAndView modelAndView) {

        Set<WorkerProfileViewModel> workersOtherProfiles = this.workerProfileService
                .getAllWorkersProfileWithOther()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerProfileOther", workersOtherProfiles);
        Set<WorkerRequirementViewModel> workersOtherRequirements = this.workerRequirementService
                .getAllWorkersRequirementsWithOther()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementViewModel.class))
                .collect(Collectors.toUnmodifiableSet());
        modelAndView.addObject("workerRequirementsOther", workersOtherRequirements);

        return this.view("categories/all-other",modelAndView);
    }
}
