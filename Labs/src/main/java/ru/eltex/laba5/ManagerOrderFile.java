package ru.eltex.laba5;

import ru.eltex.laba2.Order;
import ru.eltex.laba2.Orders;

import java.io.*;
import java.util.Iterator;
import java.util.UUID;

public class ManagerOrderFile extends AManageOrder {
    public static final String BIN_PATH = "/home/scrubi19/Dropbox/EltexJava-Bulatov/Labs/target/binary.bin";

    ManagerOrderFile() {
        target = new File(BIN_PATH);
    }

    @Override
    public Order readByID(UUID id) {
        Order order = null;
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(BIN_PATH))) {
            if (!target.exists()) {
                return null;
            } else {
                order = (Order) oos.readObject();
                if (!order.getUUID().equals(id)) {
                    order = null;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return order;
    }

    @Override
    public void saveByID(Orders orders, UUID id) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BIN_PATH))) {
            Iterator it = orders.orders.iterator();
            while (it.hasNext()) {
                Order order = (Order) it.next();
                if (order.getUUID().equals(id)) {
                    if (!target.exists()) {
                        target.createNewFile();
                    } else {
                        oos.writeObject(order);
                        oos.flush();
                    }
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Orders readAll() {
        Orders orders = null;
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(BIN_PATH))) {
            if (!target.exists()) {
                return null;
            }
            orders = (Orders) oos.readObject();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return orders;
    }

    @Override
    public void saveAll(Orders orders) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BIN_PATH))) {
            if (!target.exists()) {
                target.createNewFile();
            } else {
                oos.writeObject(orders);
                oos.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
