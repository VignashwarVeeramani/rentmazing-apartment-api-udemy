package com.rentmazing.apartment.controller;

import com.rentmazing.apartment.entity.Client;
import com.rentmazing.apartment.entity.ClientApartment;
import com.rentmazing.apartment.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public  class ApartmentRestController {

    @Autowired
    private ApartmentService apartmentService;

    @GetMapping(value = "/api/hello")
    public String getHello() {
        return  "Hello Sir!";
    }

    @GetMapping(value = "/api/clients")
    public List<Client> getAllClients() {
        return  apartmentService.getAllClients();
    }

    @GetMapping(value = "/api/apartments")
    public List<ClientApartment> getApartments() {
        return apartmentService.getAllClientApartments();
    }


}