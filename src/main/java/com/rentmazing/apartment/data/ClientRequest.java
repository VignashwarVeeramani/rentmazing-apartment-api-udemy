package com.rentmazing.apartment.data;

import java.util.List;

public class ClientRequest {
    private String fullName;
    private String email;
    private String phone;

    public List<ClientApartmentRequest> getApartments() {
        return apartments;
    }


    private List<ClientApartmentRequest> apartments;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setApartments(List<ClientApartmentRequest> apartments) {
        this.apartments = apartments;
    }
}
