package com.cognizant.spring_rest_learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_rest_learn.model.Country;
import com.cognizant.spring_rest_learn.service.CountryService;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    // Injecting the newly created Service
    @Autowired
    private CountryService countryService;

    // --- PREVIOUS HANDS-ON 3 ENDPOINTS ---
    
    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public Country getCountryIndia() {
        LOGGER.info("Start getCountryIndia() - JSON");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("in", Country.class);
        LOGGER.info("End getCountryIndia() - JSON");
        return country;
    }

    @RequestMapping(value = "/country/text", method = RequestMethod.GET)
    public String getCountryIndiaText() {
        LOGGER.info("Start getCountryIndiaText() - Text");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("in", Country.class);
        LOGGER.info("End getCountryIndiaText() - Text");
        return "Country Code: " + country.getCode() + " | Country Name: " + country.getName();
    }

    // --- NEW HANDS-ON 4 ENDPOINT ---
    
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        LOGGER.info("Start getCountry() in Controller");
        
        // Pass the path variable to the service layer for processing
        Country country = countryService.getCountry(code);
        
        LOGGER.info("End getCountry() in Controller");
        return country;
    }
}