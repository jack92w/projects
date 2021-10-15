package com.hrynczyszyn.recruitment.calculator.service;

import java.math.BigDecimal;

public interface IncomeCalculatorService {

    /**
     * calculates income
     * @param moneyAmount input for calculation
     * @return income
     */
    BigDecimal calculateIncome(BigDecimal moneyAmount);
}
