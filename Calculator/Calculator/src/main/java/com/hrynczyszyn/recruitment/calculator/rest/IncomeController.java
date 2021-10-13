package com.hrynczyszyn.recruitment.calculator.rest;

import com.hrynczyszyn.recruitment.calculator.dto.IncomeDto;
import com.hrynczyszyn.recruitment.calculator.entity.Income;
import com.hrynczyszyn.recruitment.calculator.mapper.Mapper;
import com.hrynczyszyn.recruitment.calculator.repository.IncomeRepository;
import com.hrynczyszyn.recruitment.calculator.service.IncomeCalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class IncomeController {

    private IncomeCalculatorService incomeCalculatorService;
    private IncomeRepository incomeRepository;
    private Mapper mapper;

    public IncomeController(IncomeCalculatorService incomeCalculatorService, IncomeRepository incomeRepository, Mapper mapper) {
        this.incomeCalculatorService = incomeCalculatorService;
        this.incomeRepository = incomeRepository;
        this.mapper = mapper;
    }

    @PostMapping("/income_calculation/{income}")
    public BigDecimal calculateAndSaveIncome(@PathVariable BigDecimal income) {
        BigDecimal incomeValue = incomeCalculatorService.calculateIncome(income);
        IncomeDto dto = IncomeDto.builder().
                incomeAmount(incomeValue).build();
        Income incomeToBeSaved = mapper.mapToEntity(dto);
        incomeRepository.save(incomeToBeSaved);
        return incomeValue;
    }

    @GetMapping("/last_five")
    public List<Income> getLastFive(){
        return incomeRepository.findLastFiveRecords();
    }
}
