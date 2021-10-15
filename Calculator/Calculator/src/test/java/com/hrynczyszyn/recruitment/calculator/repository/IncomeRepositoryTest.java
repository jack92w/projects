package com.hrynczyszyn.recruitment.calculator.repository;

import com.hrynczyszyn.recruitment.calculator.exception.NotEnoughIncomesException;
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
    void shouldReturnProperIncomes() throws NotEnoughIncomesException {
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
        List<BigDecimal> actualIncomeList = repository.getLastFiveIncomes();
        //then
        Assertions.assertEquals(expectedIncomeList, actualIncomeList);
        Assertions.assertEquals(five, actualIncomeList.size());
    }

    @Test
    void shouldThrowNotEnoughIncomesException() {
        //given
        BigDecimal in1 = new BigDecimal("10000");
        repository.saveIncome(in1);
        //when
        //then
        Assertions.assertThrows(NotEnoughIncomesException.class, ()-> repository.getLastFiveIncomes());
    }
}