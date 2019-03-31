package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;
import ru.geekbrains.lesson1.enums.Color;

public class Human extends Animal implements Participant {

    private boolean isOnDistance;
    private int runDistance;
    private int jumpHeight;
    private int swimDistance;

    public Human(String name, int age, int runDistance, int jumpHeight, int swimDistance) {

        super(name, null, age);
        this.isOnDistance = true;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
        this.swimDistance = swimDistance;
    }

    public Human(String name) {
        super(name, null, 0);
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
            System.out.println(String.format("Человек %s не смог пробежать кросс", getName()));
            isOnDistance = false;
            return;
        }
        System.out.println(String.format("Человек %s пробежал кросс длинной %d", getName(), distance));
    }

    @Override
    public void jump(int height) {
        if (!isOnDistance) {
            return;
        }
        if (height > jumpHeight) {
            System.out.println(String.format("Человек %s не смог перепыгнуть препятствие", getName()));
            isOnDistance = false;
            return;
        }
        System.out.println(String.format("Человек с именем %s прыгнул на высоту %d", getName(), height));
    }

    @Override
    public void swim(int distance) {
        if (!isOnDistance) {
            return;
        }
        if (distance > swimDistance) {
            System.out.println(String.format("Человек %s не смог проплыть дистанцию", getName()));
            isOnDistance = false;
            return;
        }
        System.out.println(String.format("Человек с именем %s прыгнул на высоту %d", getName(), swimDistance));
    }

    @Override
    public void voice() {
        System.out.println("JAVA и JS одно и то (rofl)");
    }

    @Override
    public String getInfoAboutParticipant() {
        return String.format("Участник человек %s, возраст %d", getName(),getAge());
    }
}
