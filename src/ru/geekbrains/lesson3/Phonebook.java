package ru.geekbrains.lesson3;

import java.lang.reflect.Array;
import java.util.*;
/*Карта вида Map<String Integer> не подходит, т.к. однофамильцы перезатрут друг друга.
 * Есть 3 варианта
 * 1) Map<String,List<String>>
 * 2) Map <String, String> - ключ это номер телефона
 * 3) Можно реализовать через set где элементы будет "Барышев - 123123123" но это наверно костыль*/

public class Phonebook {

    Map<String, List<String>> phoneBook = new HashMap<>();

    public void get(String name) {
        if(!phoneBook.containsKey(name)) {
            System.out.println("Не найден абонента с именем " + name);
            return;
        }

        if(phoneBook.get(name).size() == 1) {
            System.out.println(String.format("Номер телефона для человека с фамилией %s - %s", name, phoneBook.get(name).get(0)));
            return;
        }

        int pos = 1;
        System.out.println("В справчокнике найдено несколько телефонов для фамилии " + name);
        for(String number : phoneBook.get(name)) {
            System.out.println(String.format("%d. %s", pos, number));
            pos++;
        }
    }

    public void add(String name,  String numberPhone) throws NullPointerException {

        List<String> list = new ArrayList<>();
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(numberPhone);
        } else {
            list.add(numberPhone);
//            phoneBook.put(name, Collections.singletonList(numberPhone));
            phoneBook.put(name, list);
        }

    }
}
