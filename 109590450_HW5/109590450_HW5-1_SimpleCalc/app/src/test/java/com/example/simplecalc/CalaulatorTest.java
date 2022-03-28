package com.example.simplecalc;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CalaulatorTest {
    private Calculator mCalculator;
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    @Test
    public void addTwoNumbersNegative(){
        double resultAdd = mCalculator.add(-1d, 2d);
        assertThat(resultAdd, is(equalTo(1d)));
    }

    /*
    @Test
    public void addTwoNumbersFloats(){
        double resultAdd = mCalculator.add(1.111f, 1.111d);
        assertThat(resultAdd, is(closeTo(2.222d, 0.01)));
    }
    */
    @Test
    public void subTwoNumbers(){
        double resultSub = mCalculator.sub(2d, 1d);
        assertThat(resultSub, is(equalTo(1d)));
    }

    @Test
    public void subWorksWithNegativeResults(){
        double resultSub = mCalculator.sub(2d, 10d);
        assertThat(resultSub, is(equalTo(-8d)));
    }

    @Test
    public void mulTwoNumbers(){
        double resultMul = mCalculator.mul(16d, 2d);
        assertThat(resultMul, is(equalTo(32d)));
    }

    @Test
    public void mulTwoNumbersZero(){
        double resultMul = mCalculator.mul(16d, 0d);
        assertThat(resultMul, is(equalTo(0d)));
    }

    @Test
    public void divTwoNumbers(){
        double resultDiv = mCalculator.div(16d, 2d);
        assertThat(resultDiv, is(equalTo(8d)));
    }

    @Test
    public void divByZero(){
        double resultDiv = mCalculator.div(16d, 0d);
        assertThat(resultDiv, is(equalTo(Double.POSITIVE_INFINITY)));
    }

    @Test
    public void testPositivePow(){
        double resultDiv = mCalculator.pow(5d, 2d);
        assertThat(resultDiv, is(equalTo(25d)));
    }

    @Test
    public void testNegativePow(){
        double resultPow = mCalculator.pow(-2d, 2d);
        assertThat(resultPow, is(equalTo(4d)));
    }

    @Test
    public void testNegativePow2(){
        double resultPow = mCalculator.pow(2d, -2d);
        assertThat(resultPow, is(equalTo(0.25d)));
    }

    @Test
    public void testZeroAndPositivePow(){
        double resultPow = mCalculator.pow(0d, 5d);
        assertThat(resultPow, is(equalTo(0d)));
    }

    @Test
    public void testZeroSecondOperandPow(){
        double resultPow = mCalculator.pow(5d, 0d);
        assertThat(resultPow, is(equalTo(1d)));
    }

    @Test
    public void testZeroNegativeOnePow(){
        double resultPow = mCalculator.pow(0d, -1d);
        assertThat(resultPow, is(equalTo(Double.POSITIVE_INFINITY)));
    }

    @Test
    public void tesNegativeZeroNegativeNumberPow(){
        double resultPow = mCalculator.pow(-0d, -2d);
        assertThat(resultPow, is(equalTo(Double.POSITIVE_INFINITY)));
    }
}
