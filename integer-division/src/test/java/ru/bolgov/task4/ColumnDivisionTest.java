package ru.bolgov.task4;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ColumnDivisionTest {
    public static ColumnDivision columnDivision;

    @Mock
    public static Division mainDivision;

    @BeforeAll
    public static void init() {
        mainDivision = mock(Division.class);
        when(mainDivision.getDividend()).thenReturn(96545654);
        when(mainDivision.getDivisor()).thenReturn(545);
        when(mainDivision.getResult(anyInt(), anyInt())).thenAnswer(new Answer<Integer>() {
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                return (int) invocation.getArgument(0) / (int) invocation.getArgument(1);
            }
        });

        when(mainDivision.getRemainder(anyInt(), anyInt())).thenAnswer(new Answer<Integer>() {
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                return (int) invocation.getArgument(0) % (int) invocation.getArgument(1);
            }
        });
        when(mainDivision.getResult()).thenReturn(177147);
        when(mainDivision.getRemainder()).thenReturn(539);
        columnDivision = new ColumnDivision(mainDivision);
        columnDivision.createColumn();
    }


    @Test
    public void testFirstIntermediateRemainder() {
        int result = columnDivision.getListDivisions().get(0)[3];
        assertEquals(420, result);
    }

    @Test
    public void testLastIntermediateRemainder() {
        int lastIndex = columnDivision.getListDivisions().size() - 1;
        int result = columnDivision.getListDivisions().get(lastIndex)[3];
        //assertEquals(mainDivision.getRemainder(), result);
        assertEquals(539, result);
    }

    @Test
    public void testFirstIntermediateDivident() {
        int result = columnDivision.getListDivisions().get(0)[0];
        assertEquals(965, result);
    }

    @Test
    public void testLastIntermediateDivident() {
        int lastIndex = columnDivision.getListDivisions().size() - 1;
        int result = columnDivision.getListDivisions().get(lastIndex)[0];
        assertEquals(4354, result);
    }
}
