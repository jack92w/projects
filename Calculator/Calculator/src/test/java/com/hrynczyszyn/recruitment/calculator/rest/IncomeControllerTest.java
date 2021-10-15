package com.hrynczyszyn.recruitment.calculator.rest;

import com.hrynczyszyn.recruitment.calculator.income.Income;
import com.hrynczyszyn.recruitment.calculator.repository.IncomeRepository;
import com.hrynczyszyn.recruitment.calculator.service.IncomeCalculatorService;
import com.hrynczyszyn.recruitment.calculator.service.IncomeCalculatorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class IncomeControllerTest {

    private MockMvc mockMvc;
    private IncomeController incomeController;
    private IncomeRepository incomeRepository;
    private IncomeCalculatorService incomeCalculatorService;

    @BeforeEach
    void setUp() {
        //incomeRepository = new IncomeRepository();
        incomeRepository = Mockito.mock(IncomeRepository.class);
        incomeCalculatorService = Mockito.mock(IncomeCalculatorService.class);
       // incomeCalculatorService = new IncomeCalculatorServiceImpl();
        this.mockMvc = standaloneSetup(new IncomeController(incomeCalculatorService, incomeRepository))
                .build();
    }

    @Test
    void shouldReturnProperJSonContent() throws Exception {
        //given
        final BigDecimal exampleResult = new BigDecimal("6719.82");
        final BigDecimal exampleInput = new BigDecimal("10000");
        Mockito.when(incomeCalculatorService.calculateIncome(Mockito.any())).thenReturn(exampleResult);
        String url = "/income/{rawIncome}";
        //when
        //then
        this.mockMvc.perform(MockMvcRequestBuilders.get(url, exampleInput)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
    @Test

    void shouldReturnProperJSonContentX() throws Exception {
        //given
        final BigDecimal big = new BigDecimal("20000");
        final Income exampleResult = new Income(big);
        Mockito.when(incomeRepository.getLastIncomes(Mockito.anyInt())).thenReturn(List.of(exampleResult));
        String url = "/income/{lastNumber}";
        //when
        //then
        this.mockMvc.perform(MockMvcRequestBuilders.get(url, 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}