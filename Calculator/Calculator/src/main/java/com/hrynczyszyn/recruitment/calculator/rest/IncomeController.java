package com.hrynczyszyn.recruitment.calculator.rest;

import com.hrynczyszyn.recruitment.calculator.income.Income;
import com.hrynczyszyn.recruitment.calculator.repository.IncomeRepository;
import com.hrynczyszyn.recruitment.calculator.service.IncomeCalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class IncomeController {

    private final IncomeCalculatorService incomeCalculatorService;
    private final IncomeRepository repository;

    /**
     * calculates income and save it in list
     *
     * @param rawIncome to be calculated
     * @return calculated income
     */
    @PostMapping("/income/{rawIncome}")
    public Income calculateAndSaveIncome(@PathVariable BigDecimal rawIncome) {
        BigDecimal calculationResult = incomeCalculatorService.calculateIncome(rawIncome);
        Income calculatedIncome = new Income(calculationResult);
        repository.saveIncome(calculatedIncome);
        return calculatedIncome;
    }

    /**
     * gets last incomes
     *
     * @param lastNumber - how many incomes should be returned
     * @return incomes
     */
    @GetMapping("/income/{lastNumber}")
    public List<Income> getLastIncomes(@PathVariable int lastNumber) {
        return repository.getLastIncomes(lastNumber);
    }
}
