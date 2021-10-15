package com.hrynczyszyn.recruitment.calculator.repository;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IncomeRepository {

    private static final List<BigDecimal> incomes = new ArrayList<>();

    public void saveIncome(BigDecimal income) {
        incomes.add(income);
    }

    /**
     * @return list of incomes
     */
    public List<BigDecimal> getIncomes() {
        return incomes;
    }

    /**
     * gets last five calculated incomes; if quantity of incomes is less than 5 it gets quantity
     *
     * @return calculated incomes
     */
    public List<BigDecimal> getLastIncomes(int lastNumber) {
        List<BigDecimal> incomeList = new ArrayList<>();
        if (incomes.size() >= lastNumber) {
            int limit = incomes.size() - 1;
            int index = limit - lastNumber + 1;
            for (int i = index; i <= limit; i++) {
                incomeList.add(incomes.get(i));
            }
        }

        else {
            incomeList.addAll(incomes);
        }
        return incomeList;
    }

    protected void clearIncomes(){
        incomes.clear();
    }
}
