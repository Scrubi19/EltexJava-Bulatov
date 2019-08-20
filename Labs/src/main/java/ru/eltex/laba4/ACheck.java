package ru.eltex.laba4;

import ru.eltex.laba2.Credentials;
import ru.eltex.laba2.Orders;

abstract public class ACheck extends Thread {

    public boolean fRun = true;
    public boolean fWaiting = true;
    public long pause = 1000;
    public Credentials user;
    public Orders orders;

    ACheck(Credentials user, Orders orders) {
        this.user = user;
        this.orders = orders;
    }
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