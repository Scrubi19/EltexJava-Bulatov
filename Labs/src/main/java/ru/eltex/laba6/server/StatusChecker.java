package ru.eltex.laba6.server;

import ru.eltex.laba2.Orders;
import ru.eltex.laba4.ACheck;

import java.net.Socket;

public class StatusChecker extends ACheck {

    Socket socket;

    public StatusChecker(Orders orders) {
        super(orders);
    }

    public StatusChecker(Orders orders, Socket socket, long pause) {
        super(orders);
        this.pause = pause;
        this.socket = socket;
    }
    public void off() {
        this.fRun = false;
    }

    @Override
    public void run() {
        while (fRun) {
            synchronized (orders) {
                getOrders().StatusAlert();

            }
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

