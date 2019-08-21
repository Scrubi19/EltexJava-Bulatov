package ru.eltex.laba6.server;

import ru.eltex.laba2.Order;
import ru.eltex.laba2.Orders;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

class ServerConnectionProcessor extends Thread {
    private Socket socket;
    private Orders orders;

    public ServerConnectionProcessor(Socket s, Orders orders) {
        this.socket = s;
        this.orders = orders;
    }
    public ServerConnectionProcessor(Socket s) {
        this.socket = s;
    }

    public void run() {
        try {
            // Получает запрос
            ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
            Orders new_orders = (Orders) inStream.readObject();

            // Отправляет ответ
            int port = inStream.readInt();
            for (var item : new_orders.getList()) {
                synchronized (orders) {
                    Order ex = (Order) item;
                    orders.offer(ex.getCart(), ex.getUser(), socket.getLocalAddress(), port);
                    orders.show();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}