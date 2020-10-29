package ru.bolgov.task4;

import java.util.ArrayList;
import java.util.List;

public class ColumnDivision {
    private final DivisionStep mainDivision;
    private final List<DivisionStep> listDivisions;

    public ColumnDivision(DivisionStep mainDivision) {
        this.mainDivision = mainDivision;
        this.listDivisions = new ArrayList<>();
    }

    public DivisionStep getMainDivision() {
        return mainDivision;
    }

    public List<DivisionStep> getListDivisions() {
        return listDivisions;
    }

    public void createColumn() {
        int intermediateRemainder = this.mainDivision.getX();
        int y = this.mainDivision.getY();
        int remainder = this.mainDivision.getRemainder();

        while (intermediateRemainder != remainder) {
            int nextDividend = takeNextDivident(intermediateRemainder, y);
            DivisionStep d = new DivisionStep(nextDividend, y);
            this.listDivisions.add(d);
            intermediateRemainder = takeIntermediateRemainder(intermediateRemainder, d);
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

    private int takeIntermediateRemainder(int x, DivisionStep d) {

        String result = (Integer.toString(x)).substring(calculateLength(d.getX()), calculateLength(x));
        result = d.getRemainder() + result;
        return Integer.parseInt(result);
    }

    private int calculateLength(int x) {
        return Integer.toString(x).length();
    }

}
