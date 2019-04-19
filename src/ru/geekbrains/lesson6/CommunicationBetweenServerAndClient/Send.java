package ru.geekbrains.lesson6.CommunicationBetweenServerAndClient;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/*
 * Поток для отрпавки данных собеседнику
 * */

public class Send implements Runnable {

    Socket socket;

    public Send(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {


        try (Scanner scanner = new Scanner(System.in)) {

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

//                System.out.print("Введите сообщение > ");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if ("EXIT".equals(line.toUpperCase())) {
                    out.close();
                    break;
                }
                out.writeUTF(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
