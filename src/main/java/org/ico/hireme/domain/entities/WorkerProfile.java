package org.ico.hireme.domain.entities;

import org.hibernate.annotations.GenericGenerator;
import org.ico.hireme.domain.enums.Gender;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "worker_profiles")
public class WorkerProfile {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private String id;

    @Column(name = "first_name")
//    @Size(min = 2, max = 15)
//    @Pattern(regexp = "[^<>]+")
    private String firstName;

    @Column(name = "last_name")
//    @Size(min = 2, max = 15)
    //@Pattern(regexp = "[^<>]+")
    private String lastName;


    private Integer age;

//    @Size(max = 50)
    //@Pattern(regexp = "[^<>]+")
//    @Nullable
    private String email;

    private String image;

    //@Pattern(regexp = "[0-9\\-+\\/ \\\\]+")
//    @Size(max = 15)
    @Column(name = "telephone_number", nullable = true)
    private String telephoneNumber;

    private Long views = 0L;

    @Enumerated(EnumType.STRING)
    private Gender gender;

//    @Size(max = 100)
    //@Pattern(regexp = "[^<>]+")
//    @Nullable
    private String currentJob;

//    @Size(max = 100)
    //@Pattern(regexp = "^[^<>]+$")
    private String previousJob1;

//    @Size(max = 100)
    //@Pattern(regexp = "[^<>]+")

    private String previousJob2;

//    @Size(max = 400)
    //@Pattern(regexp = "[^<>]+")
    private String additionalInformation;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId
    private User user;

    public WorkerProfile() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
