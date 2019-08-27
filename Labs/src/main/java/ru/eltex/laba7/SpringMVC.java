package ru.eltex.laba7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.eltex.laba1.Coffee;
import ru.eltex.laba1.Product;
import ru.eltex.laba1.Tea;
import ru.eltex.laba2.Credentials;
import ru.eltex.laba2.Orders;
import ru.eltex.laba2.ShoppingCart;

@SpringBootApplication
public class SpringMVC {

    public static void main(String[] args) {
        ApplicationContext enter = SpringApplication.run(SpringMVC.class, args);

        ShoppingCart<Product> cart1 = (ShoppingCart<Product>) enter.getBean("FirstCart");
        ShoppingCart<Product> cart2 = (ShoppingCart<Product>) enter.getBean("SecondCart");


        cart1.add(new Tea("Высокогорный", "Nestlea", "Ukraine", 122, 15, "Бумага"));
        cart1.add(new Tea("Nestea", "KDV", "Ukraine", 122, 15, "Фольга"));
        cart1.add(new Tea("Lipton", "HZ", "Italy", 150, 17, "Картон"));

        cart2.add(new Coffee("Nescafe", "KDV", "India", 120, 10, "Arabic"));
        cart2.add(new Tea("Jockey", "Nestlea", "Britain", 130, 13, "Робуста"));

        Orders orders = (Orders) enter.getBean("Orders");
        orders.offer(cart1, (Credentials) enter.getBean("User"));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        orders.offer(cart2, (Credentials) enter.getBean("User"));
    }

}
