package ru.bolgov.task4;

public class Division {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
    }

    public int getResult() {
        return this.x / this.y;
    }
    
    public int getResult(int x, int y) {
        return x / y;
    }
 
    public int getRemainder() {
        return this.x % this.y;
    }
    
    public int getRemainder(int x, int y) {
        return x % y;
    }

    @Override
    public String toString() {
        ColumnDivision divisionColumn = new ColumnDivision(this);
        divisionColumn.createColumn();
        Printer print = new Printer();
        return print.buildResultString(divisionColumn);
    }

}
