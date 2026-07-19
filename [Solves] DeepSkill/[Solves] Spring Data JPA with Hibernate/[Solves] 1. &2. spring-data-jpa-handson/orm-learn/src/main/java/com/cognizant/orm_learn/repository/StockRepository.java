package com.cognizant.orm_learn.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.orm_learn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    // 1. Get all stock details of Facebook in the month of September 2019
    List<Stock> findByCodeAndDateBetween(String code, Date startDate, Date endDate);

    // 2. Get all Google stock details where the stock price was greater than 1250
    List<Stock> findByCodeAndCloseGreaterThan(String code, double closePrice);

    // 3. Find the top 3 dates which had the highest volume of transactions overall
    List<Stock> findTop3ByOrderByVolumeDesc();

    // 4. Identify three dates when Netflix stocks were the lowest
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}