package ru.bolgov.task4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class DivisionTest {

    @Test
    public void testZeroDivisor() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Division division = new Division(0, 0);
        });
        assertEquals("Divisor can`t be zero", exception.getMessage());
    }

    @Test
    public void testDivisorLessZero() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Division division = new Division(5, -1);
        });
        assertEquals("The divisor and dividend must be greater than zero", exception.getMessage());
    }

    @Test
    public void testDividendLessZero() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Division division = new Division(-5, 1);
        });
        assertEquals("The divisor and dividend must be greater than zero", exception.getMessage());
    }

    @Test
    public void testDividendLessDivisor() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Division division = new Division(5, 50);
        });
        assertEquals("The dividend must be greater than the divisor", exception.getMessage());
    }
    
}
