package ru.bolgov.task4;

public class Printer {

    public String buildResultString(ColumnDivision dc) {
        return buildFirstStepString(dc) + buildSecondThirdStepString(dc) + buildLastStepString(dc);
    }

    private String buildFirstStepString(ColumnDivision dc) {
        return String.format("_%d|%d", dc.getMainDivision().getX(), dc.getMainDivision().getY()) + "\n";

    }

    private String buildSecondThirdStepString(ColumnDivision dc) {
        int widthResult = calculateLength(dc.getMainDivision().getIntResult());
        int widthDividend = calculateLength(dc.getMainDivision().getX());

        StringBuilder resultBuilder = new StringBuilder();
        DivisionStep d = dc.getListDivisions().get(0);
        int intPart = takeIntPart(d);

        resultBuilder.append(" ")
                     .append(intPart)
                     .append(createGaps(widthDividend - calculateLength(intPart)))
                     .append("|")
                     .append(createDashes(widthResult))
                     .append("\n");

        resultBuilder.append(" ")
                     .append(createDashes(calculateLength(intPart)))
                     .append(createGaps(widthDividend - calculateLength(intPart)))
                     .append("|")
                     .append(dc.getMainDivision().getIntResult())
                     .append("\n");

        return resultBuilder.toString();
    }

    private String buildLastStepString(ColumnDivision dc) {
        StringBuilder resultBuilder = new StringBuilder();
        int indent = 0;
        int count = 0;

        for (DivisionStep d : dc.getListDivisions()) {

            if (0 == count) {
                indent = moveIndentForSubtractedPart(d, indent);
                indent = takeIndentNextDivisionStep(d, indent);
                count++;
                continue;
            }

            resultBuilder.append(createGaps(indent))
                         .append("_")
                         .append(d.getX())
                         .append("\n");
            indent = moveIndentForSubtractedPart(d, indent);
            resultBuilder.append(createGaps(indent))
                         .append(" ")
                         .append(takeIntPart(d))
                         .append("\n");
            resultBuilder.append(createGaps(indent))
                         .append(" ")
                         .append(createDashes(calculateLength(takeIntPart(d))))
                         .append("\n");
            indent = takeIndentNextDivisionStep(d, indent);
        }

        resultBuilder.append(buildLastLine(dc, indent));
        return resultBuilder.toString();
    }

    private String buildLastLine(ColumnDivision dc, int indent) {
        return createGaps(indent + 1) + dc.getMainDivision().getRemainder();
    }

    private int calculateLength(int x) {
        return Integer.toString(x).length();
    }

    private int takeIntPart(DivisionStep d) {
        return d.getY() * d.getIntResult();
    }

    private String createGaps(int n) {
        return 0 == n ? "" : String.format("%" + n + "s", "");
    }

    private String createDashes(int n) {
        return String.format("%" + n + "s", "").replace(" ", "-");
    }

    private int moveIndentForSubtractedPart(DivisionStep d, int indent) {
        return (indent + calculateLength(d.getX()) - calculateLength(takeIntPart(d)));
    }

    private int takeIndentNextDivisionStep(DivisionStep d, int indent) {
        indent += calculateLength(takeIntPart(d));
        if (0 != d.getRemainder()) {
            indent -= calculateLength(d.getRemainder());
        }
        return indent;
    }
}
