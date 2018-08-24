package org.ico.hireme.services;

public interface RecaptchaService {

    String verifyRecaptcha(String userIpAddress, String gRecaptchaResponse);
}
