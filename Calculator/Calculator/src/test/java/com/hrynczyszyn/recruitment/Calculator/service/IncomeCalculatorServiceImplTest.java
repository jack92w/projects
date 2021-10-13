package com.hrynczyszyn.recruitment.Calculator.service;

import com.hrynczyszyn.recruitment.calculator.service.IncomeCalculatorService;
import com.hrynczyszyn.recruitment.calculator.service.IncomeCalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class IncomeCalculatorServiceImplTest {

    private IncomeCalculatorService incomeCalculatorService;

    @BeforeEach
    void setUp(){
        incomeCalculatorService = new IncomeCalculatorServiceImpl();
    }

    @Test
    void shouldReturnProperValue(){
        BigDecimal number = new BigDecimal("10000");
        BigDecimal actual = incomeCalculatorService.calculateIncome(number);
        BigDecimal expected = new BigDecimal("6819.82");
        Assertions.assertEquals(expected, actual);
    }

}