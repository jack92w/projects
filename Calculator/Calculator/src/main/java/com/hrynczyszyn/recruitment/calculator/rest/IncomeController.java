package com.hrynczyszyn.recruitment.calculator.rest;

import com.hrynczyszyn.recruitment.calculator.repository.IncomeRepository;
import com.hrynczyszyn.recruitment.calculator.service.IncomeCalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class IncomeController {

    private final IncomeCalculatorService incomeCalculatorService;
    private final IncomeRepository repository;

    /**
     * calculates income and save it in list
     * @param rawIncome to be calculated
     * @return calculated income
     */
    @PostMapping("/income/{rawIncome}")
    public BigDecimal calculateAndSaveIncome(@PathVariable BigDecimal rawIncome) {
        BigDecimal calculatedIncome = incomeCalculatorService.calculateIncome(rawIncome);
        repository.saveIncome(calculatedIncome);
        return calculatedIncome;
    }

    /**
     * gets last incomes
     * @param lastNumber - how many incomes should be returned
     * @return incomes
     */
    @GetMapping("/income/{lastNumber}")
    public List<BigDecimal> getLastIncomes(@PathVariable int lastNumber) {
        return repository.getLastIncomes(lastNumber);
    }
}
