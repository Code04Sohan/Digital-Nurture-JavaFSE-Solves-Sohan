package com.cognizant.orm_learn.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.orm_learn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // 1. Find list of all matching countries based on partial text
    List<Country> findByNameContaining(String partialName);

    // 2. Find list of all matching countries based on partial text in ascending order
    List<Country> findByNameContainingOrderByNameAsc(String partialName);

    // 3. Find list of all matching countries starting with a specific alphabet
    List<Country> findByNameStartingWith(String alphabet);
}