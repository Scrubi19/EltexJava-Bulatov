package ru.eltex.laba2;

import java.io.Serializable;
import java.sql.Date;
import java.util.*;

public class Orders <T extends Order> implements Serializable {

    public LinkedList<T> orders;
    private HashMap<Date, T> dateOrder;

    public Orders() {
        this.orders = new LinkedList<T>();
        this.dateOrder = new HashMap<>();
    }

    public Orders(LinkedList<T> list, HashMap<Date, T> createTime) {
        this.orders = list;
        this.dateOrder = createTime;
    }

    void add(T obj) {
        this.orders.add(obj);
    }

    void delete(T obj) {
        this.orders.remove(obj);
    }

    public void offer(ShoppingCart cart, Credentials user){
        Order order = new Order(cart, user);
        orders.add((T) order);
        dateOrder.put(order.getDateCreate(), (T) order);
        //cart.show_short();

    }

    public void checkTime() {
        synchronized(orders) {
            Iterator it = orders.iterator();
            while(it.hasNext()) {
                Order order = (Order) it.next();
                if (order.getStatus() == OrderStatus.WAITING &&
                        order.checkInterval(System.currentTimeMillis())) {
                    order.setStatus(OrderStatus.DONE);
                    System.out.println("Проверка заказа...");
                }
            }
        }
    }
    public void checkDone() {
        synchronized (orders) {
            Iterator it = orders.iterator();
            while (it.hasNext()) {
                Order order = (Order) it.next();
                if (order.getStatus() == OrderStatus.DONE) {
                    it.remove();
                    System.out.println("Удаление заказа");
                }
            }
        }
    }

    public void show() {
       for(T order: orders) {
           System.out.println("----------------------------");
           order.show();
       }
    }
}


