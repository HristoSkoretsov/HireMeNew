package org.ico.hireme.repositories;

import org.ico.hireme.domain.entities.WorkerRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface WorkerRequirementsRepository extends JpaRepository<WorkerRequirement, String> {

    Optional<WorkerRequirement> findById(String id);

    @Override
    void delete(WorkerRequirement workerRequirement);

    @Query(
            value = "SELECT * FROM worker_requirements AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'ARTS'",
            nativeQuery = true)
    Set<WorkerRequirement> getsAllWorkerRequirementsWithArts ();

    @Query(
            value = "SELECT * FROM worker_requirements AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'EDUCATION'",
            nativeQuery = true)
    Set<WorkerRequirement> getsAllWorkerRequirementsWithEducation ();

    @Query(
            value = "SELECT * FROM worker_requirements AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'ENGINEERING'",
            nativeQuery = true)
    Set<WorkerRequirement> getsAllWorkerRequirementsWithEngineering ();

    @Query(
            value = "SELECT * FROM worker_requirements AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'FINANCE'",
            nativeQuery = true)
    Set<WorkerRequirement> getsAllWorkerRequirementsWithFinance ();

    @Query(
            value = "SELECT * FROM worker_requirements AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'GOVERNMENT'",
            nativeQuery = true)
    Set<WorkerRequirement> getsAllWorkerRequirementsWithGovernment ();

    @Query(
            value = "SELECT * FROM worker_requirements AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'HEALTH'",
            nativeQuery = true)
    Set<WorkerRequirement> getsAllWorkerRequirementsWithHealth ();

    @Query(
            value = "SELECT * FROM worker_requirements AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'IT'",
            nativeQuery = true)
    Set<WorkerRequirement> getsAllWorkerRequirementsWithIt ();

    @Query(
            value = "SELECT * FROM worker_requirements AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'MANAGEMENT'",
            nativeQuery = true)
    Set<WorkerRequirement> getsAllWorkerRequirementsWithManagement ();

    @Query(
            value = "SELECT * FROM worker_requirements AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'PLEASURE'",
            nativeQuery = true)
    Set<WorkerRequirement> getsAllWorkerRequirementsWithPleasure ();

    @Query(
            value = "SELECT * FROM worker_requirements AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'SECURITY'",
            nativeQuery = true)
    Set<WorkerRequirement> getsAllWorkerRequirementsWithSecurity ();

    @Query(
            value = "SELECT * FROM worker_requirements AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'SERVICES'",
            nativeQuery = true)
    Set<WorkerRequirement> getsAllWorkerRequirementsWithServices ();

    @Query(
            value = "SELECT * FROM worker_requirements AS wp\n" +
                    "JOIN worker_requirements AS wr ON wr.user_id=wp.user_id\n" +
                    "WHERE wr.job_category = 'OTHER'",
            nativeQuery = true)
    Set<WorkerRequirement> getsAllWorkerRequirementsWithOther ();


}
