package ru.eltex.laba6.server;

import java.io.IOException;
import java.net.*;
import java.sql.Date;

public class UDP extends Thread {
    private byte[] buffer;
    private String address;
    private int localePort;
    private volatile boolean fRun;

    public UDP(Integer portTransfer, String address, int port1) {
        this.buffer = portTransfer.toString().getBytes();
        this.address = address;
        this.localePort = port1;
        this.fRun = true;
    }
    public UDP(Date date, String address, int port1) {
        this.buffer = date.toString().getBytes();
        this.address = address;
        this.localePort = port1;
        this.fRun = true;
    }
    public UDP(Date date, String address) {
        this.buffer = date.toString().getBytes();
        this.address = address;
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
            } catch (SocketException ex) {
                ex.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
