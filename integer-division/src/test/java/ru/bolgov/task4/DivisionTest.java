package ru.bolgov.task4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class DivisionTest {

    @Test
    public void testZeroDivisor() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DivisionStep division = new DivisionStep(0, 0);
        });
        assertEquals("Divisor can`t be zero", exception.getMessage());
    }

    @Test
    public void testDivisorLessZero() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DivisionStep division = new DivisionStep(5, -1);
        });
        assertEquals("The divisor and dividend must be greater than zero", exception.getMessage());
    }

    @Test
    public void testDividendLessZero() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DivisionStep division = new DivisionStep(-5, 1);
        });
        assertEquals("The divisor and dividend must be greater than zero", exception.getMessage());
    }

    @Test
    public void testDividendLessDivisor() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DivisionStep division = new DivisionStep(5, 50);
        });
        assertEquals("The dividend must be greater than the divisor", exception.getMessage());
    }

    @Test
    public void testToStringInterimDivisor() {
        DivisionStep division = new DivisionStep(8743251, 874);
        assertEquals("_8743251|874\n" + " 874    |-----\n" + " ---    |10003\n" + "   _3251\n" + "    2622\n"
                + "    ----\n" + "     629", division.toString());
    }

    @Test
    public void testToStringOneY() {
        DivisionStep division = new DivisionStep(8743251, 1);
        assertEquals("_8743251|1\n" + " 8      |-------\n" + " -      |8743251\n" + " _7\n" + "  7\n" + "  -\n"
                + "  _4\n" + "   4\n" + "   -\n" + "   _3\n" + "    3\n" + "    -\n" + "    _2\n" + "     2\n"
                + "     -\n" + "     _5\n" + "      5\n" + "      -\n" + "      _1\n" + "       1\n" + "       -\n"
                + "        0", division.toString());
    }

    @Test
    public void testToStringOneDigit() {
        DivisionStep division = new DivisionStep(8743251, 5);
        assertEquals("_8743251|5\n" + " 5      |-------\n" + " -      |1748650\n" + "_37\n" + " 35\n" + " --\n"
                + " _24\n" + "  20\n" + "  --\n" + "  _43\n" + "   40\n" + "   --\n" + "   _32\n" + "    30\n"
                + "    --\n" + "    _25\n" + "     25\n" + "     --\n" + "       1", division.toString());
    }

    @Test
    public void testToStringTwoDigit() {
        DivisionStep division = new DivisionStep(8743251, 55);
        assertEquals("_8743251|55\n" + " 55     |------\n" + " --     |158968\n" + "_324\n" + " 275\n" + " ---\n"
                + " _493\n" + "  440\n" + "  ---\n" + "  _532\n" + "   495\n" + "   ---\n" + "   _375\n" + "    330\n"
                + "    ---\n" + "    _451\n" + "     440\n" + "     ---\n" + "      11", division.toString());
    }

    @Test
    public void testToStringDivisorEqualDivisible() {
        DivisionStep division = new DivisionStep(8743251, 8743251);
        assertEquals("_8743251|8743251\n" + " 8743251|-\n" + " -------|1\n" + "        0", division.toString());
    }
}
