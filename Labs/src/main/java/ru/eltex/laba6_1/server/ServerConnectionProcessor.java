package ru.eltex.laba6_1.server;

import ru.eltex.laba2.Order;
import ru.eltex.laba2.Orders;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Iterator;

class ServerConnectionProcessor extends Thread {
    private Orders orders;
    private Socket socket;

    public ServerConnectionProcessor(Orders orders, Socket s) {
        this.orders = orders;
        this.socket = s;
    }
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
            orders.show();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}