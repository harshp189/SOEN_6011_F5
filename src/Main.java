import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char exitCharacter;
        double a,b,x;
        boolean improperInput = true;
        while(true && improperInput){
            try{
                System.out.println("********* Exponential Function *********");
                System.out.println("Enter the value of a: ");
                a = sc.nextDouble();
                System.out.println("Enter the value of b: ");
                b = sc.nextDouble();
                System.out.println("Enter the value of x: ");
                x = sc.nextDouble();

                if(a>0.0 && b!=1.0){
                    improperInput = false;
                }else {
                    improperInput = true;
                    System.out.println("Please enter valid inputs for a and b, inputs must be, a > 0 and b > 1 ");
                    continue;
                }

                if(!improperInput){
                    improperInput = true; // to continue asking inputs from the user unless e is entered.
                    double exponentialResult =  Exponential.computeExponential(b,x);
                    double result = a * exponentialResult;
                    System.out.println("Exponential function value is:" + result);

                }

            }catch(InputMismatchException e){
                System.out.println("Entered input is not a double value.");
            }catch(Exception e){
                System.out.println("Some Exception occurred.");
            }

            System.out.print("\nPress e/E to exit or any other key to continue : ");
            exitCharacter = sc.next().charAt(0);
            if (exitCharacter == 'e' || exitCharacter == 'E')
            {
                System.out.println("Thank you!!");
                break;
            }
            System.out.println("\n====================================================================");
        }

    }
}
