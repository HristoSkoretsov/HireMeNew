package org.ico.hireme.models.binding;

import org.hibernate.validator.constraints.Range;
import org.ico.hireme.domain.entities.User;
import org.ico.hireme.domain.enums.Gender;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class WorkerProfileBindingModel {

    @Size(min = 2, max = 15)
    @Pattern(regexp = "[^<>]*")
    private String firstName;

    @Size(min = 2, max = 15)
    @Pattern(regexp = "[^<>]*")
    private String lastName;

    @Range(min = 0, max = 100)
    @Nullable
    private Integer age;

    @Size(max = 50)
    @Pattern(regexp = "[^<>]*")
    @Nullable
    private String email;

    private MultipartFile eventPicture;

    @Pattern(regexp = "[0-9\\-+\\/ \\\\]*")
    @Size(max = 15)
    @Nullable
    private String telephoneNumber;

    private Long views;

    private Gender gender;

    @Size(max = 100)
    @Pattern(regexp = "[^<>]*")
    @Nullable
    private String currentJob;

    @Size(max = 100)
    @Pattern(regexp = "[^<>]*")
    @Nullable
    private String previousJob1;

    @Size(max = 100)
    @Pattern(regexp = "[^<>]*")
    @Nullable
    private String previousJob2;

    @Size(max = 400)
    @Pattern(regexp = "[^<>]*")
    @Nullable
    private String additionalInformation;

    private User user;

    private String id;

    public WorkerProfileBindingModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public MultipartFile getEventPicture() {
        return eventPicture;
    }

    public void setEventPicture(MultipartFile eventPicture) {
        this.eventPicture = eventPicture;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
