package ru.eltex.laba4;

import ru.eltex.laba2.Orders;

abstract public class ACheck implements Runnable{

    public boolean fRun = true;
    public long pause = 3000;
    public Orders orders;

    ACheck(Orders orders) {
        this.orders = orders;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}