package org.ico.hireme.services;

import org.ico.hireme.domain.entities.User;
import org.ico.hireme.domain.entities.WorkerProfile;
import org.ico.hireme.models.service.WorkerProfileServiceModel;
import org.ico.hireme.repositories.WorkerProfileRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WorkerProfileImpl implements WorkerProfileService {

    private final WorkerProfileRepository workerProfileRepository;
    private final ModelMapper modelMapper;

    public WorkerProfileImpl(WorkerProfileRepository workerProfileRepository, ModelMapper modelMapper) {
        this.workerProfileRepository = workerProfileRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<WorkerProfile> findById(String id) {
        return this.workerProfileRepository.findById(id);
    }

    @Override
    public <S extends WorkerProfile> S saveAndFlush(S s) {
      return this.workerProfileRepository.saveAndFlush(s);
    }

    @Override
    public void delete(WorkerProfile workerProfile) {
        this.workerProfileRepository.delete(workerProfile);
    }

    @Override
    public boolean createUserProfile(WorkerProfileServiceModel workerProfileServiceModel) {
        WorkerProfile workerEntity = this.modelMapper.map(workerProfileServiceModel, WorkerProfile.class);

        try {
            this.workerProfileRepository.save(workerEntity);
        } catch (Exception ignored) {

            return false;
        }

        return true;
    }

    @Override
    public WorkerProfile getWorkerProfile() {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String id = user.getId();
        WorkerProfile workerProfile = findById(id).orElse(null);
        assert workerProfile != null;
        return workerProfile;
    }

    @Override
    public Set<WorkerProfileServiceModel> getAllWorkersProfileWithArts() {
        return this.workerProfileRepository
                .getsAllWorkerProfilesWithArts()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerProfileServiceModel> getAllWorkersProfileWithEducation() {
        return this.workerProfileRepository
                .getsAllWorkerProfilesWithEducation()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerProfileServiceModel> getAllWorkersProfileWithEngineering() {
        return this.workerProfileRepository
                .getsAllWorkerProfilesWithEngineering()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerProfileServiceModel> getAllWorkersProfileWithFinance() {
        return this.workerProfileRepository
                .getsAllWorkerProfilesWithFinance()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerProfileServiceModel> getAllWorkersProfileWithGovernment() {
        return this.workerProfileRepository
                .getsAllWorkerProfilesWithGovernment()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerProfileServiceModel> getAllWorkersProfileWithHealth() {
        return this.workerProfileRepository
                .getsAllWorkerProfilesWithHealth()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerProfileServiceModel> getAllWorkersProfileWithIt() {
        return this.workerProfileRepository
                .getsAllWorkerProfilesWithIt()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerProfileServiceModel> getAllWorkersProfileWithManagement() {
        return this.workerProfileRepository
                .getsAllWorkerProfilesWithManagement()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerProfileServiceModel> getAllWorkersProfileWithPleasure() {
        return this.workerProfileRepository
                .getsAllWorkerProfilesWithPleasure()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerProfileServiceModel> getAllWorkersProfileWithSecurity() {
        return this.workerProfileRepository
                .getsAllWorkerProfilesWithSecurity()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerProfileServiceModel> getAllWorkersProfileWithServices() {
        return this.workerProfileRepository
                .getsAllWorkerProfilesWithServices()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerProfileServiceModel> getAllWorkersProfileWithOther() {
        return this.workerProfileRepository
                .getsAllWorkerProfilesWithOther()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerProfileServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }


}
