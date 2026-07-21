package com.cognizant.spring_learn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Starting SpringLearnApplication...");

        SpringApplication.run(SpringLearnApplication.class, args);

        LOGGER.info("SpringLearnApplication started successfully!");

        // Hands-on 2
        displayDate();

        // Hands-on 4
        displayCountry();
    }

    // --- METHOD FOR HANDS-ON 4 ---
    public static void displayCountry() {
        LOGGER.info("Start displayCountry()");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        Country country = context.getBean("country", Country.class);

        LOGGER.debug("Country : {}", country.toString());

        LOGGER.info("End displayCountry()");
    }

    // --- METHOD FOR HANDS-ON 2 ---
    public static void displayDate() {
        LOGGER.info("Start displayDate()");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        try {
            Date date = format.parse("31/12/2018");
            System.out.println("Parsed Date from Bean: " + date);
            LOGGER.debug("Parsed Date from Bean: {}", date);
        } catch (ParseException e) {
            LOGGER.error("An error occurred while parsing the date: ", e);
        }
        LOGGER.info("End displayDate()");
    }
}