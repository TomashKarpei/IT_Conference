package com.zadanie.IT_Conference.user;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class UserDTO {
    private String userFirstName;
    private String userLastName;
    private String userLogin;
    private String userEmail;

    public UserDTO(){

    }
    public UserDTO(String userFirstName, String userLastName, String userLogin, String userEmail) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userLogin = userLogin;
        this.userEmail = userEmail;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

//    public String getUserPassword() {
//        return userPassword;
//    }
//
//    public void setUserPassword(String userPassword) {
//        this.userPassword = userPassword;
//    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

}
