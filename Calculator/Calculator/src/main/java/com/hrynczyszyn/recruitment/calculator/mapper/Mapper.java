package com.hrynczyszyn.recruitment.calculator.mapper;

import com.hrynczyszyn.recruitment.calculator.dto.IncomeDto;
import com.hrynczyszyn.recruitment.calculator.entity.Income;

public interface Mapper {
    IncomeDto mapToDto(Income income);
    Income mapToEntity(IncomeDto incomeDto);
}
