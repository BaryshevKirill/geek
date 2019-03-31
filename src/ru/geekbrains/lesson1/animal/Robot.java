package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;

/**
 * Робот не является животным, но может учавствовать в соревнованиях
 * так как реализует интерфейс {@link Participant}
 */
public class Robot implements Participant {

    private boolean isOnDistance;

    private int runDistance;
    private int jumpHeight;
    private String model;

    public Robot(String model, int runDistance, int jumpHeight) {
        this.model = model;
        this.isOnDistance = true;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    public Robot(String model) {
        this.model = model;
    }

    @Override
    public boolean isOnDistance() {
        return isOnDistance;
    }

    @Override
    public void run(int distance) {
        if (!isOnDistance) {
            return;
        }
        if (distance > runDistance) {
            isOnDistance = false;
            return;
        }
        System.out.println(String.format("Робот можели  %s пробежал кросс длинной %d", this.model, distance));
    }

    @Override
    public void jump(int height) {
        if (!isOnDistance) {
            return;
        }
        if (height > jumpHeight) {
            isOnDistance = false;
            return;
        }
        System.out.println(String.format("Робот можели %s пругнул на высоту %d", this.model, height));
    }

    @Override
    public void swim(int distance) {
        isOnDistance = false;
        System.out.println("Робот не может плавать");
    }
}
