package org.ico.hireme.services;

import org.ico.hireme.domain.entities.*;
import org.ico.hireme.repositories.HireMeAppRepository;
import org.modelmapper.ModelMapper;
import org.ico.hireme.common.factories.UserRoleFactory;
import org.ico.hireme.models.binding.UserRegisterBindingModel;
import org.ico.hireme.repositories.UserRepository;
import org.ico.hireme.repositories.WorkerProfileRepository;
import org.ico.hireme.repositories.WorkerRequirementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ModelMapper modelMapper;

    private final UserRoleFactory userRoleFactory;

    private final WorkerProfileRepository workerProfileRepository;

    private final WorkerRequirementsRepository workerRequirementsRepository;

    private final HireMeAppRepository hireMeAppRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder, UserRoleFactory userRoleFactory, WorkerProfileRepository workerProfileRepository, WorkerRequirementsRepository workerRequirementsRepository, HireMeAppRepository hireMeAppRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRoleFactory = userRoleFactory;

        this.workerProfileRepository = workerProfileRepository;
        this.workerRequirementsRepository = workerRequirementsRepository;
        this.hireMeAppRepository = hireMeAppRepository;
    }

    @Override
    public boolean createUser(UserRegisterBindingModel userRegisterBindingModel) {
        User userEntity = this.modelMapper.map(userRegisterBindingModel, User.class);

        userEntity.setPassword(this.bCryptPasswordEncoder.encode(userEntity.getPassword()));

        Set<UserRole> authorities = new HashSet<>();

        if (this.userRepository.findAll().size()<2) {
         authorities.add(userRoleFactory.createUserRole("ADMIN"));
        } else {
            authorities.add(userRoleFactory.createUserRole("USER"));
        }
        userEntity.setAuthorities(authorities);
        WorkerProfile workerProfile = new WorkerProfile();
        workerProfile.setUser(userEntity);
        workerProfile.setViews(0L);
        WorkerRequirement workerRequirement = new WorkerRequirement();
        workerRequirement.setUser(userEntity);
        this.workerProfileRepository.save(workerProfile);
        this.workerRequirementsRepository.save(workerRequirement);

        return this.userRepository.save(userEntity) != null;
    }

    @Override
    public Set<User> getAllUsers() {
        return this
                .userRepository
                .findAll()
                .stream()
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public User findUserByUserName(String userName) {
        return this.userRepository.findByUsername(userName).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = this.userRepository
                .findByUsername(username)
                .orElse(null);

        if (foundUser == null) {
            throw new UsernameNotFoundException("Username not found.");
        }
        return foundUser;
    }

    @Override
    public void delete(User user) {
        this.userRepository.delete(user);
    }

    @Override
    public User getCurrentUser() {
        return (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Override
    public Optional<User> findById(String id) {
        return this.userRepository.findById(id);
    }

    @Scheduled(fixedDelay = 86400000)
    public void hireMeInfoSchedule() {
        String date = (new Date()).toString();
        int totalUsersInHireMe = this.userRepository.findAll().size();
        HireMeApp hireMeInfo = new HireMeApp();
        hireMeInfo.setDate(date);
        hireMeInfo.setTotalRegisteredUsers((long) totalUsersInHireMe);
        this.hireMeAppRepository.save(hireMeInfo);
    }

    @Scheduled(fixedDelay = 604800000)
    public void hireMeInfoDeleteWeeklySchedule() {
        List<HireMeApp> allInfo = this.hireMeAppRepository.findAll();
        this.hireMeAppRepository.deleteAll();
    }
}
