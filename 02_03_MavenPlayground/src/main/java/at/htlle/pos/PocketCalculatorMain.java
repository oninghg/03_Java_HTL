package at.htlle.pos;

public class PocketCalculatorMain {
    static void main(){
        long  result = PocketCalculator.addition(-2, -4);
        int excpected = 6;
        String testResult;
        if (result  == excpected) testResult = "OK";
        else testResult = "FAILED";
        System.out.println("Simple addition:");
        System.out.printf("PocketCalculator.addition(1,2) expected result = %d, acutal = %d\n", excpected, result); // 3
        System.out.println("---");

        //adding negative numbers
        System.out.println("---");
        System.out.println("Adding negative numbers");
        // -1, 2 => positive result
        // 2, -1 => positive result
        // 1 -2 => negative result
        // -2, -4 => negative result
        // 1, -1 => 0
        // underflow: INTEGER.MIN_VALUE, -1


    }
}
