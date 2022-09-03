package com.natwest.controller;

import com.natwest.service.PrimeCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * REST api controller for prime number calculation
 */
@RestController()
@RequestMapping("/api/v1")
public class PrimeNumberController {

    private final PrimeCalculatorService primeCalculatorService;

    @Autowired
    public PrimeNumberController(PrimeCalculatorService primeCalculatorService) {
        this.primeCalculatorService = primeCalculatorService;
    }

    /**
     * gets all prime numbers between 0 and maxValue provided
     *
     * @param maxValue the max value to get a prime number for, inclusive
     */
    @GetMapping(value = "/primeNumbers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Integer> getPrimeNumbers(@RequestParam() Integer maxValue) {
        try {
            return primeCalculatorService.getPrimeNumbers(maxValue);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }


}
