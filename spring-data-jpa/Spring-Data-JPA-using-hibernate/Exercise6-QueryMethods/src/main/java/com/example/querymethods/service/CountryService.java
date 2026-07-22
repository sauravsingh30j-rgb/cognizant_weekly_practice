package com.example.querymethods.service;

import com.example.querymethods.entity.Country;
import com.example.querymethods.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public void saveCountry(Country country) {

        countryRepository.save(country);

    }

    public Country searchCountry(String name) {

        return countryRepository.findByCountryName(name);

    }

}