package org.vaccine.vaccinationmanagementsystem.user;

public class UserRegistrationDTO {

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String address;

    private String city;

    private String state;

    private String pincode;
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

// Constructors

    public UserRegistrationDTO() {}


// Getters and Setters

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }


    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }


    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }


    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }


    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }


    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }


    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }


    public String getState() { return state; }

    public void setState(String state) { this.state = state; }


    public String getPincode() { return pincode; }

    public void setPincode(String pincode) { this.pincode = pincode; }

}