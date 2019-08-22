package ru.eltex.laba6_1.server;

import ru.eltex.laba2.Orders;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMain {
    private static final int PORTTCP = 5555;

    public static void main(String[] args) {

        UDP udp = new UDP(PORTTCP, "127.0.0.255", 9999, 8888);
        udp.start();





        try (ServerSocket serverSocket = new ServerSocket(PORTTCP)) {
            while (true) {
                Socket s = serverSocket.accept();
                ServerConnectionProcessor p = new ServerConnectionProcessor(s);
                p.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
