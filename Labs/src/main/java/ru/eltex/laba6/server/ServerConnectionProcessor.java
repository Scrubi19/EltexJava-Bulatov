package ru.eltex.laba6.server;

import ru.eltex.laba2.Orders;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

class ServerConnectionProcessor extends Thread {
    private Orders orders;
    private Socket socket;

    public ServerConnectionProcessor(Socket s) {
        this.socket = s;
    }

    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            // Получает запрос
            ObjectInputStream inStream = new ObjectInputStream(dis);
            Orders new_orders = (Orders) inStream.readObject();

            orders = new_orders;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Thread StatusChecker = new Thread(new StatusChecker(orders, socket, 1000));
        StatusChecker.start();


    }
}