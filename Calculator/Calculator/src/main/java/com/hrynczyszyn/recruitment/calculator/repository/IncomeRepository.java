package com.hrynczyszyn.recruitment.calculator.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class IncomeRepository {

    private static final List<BigDecimal> incomes = new ArrayList<>();

    public void saveIncome(BigDecimal income) {
        incomes.add(income);
    }

    public List<BigDecimal> getIncomes() {
        return incomes;
    }

    public List<BigDecimal> calcIncomes() {
        List<BigDecimal> incomeList = new ArrayList<>();
        if (incomes.size() >= 5) {
            int limit = incomes.size()-1;
            int index = limit - 5;
            for (int i = index; i <= limit; i++) {
                incomeList.add(incomes.get(i));
            }
            return incomeList;
        } else {
            return incomes;
        }

    }
}
