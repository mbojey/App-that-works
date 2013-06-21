package com.snapquack.calculus;


public class Integrator {

    public static double integrate(Expression original, double a, double b){
        int n = 2500;
        double f_a = Simplifier.substitute(original, a);
        double f_b = Simplifier.substitute(original, b);  
        double h = (b-a)/n;
        double evenSum = 0, oddSum = 0;
        for(int i = 1; i <= (n/2)-1; i++){
            evenSum += Simplifier.substitute(original, (a+(2*i*h)));
        }
        for(int i = 1; i <= (n/2); i++){
            oddSum += Simplifier.substitute(original, (a+(((2*i)-1)*h)));
        }
        double result = (h/3)*(f_a+f_b+4*oddSum+2*evenSum);
        return result;
    }
}
