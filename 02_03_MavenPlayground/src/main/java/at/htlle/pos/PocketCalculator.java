package at.htlle.pos;

// Tool class to provide functionality to compute basic stuff
public class PocketCalculator {
    //basic calculations
    //
    // +,-,*,/

    public static long addition(int numb1, int numb2){
        return (long)numb1 + numb2;
    }

    public static long subtraction(int numb1, int numb2){
        return (long)numb1 - numb2;
    }

    public static long multiplication(int numb1, int numb2){
        return (long)numb1 * numb2;
    }

    public static double division(int numb1, int numb2){
        if(numb2 == 0){
            throw new IllegalArgumentException("Division throught null not possible");
        }
        return (double)numb1 / numb2;
    }





}
