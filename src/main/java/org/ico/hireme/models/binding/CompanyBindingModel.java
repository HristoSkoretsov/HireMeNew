package org.ico.hireme.models.binding;

import org.ico.hireme.domain.enums.Region;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CompanyBindingModel {

    @Size(min=1, max=100)
    @Pattern(regexp = "[^<>]*")
    private String companyName;

    @Size(max = 30)
    @Pattern(regexp = "[^<>]*")
    private String email;

    @Size(min = 5, max = 15)
    @Pattern(regexp = "[0-9-+\\/ ]*")
    private String telephoneNumber;

    private String image;

    private Region region;

    @Size(max = 300)
    @Pattern(regexp = "[^<>]*")
    private String additionalInformation;

    private MultipartFile eventPicture;

    public CompanyBindingModel() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

     public MultipartFile getEventPicture() {
        return eventPicture;
    }

    public void setEventPicture(MultipartFile eventPicture) {
        this.eventPicture = eventPicture;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
