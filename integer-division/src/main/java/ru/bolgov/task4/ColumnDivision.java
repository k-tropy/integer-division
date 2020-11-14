package ru.bolgov.task4;

import static ru.bolgov.task4.DivisionHelper.calculateLength;

import java.util.ArrayList;
import java.util.List;

public class ColumnDivision {
    private final Division mainDivision;
    private final List<Integer[]> listDivisions;

    public ColumnDivision(Division mainDivision) {
        this.mainDivision = mainDivision;
        this.listDivisions = new ArrayList<>();
    }

    public Division getMainDivision() {
        return mainDivision;
    }

    public List<Integer[]> getListDivisions() {
        return listDivisions;
    }

    public void createColumn() {
        int remainderOfMainDividend = this.mainDivision.getDividend();
        int y = this.mainDivision.getDivisor();
        int remainder = this.mainDivision.getRemainder();

        while (remainderOfMainDividend != remainder) {
            int nextDividend = takeNextDivident(remainderOfMainDividend, y);
            int nextResult = mainDivision.getResult(nextDividend, y);
            int nextRemainder = mainDivision.getRemainder(nextDividend, y);

            this.listDivisions.add(new Integer[] { nextDividend, y, nextResult, nextRemainder });
            remainderOfMainDividend = takeIntermediateRemainder(remainderOfMainDividend, nextDividend, nextRemainder);
        }

    }

    private int takeNextDivident(int x, int y) {
        int result = 0;
        String xAsString = Integer.toString(x);
        StringBuilder dividendBuilder = new StringBuilder("");

        for (int i = 0; i < xAsString.length(); i++) {
            dividendBuilder.append(xAsString.charAt(i));
            result = Integer.parseInt(dividendBuilder.toString());
            if (result >= y) {
                break;
            }
        }
        return result;
    }

    private int takeIntermediateRemainder(int remainderOfMainDividend, int nextDividend, int nextRemainder) {
        StringBuilder result = new StringBuilder();
        result.append(Integer.toString(nextRemainder)).append(Integer.toString(remainderOfMainDividend)
                .substring(calculateLength(nextDividend), calculateLength(remainderOfMainDividend)));

        return Integer.parseInt(result.toString());
    }


}
