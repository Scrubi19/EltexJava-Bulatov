package ru.eltex.laba6.server;

import ru.eltex.laba2.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ThreadAccept implements Runnable {
    private Socket socket; //сокет соединения
    private Orders orders; //заказы

    public ThreadAccept(Orders orders, Socket socket) {
        this.orders = orders;
        this.socket = socket;
    }

    @Override
    public void run() {
        try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {
            Orders new_orders = (Orders) inputStream.readObject();
            int port = inputStream.readInt();
            for (var item : new_orders.getList()) {
                synchronized (orders) {
                    Order ex = (Order) item;
                    orders.offer(ex.getCart(), ex.getUser(), socket.getLocalAddress(), port);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
