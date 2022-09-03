package com.natwest.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PrimeCalculatorService {

    /**
     * Calculates prime numbers from 0 to the maxValue parameter
     *
     * @param maxValue the max value to calculate prime numbers for, inclusive
     * @throws Exception value is < 0
     */
    @Cacheable("primeNumbers")
    public List<Integer> getPrimeNumbers(Integer maxValue) throws Exception {
        if(maxValue==null)
            throw new NullPointerException("Value should not be null");
        if (maxValue < 0)
            throw new Exception("Value should be above 0");
        return IntStream.rangeClosed(2, maxValue).parallel()
                .filter(PrimeCalculatorService::isPrime).boxed()
                .collect(Collectors.toList());
    }

    /**
     * checks if number is a prime number
     *
     * @param number number to check if is a prime number
     */
    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(i -> number % i == 0);
    }
}