package com.example.countryservice;

import com.example.countryservice.entity.Country;
import com.example.countryservice.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercise3CountryServiceApplication implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(Exercise3CountryServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {

        countryService.saveCountry(new Country("IN", "India"));
        countryService.saveCountry(new Country("US", "United States"));
        countryService.saveCountry(new Country("JP", "Japan"));

        System.out.println("Country List");

        for (Country country : countryService.getAllCountries()) {
            System.out.println(country);
        }
    }
}