package at.htlle.pos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PocketCalculatorTest {

    @DisplayName("Simple Name: 1+2=3")
    @Test
    void testadditionwithTwoPositiveNumbers() {
        //setup
        final int expected = 3;
        //exercise
        long result = PocketCalculator.addition(1,2);
        //verifiy
        assertEquals(expected,result);
        //teardown
    }

    @DisplayName("Simple Name: 2+(-4) = -2")
    @Test
    void testAdditionwithNegativeOutcome(){
        final int expected = -2;
        long result = PocketCalculator.addition(2, -4);
        assertEquals(expected, result);
    }

    @DisplayName("Simple Name: 1+(-1)=0")
    @Test
    void testAdditionwithOutcomeNull(){
        final int expected = 0;
        long result = PocketCalculator.addition(1, -1);
        assertEquals(expected,result);
    }

    @DisplayName("Simple Name: MaxInt+1 = MaxInt")
    @Test
    void testAdditionwithMaxNumber(){
        final long expected = 2147483648L;
        //final int expected = Integer.MAX_VALUE + 1
        long result = PocketCalculator.addition(Integer.MAX_VALUE, 1);
        assertEquals(expected, result);
    }


    @DisplayName("Simple Name: 1-2 = -1")
    @Test
    void testSubtraction(){
        final int expected = -1;
        long result = PocketCalculator.subtraction(1, 2);
        assertEquals(expected, result);
    }

    @DisplayName("Simple Name: -1-(-2) = 1")
    @Test
    void testSubtractionwithnegativeNumbers(){
        final int expected = 1;
        long result = PocketCalculator.subtraction(-1, -2);
        assertEquals(expected, result);
    }

    @DisplayName("Simple Name: -MaxInt-1 = -MaxInt")
    @Test
    void testSubtractionwithMaxInt(){
        final long expected = -2147483648L;
        long result = PocketCalculator.subtraction(-Integer.MAX_VALUE, 1);
        assertEquals(expected, result);
    }

    @DisplayName("Simple Name: 2*4=8")
    @Test
    void testMultiplication(){
        final int expected = 8;
        long result = PocketCalculator.multiplication(2, 4);
        assertEquals(expected, result);
    }

    @DisplayName("Simple Name: 1*(-2) = -2")
    @Test
    void testMultiplicationwithNegative(){
        final int expected = -2;
        long result = PocketCalculator.multiplication(1, -2);
        assertEquals(expected, result);
    }

    @DisplayName("Simple Name: MaxInt*1 = MaxInt")
    @Test
    void testMultiplicationwithMaxInt(){
        final long expected = 2147483647L;
        long result = PocketCalculator.multiplication(Integer.MAX_VALUE, 1);
        assertEquals(expected, result);
    }

    @DisplayName("Simple Name: 4/2=2")
    @Test
    void testDivision(){
        final double expected = 2;
        double result = PocketCalculator.division(4, 2);
        assertEquals(expected, result);
    }

    @DisplayName("Simple Name: 4/(-2) = -2")
    @Test
    void testDivisonwithNegative(){
        final int expected = -8;
        long result = PocketCalculator.multiplication(4, -2);
        assertEquals(expected, result);
    }

    @DisplayName("Simple Name: 3/0 = IllegalArgumentException")
    @Test
    void testDivisionwithNull(){
        assertThrows(IllegalArgumentException.class , () -> PocketCalculator.division(3, 0));
    }



}