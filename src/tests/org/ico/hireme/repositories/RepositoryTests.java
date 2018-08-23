package org.ico.hireme.repositories;

import org.ico.hireme.domain.entities.User;
import org.ico.hireme.domain.entities.WorkerProfile;
import org.ico.hireme.domain.entities.WorkerRequirement;
import org.ico.hireme.domain.enums.JobCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class RepositoryTests {

    @Autowired
    private WorkerRequirementsRepository workerRequirementsRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WorkerProfileRepository workerProfileRepository;

    @Test
    public void testFindBySubstring_givenSubstring_shouldFindTwoUsers() {

        // arrange
        WorkerRequirement nikiR = new WorkerRequirement();
        nikiR.setExpectedSalary(BigDecimal.valueOf(1234));
        nikiR.setJobCategory(JobCategory.ARTS);


        WorkerRequirement bobiR = new WorkerRequirement();
        bobiR.setExpectedSalary(BigDecimal.valueOf(1234));
        bobiR.setJobCategory(JobCategory.IT);

        WorkerRequirement goshoR = new WorkerRequirement();
        goshoR.setExpectedSalary(BigDecimal.valueOf(1234));
        goshoR.setJobCategory(JobCategory.ARTS);

        User niki = new User();
        this.userRepository.saveAndFlush(niki);
        User bobi = new User();
        this.userRepository.saveAndFlush(niki);
        User gosho = new User();
        this.userRepository.saveAndFlush(gosho);

        //account_non_expired, account_non_locked, credentials_non_expired, enabled, password, username, id

        nikiR.setUser(niki);
        bobiR.setUser(bobi);
        bobiR.setUser(gosho);

        this.workerRequirementsRepository.saveAndFlush(nikiR);
        this.workerRequirementsRepository.saveAndFlush(bobiR);
        this.workerRequirementsRepository.saveAndFlush(bobiR);

        WorkerProfile goshoP = new WorkerProfile();
        goshoP.setUser(gosho);

        WorkerProfile bobiP = new WorkerProfile();
        bobiP.setUser(bobi);
        WorkerProfile nikiP = new WorkerProfile();
        nikiP.setUser(niki);
        this.workerProfileRepository.save(goshoP);
        this.workerProfileRepository.save(nikiP);
        this.workerProfileRepository.save(bobiP);



        // act
        Set<WorkerRequirement> result = this.workerRequirementsRepository.getsAllWorkerRequirementsWithArts();

        // assert
        assertEquals("niki,gosho", String.join(",",result.stream().map(WorkerRequirement::getJobCategory).toString()));
    }
}
