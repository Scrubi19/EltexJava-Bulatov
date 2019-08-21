package ru.eltex.laba6_1.client;

import ru.eltex.laba2.Credentials;
import ru.eltex.laba2.Orders;
import ru.eltex.laba4.Generator;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

public class ClientMain {
    private Credentials user;
    private Orders orders;

    private static final int PORT = 9999;
    private int acceptport;
    private int portTCP;
    private InetAddress address;
    private DatagramSocket socket;

    private ClientMain(Credentials user, Orders orders) {
        this.user = user;
        this.orders = orders;
        this.acceptport = 0;

    }

    public static void main(String[] args) throws IOException {
        Orders orders = new Orders();
        Credentials user = new Credentials("Bulatov", "Alexander", "Sergeevich", "scrubi.memo@yandex.ru");

        Generator generator = new Generator(user, orders);
        generator.start();

        ClientMain client = new ClientMain(user, orders);

        while(true) {
            client.ReceiverAlertUDP();
            client.ConnectTCP();
        }
    }

    public void ReceiverAlertUDP() {
        DatagramPacket pack = new DatagramPacket(new byte[1024], 1024);
        try {
            socket = new DatagramSocket(PORT);
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
        portTCP = Integer.parseInt(s);
        System.out.println("Порт из оповещения UDP: " + portTCP);
        address = pack.getAddress();
        socket.close();
    }

    public void ConnectTCP() throws IOException {
        Socket socket = new Socket(address, portTCP);
        try (ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream())) {
            outStream.writeObject(orders);
            outStream.flush();
            acceptport = socket.getLocalPort();
            outStream.flush();
            System.out.println("Localport: "+socket.getLocalPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
