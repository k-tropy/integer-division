package ru.bolgov.task4;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;



@ExtendWith(MockitoExtension.class)
public class PrinterTest {

    
    @Mock
    public ColumnDivision columnDivision;
    @Mock
    public Division division;
    public List<Integer[]> listDivisions;
    public Printer printer = new Printer();

    @BeforeEach
    void init() {
        columnDivision = mock(ColumnDivision.class);
        division = mock(Division.class);
    }


    @Test
    public void testToStringInterimDivisor() {
        listDivisions = new ArrayList<Integer[]>();
        listDivisions.add(new Integer[] { 874, 874, 1, 0 });
        listDivisions.add(new Integer[] { 3251, 874, 3, 629 });

        when(division.getDividend()).thenReturn(8743251);
        when(division.getDivisor()).thenReturn(874);
        when(division.getResult()).thenReturn(10003);
        when(division.getRemainder()).thenReturn(629);

        when(columnDivision.getMainDivision()).thenReturn(division);
        when(columnDivision.getListDivisions()).thenReturn(listDivisions);

        assertEquals("_8743251|874\n" + " 874    |-----\n" + " ---    |10003\n" + "   _3251\n" + "    2622\n"
                + "    ----\n" + "     629", printer.buildResultString(columnDivision));
    }

    @Test
    public void testToStringOneY() {
        listDivisions = new ArrayList<Integer[]>();
        listDivisions.add(new Integer[] { 8, 1, 8, 0 });
        listDivisions.add(new Integer[] { 7, 1, 7, 0 });
        listDivisions.add(new Integer[] { 4, 1, 4, 0 });
        listDivisions.add(new Integer[] { 3, 1, 3, 0 });
        listDivisions.add(new Integer[] { 2, 1, 2, 0 });
        listDivisions.add(new Integer[] { 5, 1, 5, 0 });
        listDivisions.add(new Integer[] { 1, 1, 1, 0 });

        when(division.getDividend()).thenReturn(8743251);
        when(division.getDivisor()).thenReturn(1);
        when(division.getResult()).thenReturn(8743251);
        when(division.getRemainder()).thenReturn(0);

        when(columnDivision.getMainDivision()).thenReturn(division);
        when(columnDivision.getListDivisions()).thenReturn(listDivisions);

        assertEquals("_8743251|1\n" + " 8      |-------\n" + " -      |8743251\n" + " _7\n" + "  7\n" + "  -\n"
                + "  _4\n" + "   4\n" + "   -\n" + "   _3\n" + "    3\n" + "    -\n" + "    _2\n" + "     2\n"
                + "     -\n" + "     _5\n" + "      5\n" + "      -\n" + "      _1\n" + "       1\n" + "       -\n"
                + "        0", printer.buildResultString(columnDivision));
    }

    @Test
    public void testToStringOneDigit() {
        listDivisions = new ArrayList<Integer[]>();
        listDivisions.add(new Integer[] { 8, 5, 1, 3 });
        listDivisions.add(new Integer[] { 37, 5, 7, 2 });
        listDivisions.add(new Integer[] { 24, 5, 4, 4 });
        listDivisions.add(new Integer[] { 43, 5, 8, 3 });
        listDivisions.add(new Integer[] { 32, 5, 6, 2 });
        listDivisions.add(new Integer[] { 25, 5, 5, 0 });

        when(division.getDividend()).thenReturn(8743251);
        when(division.getDivisor()).thenReturn(5);
        when(division.getResult()).thenReturn(1748650);
        when(division.getRemainder()).thenReturn(1);

        when(columnDivision.getMainDivision()).thenReturn(division);
        when(columnDivision.getListDivisions()).thenReturn(listDivisions);

        assertEquals(
                "_8743251|5\n" + " 5      |-------\n" + " -      |1748650\n" + "_37\n" + " 35\n" + " --\n" + " _24\n"
                        + "  20\n" + "  --\n" + "  _43\n" + "   40\n" + "   --\n" + "   _32\n" + "    30\n" + "    --\n"
                        + "    _25\n" + "     25\n" + "     --\n" + "       1",
                printer.buildResultString(columnDivision));
    }

    @Test
    public void testToStringTwoDigit() {
        listDivisions = new ArrayList<Integer[]>();
        listDivisions.add(new Integer[] { 87, 55, 1, 32 });
        listDivisions.add(new Integer[] { 324, 55, 5, 49 });
        listDivisions.add(new Integer[] { 493, 55, 8, 53 });
        listDivisions.add(new Integer[] { 532, 55, 9, 37 });
        listDivisions.add(new Integer[] { 375, 55, 6, 45 });
        listDivisions.add(new Integer[] { 451, 55, 8, 11 });

        when(division.getDividend()).thenReturn(8743251);
        when(division.getDivisor()).thenReturn(55);
        when(division.getResult()).thenReturn(158968);
        when(division.getRemainder()).thenReturn(11);

        when(columnDivision.getMainDivision()).thenReturn(division);
        when(columnDivision.getListDivisions()).thenReturn(listDivisions);

        assertEquals("_8743251|55\n" + " 55     |------\n" + " --     |158968\n" + "_324\n" + " 275\n"
                + " ---\n" + " _493\n" + "  440\n" + "  ---\n" + "  _532\n" + "   495\n" + "   ---\n"
                + "   _375\n" + "    330\n" + "    ---\n" + "    _451\n" + "     440\n" + "     ---\n"
                + "      11", printer.buildResultString(columnDivision));

    }

    @Test
    public void testToStringDivisorEqualDivisible() {
        listDivisions = new ArrayList<Integer[]>();
        listDivisions.add(new Integer[] { 8743251, 8743251, 1, 0 });

        when(division.getDividend()).thenReturn(8743251);
        when(division.getDivisor()).thenReturn(8743251);
        when(division.getResult()).thenReturn(1);
        when(division.getRemainder()).thenReturn(0);

        when(columnDivision.getMainDivision()).thenReturn(division);
        when(columnDivision.getListDivisions()).thenReturn(listDivisions);

        assertEquals("_8743251|8743251\n" + " 8743251|-\n" + " -------|1\n" + "        0",
                printer.buildResultString(columnDivision));
    }

}
