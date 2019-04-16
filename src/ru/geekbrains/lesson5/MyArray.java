package ru.geekbrains.lesson5;

import java.util.Arrays;

public class MyArray {

    private static final int SIZE = 10000000;
    private static final int h = SIZE / 2;
    private static float[] arr;

    public static int getSIZE() {
        return SIZE;
    }

    public static int getH() {
        return h;
    }

    public static float[] getArr() {
        return arr;
    }

    public static void setArr(float[] arr) {
        MyArray.arr = arr;
    }

    public static void fillArray() {

        arr = new float[SIZE];
        Arrays.fill(arr,1f);

    }
}
