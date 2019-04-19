package ru.geekbrains.lesson6;

import ru.geekbrains.lesson6.CommunicationBetweenServerAndClient.Recive;
import ru.geekbrains.lesson6.CommunicationBetweenServerAndClient.Send;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {

        try (Socket socket = new Socket("localhost", 8888)) {

            System.out.println("Вы подключились к серверу можете писать и получать сообщения!!!");

            List<Thread> list = new LinkedList<>();
            list.add(new Thread(new Send(socket)));
            list.add(new Thread(new Recive(socket, "Сервер")));
            list.get(0).setDaemon(true);

            for(Thread thread : list) {
                thread.start();
            }

            list.get(1).join();

            System.out.println("Конец главного потока");
        }
    }

}
