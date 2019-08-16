package ru.eltex.laba6.client;

import ru.eltex.laba2.Credentials;
import ru.eltex.laba2.Orders;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientMain {
    private final int PORT = 3333;//Порт прослушивания

    private int acceptport;//спободный порт для получения подтверждения
    private int port;//порт на установку TCP соединения
    private InetAddress address; //адресс отправки по TCP
    private Credentials user;
    private Orders orders;
    private DatagramSocket socket;

    private ClientMain(Credentials user, Orders orders) {
        this.user = user;
        this.orders = orders;
        this.acceptport = 0;
    }



}
