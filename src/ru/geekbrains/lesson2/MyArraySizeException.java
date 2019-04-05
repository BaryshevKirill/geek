package ru.geekbrains.lesson2;

public class MyArraySizeException extends Exception{

    public MyArraySizeException(String comment) {
        super("Переданный массив не соответствует размеру 4х4. " + comment);
    }

}
