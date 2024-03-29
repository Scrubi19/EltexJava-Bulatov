package ru.eltex.laba4;

import ru.eltex.laba2.Orders;

public class CheckTime extends ACheck {

    public CheckTime(Orders orders) {
        super(orders);
    }

    public CheckTime(Orders orders, long pause) {
        super(orders);
        this.pause = pause;
    }

    public void off() {
        this.fRun = false;
    }

    @Override
    public void run() {
        while (fRun) {
            synchronized (orders) {
                getOrders().checkTime();
                getOrders().show();
            }
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
