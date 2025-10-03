package com.rentmazing.apartment.controller;

import com.rentmazing.apartment.entity.Client;
import com.rentmazing.apartment.entity.ClientApartment;
import com.rentmazing.apartment.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(value = {"/api/clients", "/api/clients/{optionalClientId}"})
    public List<Client> getAllClients(
            @PathVariable(required = false, name = "optionalClientId") String optionalClientId
    ) {
        return  apartmentService.findClients(optionalClientId);
    }

    @GetMapping(value = "/api/apartments")
    public List<ClientApartment> getApartments(
            @RequestParam(required = false, name = "city") String city,
            @RequestParam(required = false, name = "minPrice") Integer minPrice,
            @RequestParam(required = false, name = "maxPrice") Integer maxPrice,
            @RequestParam(required = false, name = "isAvailableForRent") Boolean isAvailableForRent

    ) {
        return apartmentService.findApartments(city,minPrice,maxPrice,isAvailableForRent);
    }



}