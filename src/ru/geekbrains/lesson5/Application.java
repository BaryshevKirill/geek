package ru.geekbrains.lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Application {


    public static void main(String[] args) throws InterruptedException {

        MyArray.fillArray();

        /*Для последовательногоподсчета*/
        long a = System.currentTimeMillis();

        for (int i = 0; i < MyArray.getSIZE(); i++) {
            MyArray.getArr()[i] = (float)(MyArray.getArr()[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println(System.currentTimeMillis() - a);
        System.out.println("Пример результата для последовательного расчета: " + MyArray.getArr()[654646]);

        /*Для паралельного расчета*/
        MyArray.fillArray();

        List<MyThread> threadList = new LinkedList<>();
        threadList.add(new MyThread(0));
        threadList.add(new MyThread(MyArray.getH()));

        a = System.currentTimeMillis();

        for (MyThread thread : threadList) {
            thread.start();
        }

        for (MyThread thread : threadList) {
            thread.join();
        }

        System.arraycopy(threadList.get(0).getArr(), 0, MyArray.getArr(), 0, MyArray.getH());
        System.arraycopy(threadList.get(1).getArr(), 0, MyArray.getArr(), MyArray.getH(), MyArray.getH());

        System.out.println(System.currentTimeMillis() - a);
        System.out.println("Пример результата для параллельного расчета : " + MyArray.getArr()[654646]);

    }

}
