package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
    
    // Method to calculate and log execution times
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        
        // Execute the actual target method (e.g., registerNewBook)
        Object proceed = joinPoint.proceed();
        
        long executionTime = System.currentTimeMillis() - start;
        System.out.println("AOP Log: " + joinPoint.getSignature() + " executed in " + executionTime + "ms");
        
        return proceed;
    }
}