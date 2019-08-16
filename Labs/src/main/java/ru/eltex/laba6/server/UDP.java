package ru.eltex.laba6.server;

import java.io.IOException;
import java.net.*;

public final class UDP extends Thread {
    private String ADDRESS;
    private byte[] buffer;
    private boolean flag;

    public UDP(Integer portTransfer, boolean flag) {
        this.buffer = portTransfer.toString().getBytes();
        this.flag = true;
        this.flag = flag;
    }

    public void Off() {
        flag = false;
    }

    @Override
    public void run() {
        super.run();
        while (flag) {
            try (DatagramSocket socket = new DatagramSocket()) {
                socket.send(new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ADDRESS), 3333));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
