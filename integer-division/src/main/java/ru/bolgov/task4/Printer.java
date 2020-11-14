package ru.bolgov.task4;

import static ru.bolgov.task4.DivisionHelper.*;

public class Printer {

    public String buildResultString(ColumnDivision dc) {
        return buildFirstStepString(dc) + buildSecondThirdStepString(dc) + buildLastStepString(dc);
    }

    private String buildFirstStepString(ColumnDivision dc) {
        return String.format("_%d|%d", dc.getMainDivision().getDividend(), dc.getMainDivision().getDivisor()) + "\n";

    }

    private String buildSecondThirdStepString(ColumnDivision dc) {
        int widthResult = calculateLength(dc.getMainDivision().getResult());
        int widthDividend = calculateLength(dc.getMainDivision().getDividend());

        StringBuilder resultBuilder = new StringBuilder();
        Integer[] d = dc.getListDivisions().get(0);
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
                     .append(dc.getMainDivision().getResult())
                     .append("\n");

        return resultBuilder.toString();
    }

    private String buildLastStepString(ColumnDivision dc) {
        StringBuilder resultBuilder = new StringBuilder();
        int indent = 0;
        int count = 0;

        for (Integer[] d : dc.getListDivisions()) {

            if (0 == count) {
                indent = moveIndentForSubtractedPart(d, indent);
                indent = takeIndentNextDivisionStep(d, indent);
                count++;
                continue;
            }

            resultBuilder.append(createGaps(indent))
                         .append("_")
                         .append(d[0])
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

    private int takeIntPart(Integer [] d) {
        return d[1] * d[2];
    }

    private String createGaps(int n) {
        return 0 == n ? "" : String.format("%" + n + "s", "");
    }

    private String createDashes(int n) {
        return String.format("%" + n + "s", "").replace(" ", "-");
    }

    private int moveIndentForSubtractedPart(Integer[] d, int indent) {
        return (indent + calculateLength(d[0]) - calculateLength(takeIntPart(d)));
    }

    private int takeIndentNextDivisionStep(Integer[] d, int indent) {
        indent += calculateLength(takeIntPart(d));
        if (0 != d[3]) {
            indent -= calculateLength(d[3]);
        }
        return indent;
    }
}
