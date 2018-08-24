package org.ico.hireme.services;

import org.ico.hireme.domain.entities.WorkerRequirement;
import org.ico.hireme.models.service.WorkerRequirementServiceModel;
import org.ico.hireme.repositories.WorkerRequirementsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WorkerRequirementServiceImpl implements WorkerRequirementService  {

    private final WorkerRequirementsRepository workerRequirementsRepository;
    private final ModelMapper modelMapper;

    public WorkerRequirementServiceImpl(WorkerRequirementsRepository workerRequirementsRepository, ModelMapper modelMapper) {
        this.workerRequirementsRepository = workerRequirementsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<WorkerRequirement> findById(String id) {
        return this.workerRequirementsRepository.findById(id);
    }

    @Override
    public <S extends WorkerRequirement> S saveAndFlush(S s) {
        return this.workerRequirementsRepository.saveAndFlush(s);
    }

    @Override
    public void delete(WorkerRequirement workerRequirement) {
        this.workerRequirementsRepository.delete(workerRequirement);
    }

    @Override
    public Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithArts() {
        return this.workerRequirementsRepository
                .getsAllWorkerRequirementsWithArts()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithEducation() {
        return this.workerRequirementsRepository
                .getsAllWorkerRequirementsWithEducation()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithEngineering() {
        return this.workerRequirementsRepository
                .getsAllWorkerRequirementsWithEngineering()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithFinance() {
        return this.workerRequirementsRepository
                .getsAllWorkerRequirementsWithFinance()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithGovernment() {
        return this.workerRequirementsRepository
                .getsAllWorkerRequirementsWithGovernment()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithHealth() {
        return this.workerRequirementsRepository
                .getsAllWorkerRequirementsWithHealth()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithIt() {
        return this.workerRequirementsRepository
                .getsAllWorkerRequirementsWithIt()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithManagement() {
        return this.workerRequirementsRepository
                .getsAllWorkerRequirementsWithManagement()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithPleasure() {
        return this.workerRequirementsRepository
                .getsAllWorkerRequirementsWithManagement()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithSecurity() {
        return this.workerRequirementsRepository
                .getsAllWorkerRequirementsWithSecurity()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithServices() {
        return this.workerRequirementsRepository
                .getsAllWorkerRequirementsWithServices()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithOther() {
        return this.workerRequirementsRepository
                .getsAllWorkerRequirementsWithOther()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<WorkerRequirementServiceModel> getAllWorkersRequirements() {
        return this.workerRequirementsRepository
                .findAll()
                .stream()
                .map(x -> this.modelMapper.map(x, WorkerRequirementServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }


}
