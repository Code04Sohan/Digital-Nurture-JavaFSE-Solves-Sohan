package com.cognizant.orm_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Attempt;
import com.cognizant.orm_learn.model.AttemptOption;
import com.cognizant.orm_learn.model.AttemptQuestion;
import com.cognizant.orm_learn.service.AttemptService;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    
    // Only keeping the service needed for this specific hands-on
    private static AttemptService attemptService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        
        // Autowire the AttemptService
        attemptService = context.getBean(AttemptService.class);

        LOGGER.info("Starting Quiz Attempt HQL Execution...");

        try {
            testGetAttemptDetail();
        } catch (Exception e) {
            LOGGER.error("Error occurred: ", e);
        }
    }

    // ============================================================
    // ======= [Solves] 3. spring-data-jpa-handson ================
    // ============================================================
    // [Solves] HQL Hands-on 3: Fetch Quiz Attempt Details
    
    private static void testGetAttemptDetail() {
        LOGGER.info("Start testGetAttemptDetail()");
        
        // Fetch User 1, Attempt 1 using the optimized HQL JOIN FETCH query
        Attempt attempt = attemptService.getAttemptDetail(1, 1);
        
        if (attempt != null) {
            System.out.println("Username: " + attempt.getUser().getName());
            System.out.println("Attempted Date: " + attempt.getDate());
            System.out.println();
            
            // Iterate through the fetched AttemptQuestions
            for (AttemptQuestion aq : attempt.getAttemptQuestions()) {
                System.out.println(aq.getQuestion().getText());
                
                // Iterate through the options for each question
                for (AttemptOption ao : aq.getAttemptOptions()) {
                    System.out.printf(" %d) %-10s %.1f    %b\n", 
                        ao.getOption().getId(), 
                        ao.getOption().getText(), 
                        ao.getOption().getScore(), 
                        ao.isSelected());
                }
                System.out.println();
            }
        } else {
            LOGGER.warn("Attempt not found for the given user and attempt ID.");
        }
        
        LOGGER.info("End testGetAttemptDetail()");
    }
}