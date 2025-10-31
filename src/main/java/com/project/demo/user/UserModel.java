package com.project.demo.user;

// The User.java class directly represents app_user database rows

public class UserModel {

    private Long id;
    private String username;
    private String passwordHash;
    private String email;
    private String firstName;
    private String lastName;
    private String ssn;


    public UserModel() {

    }


    public UserModel(String username, String passwordHash, String email, String firstName, String lastName, String ssn) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }

}

