package ru.bolgov.task4;

import java.util.ArrayList;
import java.util.List;

public class DivisionColumn {
    private final Division mainDivision;
    private final List<Division> listDivisions;

    public DivisionColumn(Division mainDivision) {
        this.mainDivision = mainDivision;
        this.listDivisions = new ArrayList<>();
    }

    public Division getMainDivision() {
        return mainDivision;
    }

    public List<Division> getListDivisions() {
        return listDivisions;
    }

    void createColumn() {
        int intermediateRemainder = this.mainDivision.getX();
        int y = this.mainDivision.getY();
        int remainder = this.mainDivision.getRemainder();

        while (intermediateRemainder != remainder) {
            int nextDividend = takeNextDivident(intermediateRemainder, y);
            Division d = new Division(nextDividend, y);
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

    private int takeIntermediateRemainder(int x, Division d) {

        String result = (Integer.toString(x)).substring(lengthInt(d.getX()), lengthInt(x));
        result = d.getRemainder() + result;
        return Integer.parseInt(result);
    }

    private int lengthInt(int x) {
        return Integer.toString(x).length();
    }

}
