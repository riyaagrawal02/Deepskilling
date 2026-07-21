package com.cognizant.ormlearn.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

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

    @GetMapping("/sorted")
    public ResponseEntity<List<Country>> getAllCountriesSorted() {
        List<Country> countries = countryService.getAllCountriesSorted();
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

    @GetMapping("/search")
    public ResponseEntity<List<Country>> searchCountries(@RequestParam String text) {
        List<Country> countries = countryService.search(text);
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/search/sorted")
    public ResponseEntity<List<Country>> searchCountriesSorted(@RequestParam String text) {
        List<Country> countries = countryService.searchSorted(text);
        return ResponseEntity.ok(countries);
    }
    @GetMapping("/startsWith")
    public ResponseEntity<List<Country>> searchCountriesByStartingLetter(@RequestParam String letter) {
        List<Country> countries = countryService.startsWith(letter);
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/search/jpql")
    public ResponseEntity<List<Country>> searchUsingJPQL(@RequestParam String name) {
        List<Country> countries = countryService.searchUsingJPQL(name);
        return ResponseEntity.ok(countries);
    }


    @GetMapping("/search/native")
    public ResponseEntity<List<Country>> searchUsingNativeSQL(@RequestParam String name) {
        List<Country> countries = countryService.searchUsingNativeSQL(name);
        return ResponseEntity.ok(countries);
    }

    @PostMapping
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {
        Country addedCountry = countryService.addCountry(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedCountry);
    }


    @PutMapping("/{code}")
    public ResponseEntity<Country> updateCountry(@PathVariable String code, @RequestBody Country country) {
        Country existingCountry = countryService.getCountryByCode(code);
        if (existingCountry != null) {
            country.setCode(code);
            Country updatedCountry = countryService.updateCountry(country);
            return ResponseEntity.ok(updatedCountry);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteCountry(@PathVariable String code) {
        Country country = countryService.getCountryByCode(code);
        if (country != null) {
            countryService.deleteCountry(code);
            return ResponseEntity.ok("Country deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
