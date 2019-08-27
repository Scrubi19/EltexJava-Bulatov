package ru.eltex.laba7.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eltex.laba1.Product;
import ru.eltex.laba1.Tea;
import ru.eltex.laba2.Order;
import ru.eltex.laba2.Orders;
import ru.eltex.laba2.ShoppingCart;
import ru.eltex.laba5.OrderDeserializer;
import ru.eltex.laba5.OrdersDeserializer;
import ru.eltex.laba5.ProductDeserializer;

public interface OrderService {
    public String readAll();
    public String readById(String order_id);
    public String addToCard(String card_id);
    public String delById(String order_id);
}

@Service
class OrderServiceImpl implements OrderService {

    private static final Logger logger = Logger.getLogger(OrderServiceImpl.class);
    public Orders orders;
    private final Gson json = new GsonBuilder().registerTypeAdapter(Order.class, new OrderDeserializer())
            .registerTypeAdapter(Orders.class, new OrdersDeserializer())
            .registerTypeAdapter(Product.class, new ProductDeserializer()).setPrettyPrinting().create();

    @Autowired
    public void setOrders(Orders orders) {
        this.orders = orders;
    }
    @Override
    public String readAll() {
        logger.info("readAll");
        return json.toJson(orders);
    }

    @Override
    public String readById(String order_id) {
        logger.info("readById");
        return json.toJson(orders.searchById(order_id));
    }

    @Override
    public String addToCard(String card_id) {
        logger.info("addToCard");
        Product tea = new Tea("AhmadTea", "KDV", "Russia", 89, 5, "Картон");
        ShoppingCart cart = orders.getCart(card_id);
        if(cart.add(tea)) {
            System.out.println("Succesfully added");
            return tea.getUUID().toString();
        }
        return null;
    }

    @Override
    public String delById(String order_id) {
        logger.info("delById");
        Order order = orders.searchById(order_id);
        if (order == null) {
            throw new NullPointerException();
        }
        orders.remove(order_id);
        return "Succesfully remove";
    }
}
