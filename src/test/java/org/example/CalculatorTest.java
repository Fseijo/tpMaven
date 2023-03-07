package org.example;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

public class CalculatorTest {
    @Test
    public void testAddTwoPositiveNumbers(){
       //Arrange
        int a = 2;
        int b = 3;
        
        Calculator calculator = new Calculator();
        
        //Act
        int somme = calculator.add(a, b);
        
        //Assert
        assertEquals(5, somme);
    }

    @Test
    public void testsubsTwoPositiveNumbers(){
        //Arrange
        int a = 15;
        int b = 3;

        Calculator calculator = new Calculator();

        //Act
        int subs = calculator.subs(a, b);

        //Assert
        assertEquals(12, subs);
    }
}
