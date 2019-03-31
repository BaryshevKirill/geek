package ru.geekbrains.lesson1.course;

import ru.geekbrains.lesson1.Participant;
import ru.geekbrains.lesson1.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс - полоса препятствий
 */
public class Course {

    private Obstacle[] obstacles;
    private List<Participant> finishedParticipant = new ArrayList<>();

    public Course(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        for (Participant participant : team.getParticipants()) {
            for (Obstacle obstacle : obstacles) {
                obstacle.doIt(participant);

                // если участник сошел с дистанции, то нет смысла двигать его дальше
                if (!participant.isOnDistance()) {
                    break;
                }
            }
            if(participant.isOnDistance()) {
                finishedParticipant.add(participant);
            }
        }
    }

    public int size(){
        return obstacles.length;
    }

    public void showFinishedParticipant() {
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
