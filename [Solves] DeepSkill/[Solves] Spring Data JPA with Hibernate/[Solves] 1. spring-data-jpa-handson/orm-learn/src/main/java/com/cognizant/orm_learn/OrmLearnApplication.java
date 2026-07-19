package com.cognizant.orm_learn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        
        LOGGER.info("Starting Hands-on 5 Execution...");

        try {
            testFindCountryByCode();
            testAddCountry();
            testUpdateCountry();
            testDeleteCountry();
            testSearchCountryByName();
        } catch (CountryNotFoundException e) {
            LOGGER.error("Error occurred: ", e);
        }
    }

    // Test Feature 1
    private static void testFindCountryByCode() throws CountryNotFoundException {
        LOGGER.info("Start testFindCountryByCode()");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country: {}", country);
        LOGGER.info("End testFindCountryByCode()");
    }

    // Test Feature 2
    private static void testAddCountry() throws CountryNotFoundException {
        LOGGER.info("Start testAddCountry()");
        Country newCountry = new Country();
        newCountry.setCode("XX");
        newCountry.setName("New Test Country");
        countryService.addCountry(newCountry);
        Country result = countryService.findCountryByCode("XX");
        LOGGER.debug("Added Country: {}", result);
        LOGGER.info("End testAddCountry()");
    }

    // Test Feature 3
    private static void testUpdateCountry() throws CountryNotFoundException {
        LOGGER.info("Start testUpdateCountry()");
        countryService.updateCountry("XX", "Updated Test Country");
        Country updatedCountry = countryService.findCountryByCode("XX");
        LOGGER.debug("Updated Country: {}", updatedCountry);
        LOGGER.info("End testUpdateCountry()");
    }

    // Test Feature 4
    private static void testDeleteCountry() {
        LOGGER.info("Start testDeleteCountry()");
        countryService.deleteCountry("XX");
        LOGGER.info("Deleted Country Code XX successfully.");
        LOGGER.info("End testDeleteCountry()");
    }

    // Test Feature 5
    private static void testSearchCountryByName() {
        LOGGER.info("Start testSearchCountryByName()");
        List<Country> countries = countryService.searchCountryByName("ou");
        LOGGER.debug("Found {} countries matching 'ou'", countries.size());
        for(Country c : countries) {
             LOGGER.debug("Match: {}", c.getName());
        }
        LOGGER.info("End testSearchCountryByName()");
    }
}