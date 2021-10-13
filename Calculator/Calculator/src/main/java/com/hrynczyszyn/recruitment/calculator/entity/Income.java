package com.hrynczyszyn.recruitment.calculator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity(name = "income_tbl")
public class Income {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "income_amount", nullable = false)
    private BigDecimal incomeAmount;
}
