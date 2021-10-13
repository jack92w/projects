package com.hrynczyszyn.recruitment.calculator.service;

import java.math.BigDecimal;

public class IncomeCalculatorServiceImpl implements IncomeCalculatorService {

    static final BigDecimal VAT = new BigDecimal("0.18");
    static final BigDecimal ZUS = new BigDecimal("1380.18");

    @Override
    public BigDecimal calculateIncome(BigDecimal moneyAmount) {
        return moneyAmount.subtract(ZUS.subtract(VAT.multiply(moneyAmount)));
    }
}
