package ru.geekbrains.lesson6.CommunicationBetweenServerAndClient;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;


/*
* Потока для чтения данных полученных от собесденика
* */

public class Recive implements Runnable {

    String user;
    Socket socket;

    public Recive(Socket socket, String user) {
        this.socket = socket;
        this.user = user;

    }

    @Override
    public void run() {
        String line;
        try (DataInputStream in = new DataInputStream(socket.getInputStream());) {

            while (true) {
                line = in.readUTF();

             /*   if("EXIT".equals(line.toUpperCase())) {
                    System.out.println(String.format("%s покинул чат. Приложение автоматически закрылось!!!", user));
                    break;
                }*/

                System.out.println("Новое от " + user + " > " + line);
            }
        } catch (EOFException ex) {
            System.out.println(String.format("%s покинул чат.", user));
            return;
        } catch (SocketException ex) {
            System.out.println("Вы вышли из чата.");
            return;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
