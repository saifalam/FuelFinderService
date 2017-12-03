package com.fuelfinder.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String accessToken;
    private String firstname;
    private String lastname;
    private String email;

    public User() {

    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}