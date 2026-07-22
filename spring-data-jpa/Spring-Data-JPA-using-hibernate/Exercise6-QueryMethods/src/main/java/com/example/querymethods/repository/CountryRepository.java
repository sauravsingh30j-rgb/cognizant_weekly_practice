package com.example.querymethods.repository;

import com.example.querymethods.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {

    Country findByCountryName(String countryName);

}