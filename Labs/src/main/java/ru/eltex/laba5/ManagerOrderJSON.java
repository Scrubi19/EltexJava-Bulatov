package ru.eltex.laba5;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ru.eltex.laba1.Product;
import ru.eltex.laba2.Order;
import ru.eltex.laba2.Orders;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.UUID;

public class ManagerOrderJSON extends AManageOrder{
    public static final String JSON_PATH = "/home/scrubi19/Dropbox/EltexJava-Bulatov/Labs/target/result.json";
    private final Gson json;

    public ManagerOrderJSON() {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Product.class, new ProductDeserializer())
                .registerTypeAdapter(Order.class,  new OrderDeserializer())
                .registerTypeAdapter(Orders.class, new OrdersDeserializer());

        json = gsonBuilder.setPrettyPrinting().create();

        target = new File(JSON_PATH);
    }

    @Override
    public Order readByID(UUID id) {
        Order order = null;
        try (FileReader reader = new FileReader(JSON_PATH)) {
            if (!target.exists()) {
                return null;
            }
            Type type = new TypeToken<Order>() {
            }.getType();
            order = json.fromJson(reader, type);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return order;
    }

    @Override
    public void saveByID(Order order) {
        try (FileWriter writer = new FileWriter(JSON_PATH))
        {
            if (target.exists()) {
                json.toJson(order, writer);
            } else {
                System.out.println("File is not exist. Trying to create new file");
                target.createNewFile();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Orders readAll() {
        Orders orders = null;
        try (FileReader reader = new FileReader(JSON_PATH)) {
            if (!target.exists()) {
                return null;
            }
            Type type = new TypeToken<Orders<Order>>() {
            }.getType();
            orders = json.fromJson(reader, type);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return orders;
    }

    @Override
    public void saveAll(Orders orders) {
        try (FileWriter writer = new FileWriter(JSON_PATH)) {
            if (target.exists()) {
                json.toJson(orders, writer);
            } else {
                System.out.println("File is not exist. Trying to create new file");
                target.createNewFile();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
