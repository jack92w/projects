package com.hrynczyszyn.recruitment.calculator.repository;

import com.hrynczyszyn.recruitment.calculator.income.Income;
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
    void shouldReturnProperQuantityOfIncomesWhenListSizeIsBiggerThanGivenParam() {
        //given
        final int five = 5;
        Income income1 = new Income(new BigDecimal("10000"));
        Income income2 = new Income(new BigDecimal("20000"));
        Income income3 = new Income(new BigDecimal("30000"));
        Income income4 = new Income(new BigDecimal("40000"));
        Income income5 = new Income(new BigDecimal("50000"));
        Income income6 = new Income(new BigDecimal("60000"));
        List<Income> expectedIncomeList = List.of(income2, income3, income4, income5, income6);
        repository.saveIncome(income1);
        repository.saveIncome(income2);
        repository.saveIncome(income3);
        repository.saveIncome(income4);
        repository.saveIncome(income5);
        repository.saveIncome(income6);
        //when
        List<Income> actualIncomeList = repository.getLastIncomes(five);
        //then
        Assertions.assertEquals(expectedIncomeList, actualIncomeList);
        Assertions.assertEquals(five, actualIncomeList.size());
    }

    //clear was added in case of all test will be run at once
    @Test
    void shouldReturnProperQuantityOfIncomesWhenListSizeIsLessThanGivenParam() {
        //given
        repository.clearIncomes();
        final int nine = 9;
        final int expectedSize = 2;
        Income income1 = new Income(new BigDecimal("10000"));
        Income income2 = new Income(new BigDecimal("20000"));
        List<Income> expectedIncomeList = List.of(income1, income2);
        repository.saveIncome(income1);
        repository.saveIncome(income2);
        //when
        List<Income> actualIncomeList = repository.getLastIncomes(nine);
        //then
        Assertions.assertEquals(expectedIncomeList, actualIncomeList);
        Assertions.assertEquals(expectedSize, actualIncomeList.size());
    }
}