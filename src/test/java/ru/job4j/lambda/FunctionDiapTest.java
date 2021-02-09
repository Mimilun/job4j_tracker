package ru.job4j.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FunctionDiapTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionDiap function = new FunctionDiap();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenSuareFunctionThenSquareResults() {
        FunctionDiap function = new FunctionDiap();
        List<Double> result = function.diapason(5, 8, x -> (2 * x) * (2 * x) + 5 * x + 7);
        List<Double> expected = Arrays.asList(132D, 181D, 238D);
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenIndicativeFunctionThenIndicativeResults() {
        FunctionDiap function = new FunctionDiap();
        List<Double> result = function.diapason(5, 8, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(32D, 64D, 128D);
        Assert.assertEquals(result, expected);
    }
}