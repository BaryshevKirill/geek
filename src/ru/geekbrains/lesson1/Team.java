package ru.geekbrains.lesson1;

import ru.geekbrains.lesson1.animal.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс - комманда участников соревнований
 */
public class Team {

    private Participant[] participants;

    private List<Participant> finishedParticipant = new ArrayList<>();

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

    public void addFinishedParticipant(Participant par) {
        finishedParticipant.add(par);
    }

    public void showResults(){
        int i = 1;
        System.out.println("----Участники команды, успешно прошедшие полосу перпятствий----");

        if(finishedParticipant.size() == 0) {
            System.out.println("Никто из команды не смог преодолеть полосу препятствий");
            return;
        }

        for(Participant par : finishedParticipant) {
            System.out.println(i + ". " + par.getInfoAboutParticipant());
            i++;
        }
    }

}
