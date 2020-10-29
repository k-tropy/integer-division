package ru.bolgov.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите делимое:");
        int x = Integer.parseInt(reader.readLine());
        System.out.println("Введите делитель:");
        int y = Integer.parseInt(reader.readLine());
        reader.close();

        DivisionStep division = new DivisionStep(x, y);
        System.out.println(division.toString());

    }
}
