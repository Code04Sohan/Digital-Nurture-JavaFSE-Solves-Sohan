package com.cognizant.orm_learn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; // Use javax if on Spring Boot 2.x
import org.springframework.stereotype.Service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // Feature 1: Find a country based on country code
    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country with code " + countryCode + " not found.");
        }
        return result.get();
    }

    // Feature 2: Add new country
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    // Feature 3: Update country
    @Transactional
    public void updateCountry(String code, String newName) throws CountryNotFoundException {
        Country country = findCountryByCode(code);
        country.setName(newName);
        countryRepository.save(country);
    }

    // Feature 4: Delete country
    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    // Feature 5: Find list of countries matching a partial country name
    @Transactional
    public List<Country> searchCountryByName(String partialName) {
        return countryRepository.findByNameContainingOrderByNameAsc(partialName);
    }

    // Hands on 2 [[Solves] 2. spring-data-jpa-handson]] codes.
    @Transactional
    public List<Country> searchCountriesByPartialName(String partialName) {
        return countryRepository.findByNameContaining(partialName);
    }

    @Transactional
    public List<Country> searchCountriesByPartialNameAsc(String partialName) {
        return countryRepository.findByNameContainingOrderByNameAsc(partialName);
    }

    @Transactional
    public List<Country> searchCountriesStartingWith(String alphabet) {
        return countryRepository.findByNameStartingWith(alphabet);
    }
}