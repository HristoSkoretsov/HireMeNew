package org.ico.hireme.models.binding;

import org.ico.hireme.domain.enums.Region;
import org.springframework.web.multipart.MultipartFile;

public class CompanyBindingModel {

    private String companyName;

    private String email;

    private String telephoneNumber;

    private String image;

    private Region region;



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
}
