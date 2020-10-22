package ru.bolgov.task4;

public class Printer {
    private String result = "";

    public Printer(Division division) {
        DivisionColumn divisionColumn = new DivisionColumn(division);
        createResult(divisionColumn);
    }

    public String getResult() {
        return result;
    }

    private void createResult(DivisionColumn dc) {
        result = createFirst(dc) + createSecondThird(dc) + createOtherLines(dc);
    }

    private String createFirst(DivisionColumn dc) {
        return String.format("_%d|%d\n", dc.getMainDivision().getX(), dc.getMainDivision().getY());

    }

    private String createSecondThird(DivisionColumn dc) {
        int widthResult = lengthInt(dc.getMainDivision().getIntResult());
        int widthX = lengthInt(dc.getMainDivision().getX());

        StringBuilder resultBuilder = new StringBuilder();
        Division d = dc.getListDivisions().get(0);
        int intPart = takeIntPart(d);

        resultBuilder.append(
                " " + intPart + createGaps(widthX - lengthInt(intPart)) + "|" + createDashs(widthResult) + "\n");

        resultBuilder.append(" " + createDashs(lengthInt(intPart)) + createGaps(widthX - lengthInt(intPart)) + "|"
                + dc.getMainDivision().getIntResult() + "\n");

        return resultBuilder.toString();
    }

    private String createOtherLines(DivisionColumn dc) {
        StringBuilder resultBuilder = new StringBuilder();
        int indent = 0;
        int count = 0;

        for (Division d : dc.getListDivisions()) {

            if (0 == count) {
                indent = moveIndent(d, indent);
                indent = nextLineIndent(d, indent);
                count++;
                continue;
            }

            resultBuilder.append(createGaps(indent) + "_" + d.getX() + "\n");
            indent = moveIndent(d, indent);
            resultBuilder.append(createGaps(indent) + " " + takeIntPart(d) + "\n");
            resultBuilder.append(createGaps(indent) + " " + createDashs(lengthInt(takeIntPart(d))) + "\n");
            indent = nextLineIndent(d, indent);
        }

        resultBuilder.append(createLastLine(dc, indent));
        return resultBuilder.toString();
    }

    private String createLastLine(DivisionColumn dc, int indent) {
        return createGaps(indent + 1) + dc.getMainDivision().getRemainder();
    }

    private int lengthInt(int x) {
        return (x + "").length();
    }

    private int takeIntPart(Division d) {
        return d.getY() * d.getIntResult();
    }

    private String createGaps(int n) {
        return 0 == n ? "" : String.format("%" + n + "s", "");
    }

    private String createDashs(int n) {
        return String.format("%" + n + "s", "").replace(" ", "-");
    }

    private int moveIndent(Division d, int indent) {
        return (indent + lengthInt(d.getX()) - lengthInt(takeIntPart(d)));
    }

    private int nextLineIndent(Division d, int indent) {
        indent += lengthInt(takeIntPart(d));
        if (0 != d.getRemainder()) {
            indent -= lengthInt(d.getRemainder());
        }
        return indent;
    }
}