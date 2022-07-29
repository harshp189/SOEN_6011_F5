package com.exponential;

public class Exponential {
    public static double e = 2.7182818284590;


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


    public static double computeFactorial(double number){
        if(number == 0){
            return 1;
        }
        return (number * computeFactorial(number - 1));
    }


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


