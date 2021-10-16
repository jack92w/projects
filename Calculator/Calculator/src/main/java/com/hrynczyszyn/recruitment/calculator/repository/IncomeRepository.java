package com.hrynczyszyn.recruitment.calculator.repository;

import com.hrynczyszyn.recruitment.calculator.income.Income;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IncomeRepository {

    private static final List<Income> incomes = new ArrayList<>();

    public void saveIncome(Income income) {
        incomes.add(income);
    }

    /**
     * @return list of incomes
     */
    public List<Income> getIncomes() {
        return incomes;
    }

    /**
     * gets last calculated incomes; if quantity of incomes is less than given number it gets all objects
     *
     * @return calculated incomes
     */
    public List<Income> getLastIncomes(int lastNumber) {
        List<Income> incomeList = new ArrayList<>();
        if (incomes.size() >= lastNumber) {
            int limit = incomes.size();
            int index = limit - lastNumber;
            for (int i = index; i < limit; i++) {
                incomeList.add(incomes.get(i));
            }
        } else {
            incomeList.addAll(incomes);
        }
        return incomeList;
    }

    protected void clearIncomes() {
        incomes.clear();
    }
}
