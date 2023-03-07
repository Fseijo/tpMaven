package org.example;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.Assert.assertEquals;
import static org.assertj.core.api.Assertions.*;


public class CalculatorTest {

    private Calculator calculatorUnderTest;
    private static Instant startedAt;

    @BeforeAll
    public static void initStartingTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
    }

    @AfterAll
    public static void showTestDuration() {
        System.out.println("Appel après tous les tests");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }

    @BeforeEach
    public void initCalculator() {
        calculatorUnderTest = new Calculator();
        System.out.println("Appel avant chaque test");
    }

    @AfterEach
    public void underCalculator() {
        System.out.println("Appel après chaque test");
        calculatorUnderTest = null;
    }

    @Test
    public void testAddTwoPositiveNumbers() {
        //Arrange
        int a = 2;
        int b = 3;

        //Act
        int somme = calculatorUnderTest.add(a, b);

        //Assert
        assertThat(somme).isEqualTo(5);
    }

    @Test
    public void multiply_shouldReturnTheProduct_ofTwoIntegers() {
        //Arrange
        int a = 42;
        int b = 11;

        int produit = calculatorUnderTest.multiply(a, b);

        //Assert
//        assertEquals(462, produit);
        assertThat(produit).isEqualTo(462);
    }

    @ParameterizedTest(name = "{0} x 0 doit être égal à 0")
    @ValueSource(ints = {1, 2, 42, 1001, 5089})
    public void multiply_shouldReturnZero_ofZeroWithMultipleIntegers(int arg) {
        //Arrange- Tout est prêt!
        //Act -- Multiplier par zéro
        int actualResult = calculatorUnderTest.multiply(arg, 0);
        //Assert - ça vaut toujurs zéro!
//        assertEquals(0, actualResult);
        assertThat(actualResult).isEqualTo(0);
    }

    @ParameterizedTest(name = "{0} + {1} doit être égal à {2}")
    @CsvSource({"1,1,2", "2,3,5", "42,57,99"})
    public void add_shouldReturnTheSum_ofMultipleIntegers(int arg1, int arg2, int expectedResult) {
        //Arrange -- Tout est prêt!
        //Act
        int actualResult = calculatorUnderTest.add(arg1, arg2);

        //Assert
        assertEquals(expectedResult, actualResult);
        assertThat(actualResult).isEqualTo(expectedResult);
    }


    @Test
    @Timeout(1)
    public void longCalcul_shouldComputeInLessThan1Seccond() {
        //Arrange -- Pas besoin!

        //Act
        calculatorUnderTest.longCalculation();

        //Assert -- Pas besoin!
    }

    @Test
    public void listDigits_shouldReturnsTheList_ofPositiveInteger(){
        //GIVEN
        int number = 95897;

        //WHEN
        Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);

        //THEN
//        Set<Integer> expectedDigits = Stream.of(5,7,8,9).collect(Collectors.toSet());
//        assertEquals(expectedDigits, actualDigits);

        assertThat(actualDigits).containsExactlyInAnyOrder(9,5,8,7);
    }

}
