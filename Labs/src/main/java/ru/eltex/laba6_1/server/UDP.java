package ru.eltex.laba6_1.server;

import java.io.IOException;
import java.net.*;

public class UDP extends Thread {
    private byte[] buffer;
    private String address;
    private int localePort;
    private int reserveport;
    private volatile boolean fRun;

    public UDP(Integer portTransfer, String address, int port1, int port2) {
        this.buffer = portTransfer.toString().getBytes();
        this.address = address;
        this.localePort = port1;
        this.reserveport = port2;
        this.fRun = true;
    }

    public void Off() {
        fRun = false;
    }

    @Override
    public void run() {
        super.run();
        while(fRun) {
            try (DatagramSocket datagram = new DatagramSocket()) {
                DatagramPacket packet1 = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(address), localePort);
                datagram.send(packet1);
                DatagramPacket packet2 = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(address), reserveport);
                datagram.send(packet2);
            } catch (SocketException ex) {
                ex.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
