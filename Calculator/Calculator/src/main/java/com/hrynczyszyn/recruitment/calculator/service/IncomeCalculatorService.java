package com.hrynczyszyn.recruitment.calculator.service;

import java.math.BigDecimal;

public interface IncomeCalculatorService {

    BigDecimal calculateIncome(BigDecimal moneyAmount);
}
