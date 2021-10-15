package com.hrynczyszyn.recruitment.calculator.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class IncomeRepositoryTest {

    private IncomeRepository repository;

    @BeforeEach
    void setUp() {
        repository = new IncomeRepository();
    }

    @Test
    void shouldReturnProperQuantityOfIncomes() {
        //given
        final int five = 5;
        BigDecimal in1 = new BigDecimal("10000");
        BigDecimal in2 = new BigDecimal("20000");
        BigDecimal in3 = new BigDecimal("30000");
        BigDecimal in4 = new BigDecimal("40000");
        BigDecimal in5 = new BigDecimal("50000");
        BigDecimal in6 = new BigDecimal("60000");
        List<BigDecimal> expectedIncomeList = List.of(in2, in3, in4, in5, in6);
        repository.saveIncome(in1);
        repository.saveIncome(in2);
        repository.saveIncome(in3);
        repository.saveIncome(in4);
        repository.saveIncome(in5);
        repository.saveIncome(in6);
        //when
        List<BigDecimal> actualIncomeList = repository.getLastIncomes(five);
        //then
        Assertions.assertEquals(expectedIncomeList, actualIncomeList);
        Assertions.assertEquals(five, actualIncomeList.size());
    }

    //clear was added in case of all test will be run at once
    @Test
    void shouldThrowNotEnoughIncomesException() {
        //given
        repository.clearIncomes();
        final int nine = 9;
        final int expectedSize = 2;
        BigDecimal in1 = new BigDecimal("10000");
        BigDecimal in2 = new BigDecimal("20000");
        List<BigDecimal> expectedIncomeList = List.of(in1, in2);
        repository.saveIncome(in1);
        repository.saveIncome(in2);

        //when
        List<BigDecimal> actualIncomeList = repository.getLastIncomes(nine);
        //then
        Assertions.assertEquals(expectedIncomeList, actualIncomeList);
        Assertions.assertEquals(expectedSize, actualIncomeList.size());
    }
}