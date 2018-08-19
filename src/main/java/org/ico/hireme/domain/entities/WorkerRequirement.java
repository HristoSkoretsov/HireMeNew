package org.ico.hireme.domain.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Range;
import org.ico.hireme.domain.enums.JobCategory;
import org.ico.hireme.domain.enums.Position;
import org.ico.hireme.domain.enums.Region;
import org.ico.hireme.domain.enums.WorkTime;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "worker_requirements")
public class WorkerRequirement {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private String id;

    @Range(min = 0, max = 100000)
    private BigDecimal expectedSalary;

    @Enumerated(EnumType.STRING)
    private Region expectedJobLocation;

    @Enumerated(EnumType.STRING)
    private WorkTime expectedWorkTime;

    @Enumerated(EnumType.STRING)
    private Position expectedStartingPosition;

    @Size(min=2, max=2000)
    private String additionalRequirements;

    @Enumerated(EnumType.STRING)
    private JobCategory jobCategory;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId
    private User user;

    public WorkerRequirement() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(BigDecimal expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public Region getExpectedJobLocation() {
        return expectedJobLocation;
    }

    public void setExpectedJobLocation(Region expectedJobLocation) {
        this.expectedJobLocation = expectedJobLocation;
    }

    public WorkTime getExpectedWorkTime() {
        return expectedWorkTime;
    }

    public void setExpectedWorkTime(WorkTime expectedWorkTime) {
        this.expectedWorkTime = expectedWorkTime;
    }

    public Position getExpectedStartingPosition() {
        return expectedStartingPosition;
    }

    public void setExpectedStartingPosition(Position expectedStartingPosition) {
        this.expectedStartingPosition = expectedStartingPosition;
    }

    public String getAdditionalRequirements() {
        return additionalRequirements;
    }

    public void setAdditionalRequirements(String additionalRequirements) {
        this.additionalRequirements = additionalRequirements;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public JobCategory getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(JobCategory jobCategory) {
        this.jobCategory = jobCategory;
    }
}
