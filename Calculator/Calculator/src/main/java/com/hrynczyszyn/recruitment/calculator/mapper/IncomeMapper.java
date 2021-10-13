package com.hrynczyszyn.recruitment.calculator.mapper;

import com.hrynczyszyn.recruitment.calculator.dto.IncomeDto;
import com.hrynczyszyn.recruitment.calculator.entity.Income;
import org.springframework.stereotype.Component;

@Component
public class IncomeMapper implements Mapper{
    @Override
    public IncomeDto mapToDto(Income income) {
        if (income != null) {
            return IncomeDto.builder()
                    .incomeAmount(income.getIncomeAmount())
                    .build();
        }
        return null;
    }
    @Override
    public Income mapToEntity(IncomeDto incomeDto) {
        if (incomeDto != null) {
            return Income.builder()
                    .incomeAmount(incomeDto.getIncomeAmount())
                    .id(incomeDto.getId())
                    .build();
        }
        return null;
    }
}
