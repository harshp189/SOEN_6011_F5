package com.test;

import com.exponential.Exponential;
import org.junit.Test;

import static com.exponential.Main.input;
import static org.junit.Assert.*;

/**.
 * Unit Test cases for testing the computation of Exponential Function
 */
public class ExponentialFunctionTest {
    /**.
     * Test to check the function for invalid values of a
     */
    @Test
    public void testInvalidInputValueA() {
        Boolean incorrectInput = input(0.0, 2.0, 1.0);
        String s = String.valueOf(incorrectInput);
        assertEquals("true", s);
    }

    /**.
     * Test to check the function for invalid values of base b
     */
    @Test
    public void testInvalidInputValueB() {
        Boolean incorrectInput = input(2.0, -1.0, 1.0);
        String s = String.valueOf(incorrectInput);
        assertEquals("true", s);
    }

    /**.
     * Test to check the function for non-numeric values
     */
    @Test
    public void testInvalidInputValue() {
        double d = Double.NaN;
        Boolean incorrectInput = input(d, 0.0, 1.0);
        String s = String.valueOf(incorrectInput);
        assertEquals("true", s);
    }

    /**.
     * Test to check the output of the exponential function on valid inputs
     */
    @Test
    public void testFunctionForValidInputs() {
        double a = 2.0;
        double exponentialResult = Exponential.computeExponential(3.0, 4.0);
        double result =  a * exponentialResult;
        assertEquals(162.0,result,0);
    }

    /**
     * Test to check function for odd exponent values
     */
    @Test
    public void testFunctionForOddExponent() {
        double exponentialResult = Exponential.computeExponential(4.0, 3.0);
        assertEquals(64.0, exponentialResult, 0);
    }

    /**
     * Test to check function for even exponent values
     */
    @Test
    public void testFunctionForEvenExponent() {
        double exponentialResult = Exponential.computeExponential(5.0, 2.0);
        assertEquals(25.0, exponentialResult, 0);
    }

    /**
     * Test to check function for zero value of exponent
     */
    @Test
    public void testFunctionForZeroValue() {
        double exponentialResult = Exponential.computeExponential(5.0, 0.0);
        assertEquals(1.0, exponentialResult, 0);
    }

    /**
     * Test to check function for negative even exponent values
     */
    @Test
    public void testFunctionForNegativeEvenExponent(){
        double exponentialResult = Exponential.computeExponential(5.0, -2);
        assertEquals(0.04,exponentialResult,0.01);
    }

    /**
     * Test to check function for negative odd exponent values
     */
    @Test
    public void testFunctionForNegativeOddExponent(){
        double exponentialResult = Exponential.computeExponential(2.0, -3);
        assertEquals(0.125,exponentialResult,0);
    }

    /**
     * Test to check function for fractional exponent values
     */
    @Test
    public void testFunctionForFractionalExponent(){
        double exponentialResult = Exponential.computeExponential(3.0, 2.2);
        assertEquals(11.2115784,exponentialResult,0.000001);
    }

    /**
     * Test to check function for negative fractional exponent values
     */
    @Test
    public void testFunctionForNegativeFractionalExponent(){
        double exponentialResult = Exponential.computeExponential(3.0, -2.2);
        assertEquals(0.089193506,exponentialResult,0.000001);
    }


    /**.
     * Test to check the calculation time of the exponential function
     */
    @Test
    public void testFunctionCalculationTime() {
        long start = System.currentTimeMillis();
        double a = 2.0;
        double exponentialResult = Exponential.computeExponential(3.0, 2);
        double result =  a * exponentialResult;
        long end = System.currentTimeMillis();
        System.out.println("Elapsed Time in milli seconds: "+ (end-start));
        assertEquals(18,result,0);
    }


}
