package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;
import ru.geekbrains.lesson1.enums.Color;

public class Dog extends Animal implements Participant {

    private boolean isOnDistance;
    private int runDistance;
    private int jumpHeight;
    private int swimDistance;

    public Dog(String name, Color color, int age, int runDistance, int jumpHeight, int swimDistance) {
        super(name, color, age);
        this.isOnDistance = true;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
        this.swimDistance = swimDistance;
    }

    public Dog(String name, Color color) {
        super(name, color, 0);
    }

    @Override
    public void voice() {
        System.out.println("Гав");
    }

    @Override
    public boolean isOnDistance() {
        return isOnDistance; // TODO доработать по аналогии с классом Cat
    }

    @Override
    public void run(int distance) {
        if (!isOnDistance) {
            return;
        }
        if (distance > runDistance) {
            System.out.println(String.format("Пес %s не смог пробежать кросс", getName()));
            isOnDistance = false;
            return;
        }
        System.out.println(String.format("Пес %s пробежал кросс длинной %d", getName(), distance));
    }

    @Override
    public void jump(int height) {
        if (!isOnDistance) {

            return;
        }
        if (height > jumpHeight) {
            System.out.println(String.format("Пес %s не смог перепрыгнуть препятствие", getName()));
            isOnDistance = false;
            return;
        }
        System.out.println(String.format("Пес %s прыгнул на высоту %d", getName(), height));
    }

    @Override
    public void swim(int distance) {
        if (!isOnDistance) {
            return;
        }
        if (distance > swimDistance) {
            System.out.println(String.format("Пес %s не смог прорлыть дистанцию", getName()));
            isOnDistance = false;
            return;
        }
        System.out.println(String.format("Пес %s проплыл дистанцию %d", getName(), swimDistance));
    }

    @Override
    public String getInfoAboutParticipant() {
        return String.format("Участник собака %s, возраст %d, цвет %s", getName(),getAge(),getColor().getName());
    }

}
