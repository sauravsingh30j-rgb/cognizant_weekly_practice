package com.example.querymethods;

import com.example.querymethods.entity.Country;
import com.example.querymethods.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercise6QueryMethodsApplication implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {

        SpringApplication.run(Exercise6QueryMethodsApplication.class, args);

    }

    @Override
    public void run(String... args) {

        countryService.saveCountry(new Country("IN", "India"));
        countryService.saveCountry(new Country("US", "United States"));
        countryService.saveCountry(new Country("JP", "Japan"));

        Country country = countryService.searchCountry("India");

        System.out.println("Search Result");

        System.out.println(country);

    }

}