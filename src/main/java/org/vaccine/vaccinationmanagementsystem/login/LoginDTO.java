package org.vaccine.vaccinationmanagementsystem.login;

public class LoginDTO {

    private String email;

    private String password;


// Constructors

    public LoginDTO() {}


    public LoginDTO(String email, String password) {

        this.email = email;

        this.password = password;

    }


// Getters and Setters

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }


    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

}
