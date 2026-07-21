package com.cognizant.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.rest.model.Country;

@Service
public class CountryService {
    
    @Autowired(required = false)
    private Country countryFromXml;
    
    private static List<Country> countries = new ArrayList<>();
    
    static {
        countries.add(new Country("IN", "India", "New Delhi", "Asia"));
        countries.add(new Country("US", "United States", "Washington DC", "North America"));
        countries.add(new Country("UK", "United Kingdom", "London", "Europe"));
        countries.add(new Country("AU", "Australia", "Canberra", "Oceania"));
        countries.add(new Country("CA", "Canada", "Ottawa", "North America"));
    }
    
   
    public List<Country> getAllCountries() {
        return countries;
    }
    
    
    public Country getCountryByCode(String code) {
        for (Country country : countries) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }
        return null;
    }
    

    public Country addCountry(Country country) {
        countries.add(country);
        return country;
    }
    
    
    public Country updateCountry(Country country) {
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getCode().equalsIgnoreCase(country.getCode())) {
                countries.set(i, country);
                return country;
            }
        }
        return null;
    }
    
   
    public boolean deleteCountry(String code) {
        return countries.removeIf(c -> c.getCode().equalsIgnoreCase(code));
    }
    
 
    public Country getCountryFromXmlConfig() {
        return countryFromXml;
    }
}
