package ru.eltex.laba6.server;

import java.io.IOException;
import java.net.*;

public final class UDP extends Thread {
    private final String ADDRESS;
    private byte[] buffer;
    private volatile boolean flag;

    public long pause = 1000;

    public UDP(Integer portTransfer, String address) {
        this.flag = true;
        this.buffer = portTransfer.toString().getBytes();
        this.ADDRESS = address;
    }

    public void off() {
        flag = false;
    }

    @Override
    public void run() {
        super.run();
        while (flag) {
            try (DatagramSocket socket = new DatagramSocket()) {
                socket.send(new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ADDRESS), 9999));
                socket.send(new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ADDRESS), 8888));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
