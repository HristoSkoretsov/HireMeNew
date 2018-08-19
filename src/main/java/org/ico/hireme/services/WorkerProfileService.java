package org.ico.hireme.services;

import org.ico.hireme.domain.entities.WorkerProfile;
import org.ico.hireme.models.service.WorkerProfileServiceModel;

import java.util.Optional;
import java.util.Set;

public interface WorkerProfileService {
    Optional<WorkerProfile> findById(String id);
    <S extends WorkerProfile> S saveAndFlush(S s);
    void delete(WorkerProfile workerProfile);
    boolean createUserProfile(WorkerProfileServiceModel workerProfileServiceModel);
     WorkerProfile getWorkerProfile();
    Set<WorkerProfileServiceModel> getAllWorkersProfileWithArts();
    Set<WorkerProfileServiceModel> getAllWorkersProfileWithEducation();
    Set<WorkerProfileServiceModel> getAllWorkersProfileWithEngineering();
    Set<WorkerProfileServiceModel> getAllWorkersProfileWithFinance();
    Set<WorkerProfileServiceModel> getAllWorkersProfileWithGovernment();
    Set<WorkerProfileServiceModel> getAllWorkersProfileWithHealth();
    Set<WorkerProfileServiceModel> getAllWorkersProfileWithIt();
    Set<WorkerProfileServiceModel> getAllWorkersProfileWithManagement();
    Set<WorkerProfileServiceModel> getAllWorkersProfileWithPleasure();
    Set<WorkerProfileServiceModel> getAllWorkersProfileWithSecurity();
    Set<WorkerProfileServiceModel> getAllWorkersProfileWithServices();
    Set<WorkerProfileServiceModel> getAllWorkersProfileWithOther();
}
