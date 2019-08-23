package ru.eltex.laba2;

import ru.eltex.laba6.server.UDP;

import java.io.Serializable;
import java.net.InetAddress;
import java.sql.Date;
import java.util.*;

public class Orders <T extends Order> implements Serializable {

    public List<T> orders;
    private Map<Date, T> dateOrder;
    public int port;

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
    }

    public void offer(ShoppingCart cart, Credentials credentials, InetAddress address, int port) {
        Order order = new Order(cart, credentials, address, port);
        orders.add((T) order);
        dateOrder.put(order.getDateCreate(), (T) order);
    }
    public void offer(ShoppingCart cart, Credentials credentials, InetAddress address) {
        Order order = new Order(cart, credentials, address);
        orders.add((T) order);
        dateOrder.put(order.getDateCreate(), (T) order);
    }

    public List<T> getList() {
        return orders;
    }

    public void checkTime() {
        synchronized(orders) {
            Iterator it = orders.iterator();
            while(it.hasNext()) {
                Order order = (Order) it.next();
                if (order.getStatus() == OrderStatus.WAITING &&
                        order.checkInterval(System.currentTimeMillis())) {
                    order.setStatus(OrderStatus.DONE);
                    System.out.println("Checking orders...");
                }
            }
        }
    }
    public void StatusAlert() {
        synchronized(orders) {
            Iterator it = orders.iterator();
            while(it.hasNext()) {
                Order order = (Order) it.next();
                if (order.getStatus() == OrderStatus.WAITING &&
                        order.checkInterval(System.currentTimeMillis())) {
                    order.setStatus(OrderStatus.DONE);
                    UDP udp = new UDP(order.getDateCreate(),"127.0.0.255", 8888);
                    udp.start();
                    System.out.println("Checking orders...");
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
                    System.out.println("Remove orders");
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


