package ru.bolgov.task4;

import java.util.ArrayList;

public class DivisionColumn {
    private Division mainDivision;
    private ArrayList<Division> listDivisions = new ArrayList<>();

    public DivisionColumn(Division mainDivision) {
        this.mainDivision = mainDivision;
        this.createColumn();
    }

    public Division getMainDivision() {
        return mainDivision;
    }

    public ArrayList<Division> getListDivisions() {
        return listDivisions;
    }

    private void createColumn() {
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
        String strX = x + "";
        StringBuilder dividendBuilder = new StringBuilder("");

        for (int i = 0; i < strX.length(); i++) {
            dividendBuilder.append(strX.charAt(i));
            result = Integer.parseInt(dividendBuilder.toString());
            if (result >= y) {
                break;
            }
        }
        return result;
    }

    private int takeIntermediateRemainder(int x, Division d) {

        String result = (x + "").substring(lengthInt(d.getX()), lengthInt(x));
        result = d.getRemainder() + result;
        return Integer.parseInt(result);
    }

    private int lengthInt(int x) {
        String s = x + "";
        return s.length();
    }

}
