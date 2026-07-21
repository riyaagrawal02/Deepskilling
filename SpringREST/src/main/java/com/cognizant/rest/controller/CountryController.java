package com.cognizant.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.rest.model.Country;
import com.cognizant.rest.service.CountryService;


@RestController
@RequestMapping("/api/countries")
public class CountryController {
    
    @Autowired
    private CountryService countryService;
    
    
    @GetMapping
    public ResponseEntity<List<Country>> getAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        return ResponseEntity.ok(countries);
    }
    
    
    @GetMapping("/{code}")
    public ResponseEntity<Country> getCountryByCode(@PathVariable String code) {
        Country country = countryService.getCountryByCode(code);
        if (country != null) {
            return ResponseEntity.ok(country);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
   
    @GetMapping("/xml/config")
    public ResponseEntity<Country> getCountryFromXmlConfig() {
        Country country = countryService.getCountryFromXmlConfig();
        if (country != null) {
            return ResponseEntity.ok(country);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
   
    @PostMapping
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {
        Country addedCountry = countryService.addCountry(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedCountry);
    }
    
   
    @PutMapping("/{code}")
    public ResponseEntity<Country> updateCountry(@PathVariable String code, @RequestBody Country country) {
        country.setCode(code);
        Country updatedCountry = countryService.updateCountry(country);
        if (updatedCountry != null) {
            return ResponseEntity.ok(updatedCountry);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
   
    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteCountry(@PathVariable String code) {
        if (countryService.deleteCountry(code)) {
            return ResponseEntity.ok("Country with code " + code + " deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
