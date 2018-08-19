package org.ico.hireme.models.view;

import org.ico.hireme.domain.enums.JobCategory;
import org.ico.hireme.domain.enums.Position;
import org.ico.hireme.domain.enums.Region;
import org.ico.hireme.domain.enums.WorkTime;

import java.math.BigDecimal;

public class WorkerRequirementViewModel {
    private BigDecimal expectedSalary;

    private Region expectedJobLocation;

    private WorkTime expectedWorkTime;

    private Position expectedStartingPosition;

    private String additionalRequirements;

    private JobCategory jobCategory;

    public WorkerRequirementViewModel() {
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
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public JobCategory getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(JobCategory jobCategory) {
        this.jobCategory = jobCategory;
    }


}
