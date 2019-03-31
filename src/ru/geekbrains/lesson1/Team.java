package ru.geekbrains.lesson1;

import ru.geekbrains.lesson1.animal.Animal;

/**
 * Класс - комманда участников соревнований
 */
public class Team {

    private Participant[] participants;

    // здесь используется конструктор с переменным числом параметров
    public Team(Participant... participants) {
        // внутри метода переменное число параметров интерпретируется как массив
        this.participants = participants;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public void getAllTeam() {
        int i = 1;
        System.out.println("----Состав команды-----");
        for (Participant par : participants) {
            System.out.println(String.valueOf(i) + ". " + par.getInfoAboutParticipant());
            i++;
        }
    }

    public int size() {
        return participants.length;
    }

}
