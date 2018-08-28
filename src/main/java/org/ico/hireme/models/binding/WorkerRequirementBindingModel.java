package org.ico.hireme.models.binding;

import org.hibernate.validator.constraints.Range;
import org.ico.hireme.domain.enums.JobCategory;
import org.ico.hireme.domain.enums.Position;
import org.ico.hireme.domain.enums.Region;
import org.ico.hireme.domain.enums.WorkTime;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class WorkerRequirementBindingModel {

    @Range(min = 0, max = 100000)
    @Nullable
    private BigDecimal expectedSalary;

    private Region expectedJobLocation;

    private WorkTime expectedWorkTime;

    private Position expectedStartingPosition;

    @Pattern(regexp = "[^<>]+")
    @Size(max = 400)
    @Nullable
     private String additionalRequirements;

    private JobCategory jobCategory;

    public WorkerRequirementBindingModel() {
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

    public JobCategory getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(JobCategory jobCategory) {
        this.jobCategory = jobCategory;
    }
}
