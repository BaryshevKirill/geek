package ru.geekbrains.lesson2;

public class MyArrayDataException extends Exception {

    public MyArrayDataException(String comment) {
        super("Не возможно конвертировать значение массива из String в Integer. " + comment);
    }

}
