package org.ico.hireme.domain.entities;

import org.hibernate.annotations.GenericGenerator;
import org.ico.hireme.domain.enums.Region;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "company_profiles")
public class Company {

   @Id
   @GeneratedValue(generator = "UUID")
   @GenericGenerator(
           name = "UUID",
           strategy = "org.hibernate.id.UUIDGenerator"
   )
   @Column(name = "id", nullable = false, unique = true, updatable = false)
   private String id;

   @Column(name = "company_name", nullable = false)
   @Size(min=0, max=100)
   private String companyName;

   @Column(name = "email")
   private String email;

   @Column(name = "telephone_number", nullable = false)
   private String telephoneNumber;

   @Column(name = "image")
   private String image;

   @Enumerated(EnumType.STRING)
   private Region region;

   private String additionalInformation;

   public Company() {
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
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

   public String getAdditionalInformation() {
      return additionalInformation;
   }

   public void setAdditionalInformation(String additionalInformation) {
      this.additionalInformation = additionalInformation;
   }
}
