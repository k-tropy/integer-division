package ru.bolgov.task4;

public class Division {
    private int x;
    private int y;
    private int intResult;
    private int remainder;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getIntResult() {
        return intResult;
    }

    public int getRemainder() {
        return remainder;
    }

    public Division(int x, int y) {
        if (0 == y) {
            throw new IllegalArgumentException("Divisor can`t be zero");
        }
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("The divisor and dividend must be greater than zero");
        }
        if (x < y) {
            throw new IllegalArgumentException("The dividend must be greater than the divisor");
        }
        this.x = x;
        this.y = y;
        this.intResult = this.takeResult(x, y);
        this.remainder = this.takeRemainder(x, y);
    }

    private int takeResult(int x, int y) {
        return x / y;
    }

    private int takeRemainder(int x, int y) {
        return x % y;
    }

    @Override
    public String toString() {
        DivisionColumn divisionColumn = new DivisionColumn(this);
        divisionColumn.createColumn();
        Printer print = new Printer();
        return print.createResult(divisionColumn);
    }

}
