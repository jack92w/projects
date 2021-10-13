package com.hrynczyszyn.recruitment.calculator.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class IncomeCalculatorServiceImpl implements IncomeCalculatorService {

    static final BigDecimal VAT = new BigDecimal("0.18");
    static final BigDecimal ZUS = new BigDecimal("1380.18");

    @Override
    public BigDecimal calculateIncome(BigDecimal moneyAmount) {
        return moneyAmount.subtract(VAT.multiply(moneyAmount)).subtract(ZUS);
    }
}
