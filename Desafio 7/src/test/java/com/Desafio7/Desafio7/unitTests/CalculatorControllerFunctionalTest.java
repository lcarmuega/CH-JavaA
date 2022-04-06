package com.Desafio7.Desafio7.unitTests;

import com.Desafio7.Desafio7.domain.Operation;
import com.Desafio7.Desafio7.domain.enums.Operator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerFunctionalTest {
    @Autowired
    protected MockMvc mockMvc;

    @Test
    void testWhenDifferenceReturnsValidResult() throws Exception {
        Operation operation = new Operation(90.0, 50.0, Operator.DIFFERENCE);
        String json = new ObjectMapper().writeValueAsString(operation);
        this.mockMvc.perform(post("/calculator/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(10.0));
    }
}
