package ru.eltex.laba4;

import ru.eltex.laba2.Orders;

public class CheckDone extends ACheck {

    public CheckDone(Orders orders) {
        super(orders);
    }

    public CheckDone(Orders orders, long pause) {
        super(orders);
    }

    public void off() {
        this.fRun = false;
    }

    @Override
    public void run() {
        while (fRun) {
            synchronized (orders) {
                getOrders().checkDone();
            }
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
