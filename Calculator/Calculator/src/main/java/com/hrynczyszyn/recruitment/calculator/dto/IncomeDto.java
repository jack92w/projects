package com.hrynczyszyn.recruitment.calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class IncomeDto {

    private Long id;
    private BigDecimal incomeAmount;
}
