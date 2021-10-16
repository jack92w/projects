package com.hrynczyszyn.recruitment.calculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class IncomeCalculatorServiceImplTest {

    private IncomeCalculatorService incomeCalculatorService;

    @BeforeEach
    void setUp() {
        incomeCalculatorService = new IncomeCalculatorServiceImpl();
    }

    @Test
    void shouldReturnProperValue() {
        //given
        final BigDecimal value = new BigDecimal("10000");
        final BigDecimal expected = new BigDecimal("6719.82");
        //when
        final BigDecimal actual = incomeCalculatorService.calculateIncome(value);
        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnResultLessThanZero() {
        //given
        final BigDecimal value = new BigDecimal("1380.18");
        final BigDecimal expected = new BigDecimal("-262.2342");
        //when
        final BigDecimal actual = incomeCalculatorService.calculateIncome(value);
        //then
        Assertions.assertEquals(expected, actual);
    }
}