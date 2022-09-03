package com.natwest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.natwest.service.PrimeCalculatorServiceTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PrimeNumberControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldReturnOk() throws Exception {
        String max = "100";
        String expectedJson = objectMapper.writeValueAsString(PrimeCalculatorServiceTest.expectedPrimeNumbers);
        this.mockMvc.perform(get("/api/v1/primeNumbers?maxValue=" + max)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }

    @Test
    public void shouldReturnBadRequest() throws Exception {
        String max = "-1";
        this.mockMvc.perform(get("/api/v1/primeNumbers?maxValue=" + max)).andDo(print())
                .andExpect(status().isBadRequest())
                .andDo(print())
                .andExpect(result ->
                        assertEquals(result.getResolvedException().getCause().getMessage(), "Value should be above 0"));
    }

    @Test
    public void shouldReturnBadRequestNull() throws Exception {
        this.mockMvc.perform(get("/api/v1/primeNumbers")).andDo(print())
                .andExpect(status().isBadRequest())
                .andDo(print())
                .andExpect(result ->
                        assertEquals(result.getResolvedException().getMessage(),
                                "Required request parameter 'maxValue' for method parameter type Integer is not present"));
    }
}