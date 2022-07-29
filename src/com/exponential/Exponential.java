package com.exponential;

public class Exponential {
    public static double e = 2.7182818284590;

    /**
     * This method computes the exponential value of the passed
     * base and exponent values, it handles all the required cases
     * including negative exponent values as well as fractional exponent values.
     *
     * @param base is the base value (b) of the exponential function.
     * @param exponent is the exponent value (x) of the exponential function.
     * @return power value (b raised to x).
     */
    public static double computeExponential(double base, double exponent) {

        if(exponent != (int) exponent){
            return fractionExponential(base,exponent);
        }
        if(exponent<0){
            base = 1/base;
            exponent = -exponent;
            if(exponent % 2 == 0.0){
                return computeExponential(base,exponent/2) * computeExponential(base,exponent/2);
            }
            else{
                exponent = exponent -1;
                return base * computeExponential(base,exponent/2)*computeExponential(base,exponent/2);
            }
        }else if(exponent==0.0){
            return 1.0;
        }else if(exponent==1.0){
            return base;
        }else if(exponent % 2==0.0){
            return computeExponential(base,exponent/2)*computeExponential(base,exponent/2);
        }else{
            exponent = exponent - 1;
            return base * computeExponential(base,exponent/2)*computeExponential(base,exponent/2);
        }
    }

    /**
     * This method is used to calculate the natural logarithmic value
     * of the passed number.
     * @param number is the number whose ln() value is to be calculated.
     * @return the natural logarithmic value of number.
     */
    public static double computeLogarithm(double number){

        int numberOfIterations = 100;
        if(number<0)
            number=-number;
        double logValue = 0;
        double baseValue = (number - 1)/(number + 1);

        while(numberOfIterations > 0){

            if(numberOfIterations % 2 != 0){
                logValue += computeExponential(baseValue,numberOfIterations) / numberOfIterations ;
            }
            numberOfIterations--;
        }
        return logValue * 2;
    }

    /**
     * This method is used to calculate the factorial of the passed number.
     * @param number is the number whose factorial is to be calculated.
     * @return the factorial of the number.
     */
    public static double computeFactorial(double number){
        if(number == 0){
            return 1;
        }
        return (number * computeFactorial(number - 1));
    }

    /**
     * This method is used to calculate the exponential value of the
     * passed base and exponent values when the exponent
     * value is a fractional number.
     * @param base is the base value (b) of the exponential function.
     * @param exponent is the fractional exponent value (x) of the
     *                 exponential function.
     * @return exponent value (b raised to x).
     */
    public static double fractionExponential(double base, double exponent){

        double exponentValue = 0;
        int numberOfIterations = 150;
        double logValueB = computeLogarithm(base);
        double eValueX = (exponent * logValueB);
        double eValueR = eValueX - (int) eValueX;
        while(numberOfIterations >= 0){
            double factorialValue = computeFactorial(numberOfIterations);
            double powerValue = computeExponential(eValueR , numberOfIterations); //powerValue
            exponentValue = exponentValue + (powerValue / factorialValue);
            numberOfIterations--;
        }
        double eValueN = computeExponential(e ,(int)eValueX);
        double finalResult = exponentValue * eValueN;
        return finalResult;
    }
}


