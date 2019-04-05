package ru.geekbrains.lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    private static final int EXPECTED_MASS_SIZE = 4;

    public static void main(String[] args) {

        String[][] massStrok = null;
        String[][] massStrok2 = {{"1", "2", "1", "2"}, {"4", "5", "6", "-10"}, {"7", "7", "7", "7"}, {"/","1", "-21", "0"}};
        boolean isShowSecondMass = true;
        int countColumns;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Хотите задать массив в ручную? Да/Нет");

            if ("да".equals(reader.readLine().toLowerCase())) {
                isShowSecondMass = false;

                System.out.println("Укажите количество столбцов в матрице:");
                countColumns = Integer.parseInt(reader.readLine());

                massStrok = new String[countColumns][];
                for (int i = 0; i < countColumns; i++) {
                    System.out.println("Введите значения строки массива через запятую (Например 12,23,34):");
                    String str = reader.readLine();
                    massStrok[i] = str.split(",");

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

/*В зависимости от выбранного варианта ранее, суммируются елементы либо массива заданного в коде, либо заданного юзером*/
        try {
            if (isShowSecondMass) {
                System.out.println(summElements(massStrok2));
            } else {
                System.out.println(summElements(massStrok));
            }
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

    }


    private static int summElements(String[][] massString) throws MyArraySizeException, MyArrayDataException {

        int summElements = 0;

        if (massString.length != EXPECTED_MASS_SIZE) {
            throw new MyArraySizeException("Количество строк в матрице  равно " + massString.length);
        }

        for (int i = 0; i < EXPECTED_MASS_SIZE; i++) {
            if (massString[i].length != EXPECTED_MASS_SIZE) {
                throw new MyArraySizeException("Количесвто столбцов в матрице не равно " + EXPECTED_MASS_SIZE + " хотя бы в одной строке ");
            }
        }

        for (int i = 0; i < EXPECTED_MASS_SIZE; i++) {
            for (int j = 0; j < EXPECTED_MASS_SIZE; j++) {
                summElements += convertToInteger(massString[i][j], i, j);
            }
        }
        return summElements;
    }

    private static int convertToInteger(String str, int line, int column) throws MyArrayDataException {
        int value;
        try {
            value = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new MyArrayDataException(String.format("В эелемента массива [%d][%d] лежит значение %s", line, column, str));
        }
        return value;
    }

}
