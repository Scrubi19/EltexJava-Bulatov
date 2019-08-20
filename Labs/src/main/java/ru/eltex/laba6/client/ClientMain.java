package ru.eltex.laba6.client;

import ru.eltex.laba2.Credentials;
import ru.eltex.laba2.Orders;
import ru.eltex.laba4.Generator;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

public class ClientMain {
    private Credentials user;
    private Orders orders;

    private final int PORT = 9999; //Порт прослушивания
    private final int PORT2 = 8888; //Порт для оповещений

    private int acceptport; //порт для получения подтверждения
    private int portTCP;//TCP-порт для установки соединения

    private InetAddress address; //адресс отправки по TCP
    private DatagramSocket socket;

    private ClientMain(Credentials user, Orders orders) {
        this.user = user;
        this.orders = orders;
        this.acceptport = 0;
    }

    public void getPortUDP() {
        byte[] buf = new byte[255];
        DatagramPacket pack = new DatagramPacket(buf, buf.length);
        try {
            socket = new DatagramSocket(PORT);
        } catch (SocketException e) {
            try {
                socket = new DatagramSocket(PORT2);
            } catch (SocketException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Local port: " + socket.getLocalPort());
        try {
            socket.receive(pack);
        } catch (IOException e) {
            e.printStackTrace();
        }
        socket.close();
        System.out.println("Get port...");

        String gotten = new String(pack.getData(), 0, pack.getLength());
        portTCP = Integer.parseInt(gotten);
        address = pack.getAddress();

        System.out.println("TCP port: "+gotten);
    }

    public void acceptUDP() {
        byte[] buf = new byte[255];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        try (DatagramSocket socket = new DatagramSocket(acceptport)) {
            System.out.println("Waiting accept on: " + acceptport + "...");
            socket.receive(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Time :" + received);
        System.out.println("Get Accept...");
    }

    public void sendTCP() {
        try (Socket socket = new Socket(address, portTCP)) {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(orders);
            outputStream.flush();

//            acceptport = ;////////////////////////////////
            outputStream.writeInt(acceptport);
            outputStream.flush();

            System.out.println("Send by TCP...");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Orders orders = new Orders();
        Credentials user = new Credentials("Bulatov", "Alexander", "Sergeevich", "scrubi.memo@yandex.ru");

        Generator generator = new Generator(user, orders);
        generator.start();

        ClientMain clientMain = new ClientMain(user, orders);

        while (true) {
            clientMain.getPortUDP();
            clientMain.sendTCP();
            generator.Waiting();
            clientMain.acceptUDP();
            synchronized (generator) {
                generator.notify();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
