package org.ico.hireme.models.binding;

import javax.validation.constraints.Pattern;

public class UserRegisterBindingModel {

    //@Pattern(regexp = "[^<>]+")
    private String username;

    //@Pattern(regexp = "[^<>]+")
    private String password;

    //@Pattern(regexp = "[^<>]+")
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
