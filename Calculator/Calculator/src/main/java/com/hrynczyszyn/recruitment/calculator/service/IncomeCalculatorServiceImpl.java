package com.hrynczyszyn.recruitment.calculator.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class IncomeCalculatorServiceImpl implements IncomeCalculatorService {

    static final BigDecimal PIT = new BigDecimal("0.19");
    static final BigDecimal ZUS = new BigDecimal("1380.18");

    @Override
    public BigDecimal calculateIncome(BigDecimal moneyAmount) {
        return moneyAmount.subtract(PIT.multiply(moneyAmount)).subtract(ZUS);
    }
}
