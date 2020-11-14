package ru.bolgov.task4;

public class Division {
    private int dividend;
    private int divisor;
    private int result;
    private int remainder;

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
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
        this.dividend = x;
        this.divisor = y;
        this.result = getResult(x,y);
        this.remainder = getRemainder(x,y);
    }

    public int getResult() {
        return this.result;
    }
    
    public int getResult(int x, int y) {
        return x / y;
    }
 
    public int getRemainder() {
        return this.remainder;
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
