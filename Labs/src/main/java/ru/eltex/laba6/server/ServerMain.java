package ru.eltex.laba6.server;

import ru.eltex.laba2.Orders;
import ru.eltex.laba4.*;
import ru.eltex.laba6.server.*;
import ru.eltex.laba6.server.UDP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ServerMain {
    private static final int PORT = 2222; //Порт для подключения по TCP

    public static void main(String[] args) {
        ExecutorService executeIt = Executors.newFixedThreadPool(2);
        Orders orders = new Orders();
        CheckDone ThreadDone = new CheckDone(orders);
        CheckTime ThreadWait = new CheckTime(orders);
        Thread doneThread = new Thread(ThreadDone);
        Thread waitThread = new Thread(ThreadWait);
        waitThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        doneThread.start();
        UDP udp = new UDP(PORT, "127.0.0.255");//broadcast
        udp.start();
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                executeIt.execute(new ThreadAccept(orders, serverSocket.accept()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        ru.eltex.laba6_1.server.UDP udp = new UDP(PORT, "127.0.0.255", 9999);
//        udp.start();
//
//        try {
//            ServerSocket serverSocket = new ServerSocket(PORT);
//            while (true)         {
//                Socket s = serverSocket.accept();
//                ServerConnectionProcessor p =
//                        new ServerConnectionProcessor(s);
//                p.start();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
