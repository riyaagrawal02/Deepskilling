package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    public List<Country> search(String text) {
        return repository.findByNameContaining(text);
    }

    public List<Country> searchSorted(String text) {
        return repository.findByNameContainingOrderByNameAsc(text);
    }
    public List<Country> startsWith(String letter) {
        return repository.findByNameStartingWith(letter);
    }

    public Country getCountryByCode(String code) {
        Optional<Country> country = repository.findByCode(code);
        return country.orElse(null);
    }

    public Country addCountry(Country country) {
        return repository.save(country);
    }

    public Country updateCountry(Country country) {
        return repository.save(country);
    }

    public void deleteCountry(String code) {
        repository.deleteById(code);
    }

    public List<Country> getAllCountries() {
        return repository.findAll();
    }

    public List<Country> getAllCountriesSorted() {
        return repository.findAllCountriesSorted();
    }
    public List<Country> searchUsingJPQL(String name) {
        return repository.findCountriesByNameJPQL(name);
    }

    public List<Country> searchUsingNativeSQL(String name) {
        return repository.findCountriesByNameNativeSQL(name);
    }

    public List<Country> searchAndSort(String pattern) {
        return repository.findCountriesSortedByName(pattern);
    }
}