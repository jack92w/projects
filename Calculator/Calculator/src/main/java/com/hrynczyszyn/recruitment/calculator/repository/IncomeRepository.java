package com.hrynczyszyn.recruitment.calculator.repository;

import com.hrynczyszyn.recruitment.calculator.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

    @Query("SELECT income_amount FROM income_tbl ORDER BY id DESC")
    List<Income> findLastFiveRecords();

}
