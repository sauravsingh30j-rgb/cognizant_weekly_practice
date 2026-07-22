package com.example.findcountry.service;

import com.example.findcountry.entity.Country;
import com.example.findcountry.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public void saveCountry(Country country) {
        countryRepository.save(country);
    }

    public Country findCountry(String code) {

        Optional<Country> country = countryRepository.findById(code);

        return country.orElse(null);

    }

}