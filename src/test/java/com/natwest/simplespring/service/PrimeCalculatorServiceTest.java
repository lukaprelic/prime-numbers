package com.natwest.simplespring.service;

import com.natwest.service.PrimeCalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrimeCalculatorServiceTest {

    private PrimeCalculatorService primeCalculatorService;
    public static final List<Integer> expectedPrimeNumbers = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);

    @BeforeEach
    void setUp() {
        primeCalculatorService = new PrimeCalculatorService();
    }


    @ParameterizedTest
    @MethodSource("primeNumbersInputToExpected")
    void getPrimeNumbers(Integer input, List<Integer> expected) throws Exception {
        List<Integer> actual = primeCalculatorService.getPrimeNumbers(input);
        assertThat(actual).hasSameElementsAs(expected);
    }

    @Test
    void getPrimeNumbersNull() {
        assertThatThrownBy(() ->
                primeCalculatorService.getPrimeNumbers(null)).isInstanceOf(NullPointerException.class)
                .hasMessageContaining("Value should not be null");
    }

    @Test
    void getPrimeNumbersLessThanZero() {
        assertThatThrownBy(() ->
                primeCalculatorService.getPrimeNumbers(-1))
                .isInstanceOf(Exception.class)
                .hasMessageContaining("Value should be above 0");
    }
    private static Stream<Arguments> primeNumbersInputToExpected() {
        return Stream.of(
                Arguments.of(0, List.of()),
                Arguments.of(1, List.of()),
                Arguments.of(2, List.of(2)),
                Arguments.of(100, expectedPrimeNumbers)
        );
    }
}