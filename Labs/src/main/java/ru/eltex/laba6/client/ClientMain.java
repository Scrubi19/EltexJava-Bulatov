package ru.eltex.laba6.client;

import ru.eltex.laba2.Credentials;
import ru.eltex.laba2.Orders;
import ru.eltex.laba4.Generator;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

public class ClientMain {
    private Credentials user;
    private Orders orders;

    private int port;
    private static final int CONFIRMPORT = 7777;
    private int acceptport;
    private int portTCP;
    private InetAddress address;
    private DatagramSocket socket;

    private ClientMain(Credentials user, Orders orders, int port) {
        this.port = port;
        this.user = user;
        this.orders = orders;
        this.acceptport = 0;
    }

    public static void main(String[] args) {
        Orders orders = new Orders();
        Credentials user = new Credentials("Bulatov", "Alexander", "Sergeevich", "scrubi.memo@yandex.ru");
        Generator generator = new Generator(user, orders);
        generator.start();

        ClientMain client = new ClientMain(user, orders, 9991);

        while(true) {
            System.out.println("-------------------------------");
            client.ReceiverAlertUDP();
            client.ConnectTCP();
            client.AcceptAlertUDP();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void ReceiverAlertUDP() {
        DatagramPacket pack = new DatagramPacket(new byte[1024], 1024);
        try {
            socket = new DatagramSocket(this.port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        System.out.println("Порт: " + socket.getLocalPort());
        try {
            socket.receive(pack);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] data = pack.getData();
        String s = new String(data, 0, pack.getLength());
        this.portTCP = Integer.parseInt(s);
        System.out.println("Порт из оповещения UDP: " + portTCP);
        address = pack.getAddress();
        socket.close();
    }

    public void ConnectTCP() {
        try (Socket socket = new Socket(address, portTCP)) {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            ObjectOutputStream outStream = new ObjectOutputStream(dos);
            this.acceptport = socket.getLocalPort();
            System.out.println("LocalePort: " + acceptport);
            outStream.writeObject(orders);
            outStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AcceptAlertUDP() {
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
        try (DatagramSocket socket = new DatagramSocket(CONFIRMPORT)) {
            System.out.println("Подтверждение на порту " + acceptport);
            socket.receive(packet);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Дата обработки заказа:" + received +"(DONE)");
        System.out.println("Подтверждение получено");
    }

}
