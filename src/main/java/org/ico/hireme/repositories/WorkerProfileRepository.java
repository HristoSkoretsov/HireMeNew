package org.ico.hireme.repositories;


import org.ico.hireme.domain.entities.WorkerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface WorkerProfileRepository extends JpaRepository<WorkerProfile, String> {
    Optional<WorkerProfile> findById(String id);

    @Override
    <S extends WorkerProfile> S saveAndFlush(S s);

    @Override
    void delete(WorkerProfile workerProfile);

    @Query(
            value = "SELECT * FROM worker_profiles AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'ARTS'",
            nativeQuery = true)
    Set<WorkerProfile> getsAllWorkerProfilesWithArts ();

    @Query(
            value = "SELECT * FROM worker_profiles AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'EDUCATION'",
            nativeQuery = true)
    Set<WorkerProfile> getsAllWorkerProfilesWithEducation ();

    @Query(
            value = "SELECT * FROM worker_profiles AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'ENGINEERING'",
            nativeQuery = true)
    Set<WorkerProfile> getsAllWorkerProfilesWithEngineering ();

    @Query(
            value = "SELECT * FROM worker_profiles AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'FINANCE'",
            nativeQuery = true)
    Set<WorkerProfile> getsAllWorkerProfilesWithFinance ();

    @Query(
            value = "SELECT * FROM worker_profiles AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'GOVERNMENT'",
            nativeQuery = true)
    Set<WorkerProfile> getsAllWorkerProfilesWithGovernment ();

    @Query(
            value = "SELECT * FROM worker_profiles AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'HEALTH'",
            nativeQuery = true)
    Set<WorkerProfile> getsAllWorkerProfilesWithHealth ();

    @Query(
            value = "SELECT * FROM worker_profiles AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'IT'",
            nativeQuery = true)
    Set<WorkerProfile> getsAllWorkerProfilesWithIt ();

    @Query(
            value = "SELECT * FROM worker_profiles AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'MANAGEMENT'",
            nativeQuery = true)
    Set<WorkerProfile> getsAllWorkerProfilesWithManagement ();

    @Query(
            value = "SELECT * FROM worker_profiles AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'PLEASURE'",
            nativeQuery = true)
    Set<WorkerProfile> getsAllWorkerProfilesWithPleasure ();

    @Query(
            value = "SELECT * FROM worker_profiles AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'SECURITY'",
            nativeQuery = true)
    Set<WorkerProfile> getsAllWorkerProfilesWithSecurity ();

    @Query(
            value = "SELECT * FROM worker_profiles AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'SERVICES'",
            nativeQuery = true)
    Set<WorkerProfile> getsAllWorkerProfilesWithServices ();

    @Query(
            value = "SELECT * FROM worker_profiles AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'OTHER'",
            nativeQuery = true)
    Set<WorkerProfile> getsAllWorkerProfilesWithOther ();

}
