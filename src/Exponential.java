public class Exponential {

    //rename b to base and x to exponent.
    public static double computeExponential(double b, double x) {

        if(x<0.0){
            b = 1/b;
            x = -x;
            if(x%2==0.0){
                return computeExponential(b,x/2) * computeExponential(b,x/2);
            }
            else{
                x = x -1;
                return b * computeExponential(b,x/2)*computeExponential(b,x/2);
            }
        }else if(x==0.0){
            return 1.0;
        }else if(x==1.0){
            return b;
        }else if(x % 2==0.0){
            return computeExponential(b,x/2)*computeExponential(b,x/2);
        }else{
            x = x - 1;
            return b * computeExponential(b,x/2)*computeExponential(b,x/2);
        }




    }
}
