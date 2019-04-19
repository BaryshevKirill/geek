package ru.geekbrains.lesson6;

import ru.geekbrains.lesson6.CommunicationBetweenServerAndClient.Recive;
import ru.geekbrains.lesson6.CommunicationBetweenServerAndClient.Send;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {

        try (ServerSocket serverSocket = new ServerSocket(8888)) {

            System.out.println("Сервер ожидает подключения!");
            Socket socket = serverSocket.accept();
            System.out.println("Кто-то подключился: " + socket.getInetAddress());

            List<Thread> list = new LinkedList<>();
            list.add(new Thread(new Send(socket)));
            list.add(new Thread(new Recive(socket, "Клиент")));
//            Назначаю поток вывода сообщений от собеседника как демон, чтобы он закрывался при окончании главного потока
            list.get(0).setDaemon(true);

            for(Thread thread : list) {
                thread.start();
            }

            list.get(1).join();

            System.out.println("Конец главного потока");

        }
    }
}