package ru.geekbrains.lesson3;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        /*Первое задание*/
        System.out.println("---------Первое задание---------");
        String[] arraysOfString = {"JAVA", "KOTLIN", "C", "C++", "C#", "JAVA", "PERL", "KOTLINS", "JAVA", "PYTHON", "C++", "PHP", "HTML-\"язык разработки\"", "JAVA", "KOTLIN"};
        Map<String, Integer> map;

        map = calculateCountSimilarWords(arraysOfString);
        showUniqueWords(map);
        System.out.println();
        showMap(map);

//        Map<String, Integer> map2 = new HashMap<>();
//        map2.put("qwe", null);
//        showUniqueWords(map2);
//        showMap(null);

        /*Второе задание*/
        System.out.println("---------Второе задание---------");
        Phonebook phonebook = new Phonebook();
        phonebook.add("Петров","111111");
        phonebook.add("Барышев","222222");
        phonebook.add("Барышева","333333");
        phonebook.add("Игнат","444444");
        phonebook.add("Петров","555555");
        phonebook.add("Черина","666666");
        phonebook.add("Барсик","777777");
        phonebook.add("Грей","888888");
        phonebook.add("Барышев","999999");
        phonebook.add("Барышев","8913123123");

        phonebook.get(null);
        phonebook.get("Барышев");
        phonebook.get("Плюшкин");
        phonebook.get("Грей");


    }

    private static Map<String, Integer> calculateCountSimilarWords(String[] arraysOfString) {
        Map<String, Integer> map = new HashMap<>();

        if (arraysOfString == null || arraysOfString.length == 0) {
            System.out.println("!!!Вы передали пустой массив!!!!");
        }

        for (String str : arraysOfString) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        return map;
    }

    /*Метод вывода уникальных слов из массива*/
    private static void showUniqueWords(Map<String, Integer> map) {
        System.out.println("В массиве найдены следующие уникальные слова (неповторяющиеся элементы массива):");
        int pos = 1;
        try {
            for (Map.Entry entry : map.entrySet()) {
                if ((int) entry.getValue() == 1) {
                    System.out.println(pos + ". " + entry.getKey());
                    pos++;
                }
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

    }

    /*Вывод эелементов карты*/
    private static void showMap(Map<String, Integer> map) {
        System.out.println("Список эелментов массива и их количество");

        int pos = 1;
        if(map == null || map.size() == 0) {
            System.out.println("Задана пустая карта");
            return;
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(String.format("%d. Слово \"%s\" встретилось %d раз", pos, entry.getKey(), entry.getValue()));
            pos++;
        }
    }

}
