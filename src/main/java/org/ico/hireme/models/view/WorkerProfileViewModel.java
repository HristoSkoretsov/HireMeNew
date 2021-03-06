package org.ico.hireme.models.view;

import org.ico.hireme.domain.enums.Gender;
import org.ico.hireme.domain.enums.JobCategory;

public class WorkerProfileViewModel {

    private String firstName;

    private String lastName;

    private Integer age;

    private String email;

    private String image;

    private String telephoneNumber;

    private Long views;

    private JobCategory jobCategory;

    private Gender gender;

    private String currentJob;

    private String previousJob1;

    private String previousJob2;

   private String additionalInformation;

   private String id;

    public WorkerProfileViewModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public JobCategory getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(JobCategory jobCategory) {
        this.jobCategory = jobCategory;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(String currentJob) {
        this.currentJob = currentJob;
    }

    public String getPreviousJob1() {
        return previousJob1;
    }

    public void setPreviousJob1(String previousJob1) {
        this.previousJob1 = previousJob1;
    }

    public String getPreviousJob2() {
        return previousJob2;
    }

    public void setPreviousJob2(String previousJob2) {
        this.previousJob2 = previousJob2;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
