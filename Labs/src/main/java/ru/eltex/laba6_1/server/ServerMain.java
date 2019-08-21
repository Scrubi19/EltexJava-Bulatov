package ru.eltex.laba6_1.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    private static final int PORTTCP = 3333;

    public static void main(String[] args) {

        UDP udp = new UDP(PORTTCP, "127.0.0.255", 9999);
        udp.start();

        try (ServerSocket serverSocket = new ServerSocket(PORTTCP)) {
            while (true) {
                Socket s = serverSocket.accept();
                ServerConnectionProcessor p =
                        new ServerConnectionProcessor(s);
                p.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
