package com.example.findcountry;

import com.example.findcountry.entity.Country;
import com.example.findcountry.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercise4FindCountryByCodeApplication implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(Exercise4FindCountryByCodeApplication.class, args);
    }

    @Override
    public void run(String... args) {

        countryService.saveCountry(new Country("IN", "India"));
        countryService.saveCountry(new Country("US", "United States"));

        Country country = countryService.findCountry("IN");

        System.out.println("Country Found");
        System.out.println(country);

    }
}