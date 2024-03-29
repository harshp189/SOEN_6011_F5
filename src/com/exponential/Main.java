package com.exponential;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /**
     * This main method contains implementation of basic command line interface,
     * for asking input from the user. The command line asks for the input values
     * a, b(base) and x(exponent) from the user.
     *
     * @param args
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        char exitCharacter;
        double a;
        double b;
        double x;
        boolean improperInput = true;
        while (improperInput) {
            try {
                System.out.println("************************"
                        + " Exponential Function ************************");
                System.out.print("Enter the value of a: \n");
                a = sc.nextDouble();
                System.out.println("Enter the value of b: ");
                b = sc.nextDouble();
                System.out.println("Enter the value of x: ");
                x = sc.nextDouble();
                boolean incorrectInput = input(a, b, x);
                if (incorrectInput) {
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entered input is not a numeric value. "
                        + "Please enter values from the domain of the function."
                       + "\nDo you want to continue?");
            } catch (Exception e) {
                System.out.println("Some Exception occurred.");
            }
            sc.nextLine();
            System.out.print("\nType e/E to exit or "
                    + "any other key to continue : \n");
            exitCharacter = sc.next().charAt(0);
            if (exitCharacter == 'e' || exitCharacter == 'E') {
                System.out.println("Thank you! Bye..");
                improperInput = false;
            }

        }

    }

    /**
     * This method validates the input values entered by the user.
     * @param a is the value of a
     * @param b is the value of base
     * @param x is the value of exponent
     * @return boolean value (true/false)
     */

    public static boolean input(double a, double b, double x) {
        boolean improperInput;
        if (a != 0.0 && b > 0.0) {
            improperInput = false;
        } else {
            improperInput = true;
            System.out.println("Please enter valid inputs for"
                    + " a and b, \nFor a, input value must not be equal to 0 "
                    + "and For b, it must be greater than 0 (b > 0) ");
        }
        if (!improperInput) {
            double exponentialRes;
            exponentialRes = Exponential.computeExponential(b, x);
            double result = a * exponentialRes;
            System.out.println("Exponential function "
                    + "value is : " + result);
        }
        return improperInput;
    }
}