package org.ico.hireme.services;

import org.ico.hireme.domain.entities.WorkerRequirement;
import org.ico.hireme.models.service.WorkerRequirementServiceModel;

import java.util.Optional;
import java.util.Set;

public interface WorkerRequirementService {
    Optional<WorkerRequirement> findById(String id);

    <S extends WorkerRequirement> S saveAndFlush(S s);

    void delete(WorkerRequirement workerRequirement);

    Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithArts();
    Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithEducation();
    Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithEngineering();
    Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithFinance();
    Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithGovernment();
    Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithHealth();
    Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithIt();
    Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithManagement();
    Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithPleasure();
    Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithSecurity();
    Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithServices();
    Set<WorkerRequirementServiceModel> getAllWorkersRequirementsWithOther();
}
