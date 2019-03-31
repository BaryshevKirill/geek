package ru.geekbrains.lesson1;

import ru.geekbrains.lesson1.animal.Cat;
import ru.geekbrains.lesson1.animal.Dog;
import ru.geekbrains.lesson1.animal.Human;
import ru.geekbrains.lesson1.animal.Robot;
import ru.geekbrains.lesson1.course.Course;
import ru.geekbrains.lesson1.course.Cross;
import ru.geekbrains.lesson1.course.Wall;
import ru.geekbrains.lesson1.course.Water;
import ru.geekbrains.lesson1.enums.Color;

/**
 * Класс для запуска приложения - симулятор кросса
 */
public class Application {

    public static void main(String[] args) {
        Team team = new Team(
                new Cat("Барсик", Color.BLACK, 1, 100, 5),
                new Dog("Черный",Color.GRAY,4,300,30,50),
                new Human("Игнат",23,100,2,200),
                new Robot("modelX",500,200)
        );

        Course course = new Course(
                new Cross(50),
                new Wall(4),
                new Cross(90),
                new Water(5)
        );

        if(team.size() == 0) {
            System.out.println("Команда участник пуста");
            return;
        }

        if(course.size() == 0) {
            System.out.println("Отсутствуют препятствия на трассе");
            return;
        }

        team.getAllTeam();

        System.out.println("\n!!!Начинаем состязание!!!");

        course.doIt(team);

        System.out.println("!!!Окончание состязания!!!\n");

        team.showResults();
    }
}
