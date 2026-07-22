package com.cognizant.spring_rest_learn.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.spring_rest_learn.model.Country;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    public Country getCountry(String code) {
        LOGGER.info("Start getCountry() in Service");
        
        // 1. Load the XML context
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        
        // 2. Retrieve the ArrayList bean containing all countries
        @SuppressWarnings("unchecked")
        List<Country> countries = context.getBean("countryList", ArrayList.class);
        
        // 3. Iterate via Lambda stream to find a case-insensitive match
        Country result = countries.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
                
        LOGGER.info("End getCountry() in Service");
        return result;
    }
}