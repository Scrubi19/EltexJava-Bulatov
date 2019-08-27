package ru.eltex.laba7.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.eltex.laba1.Product;
import ru.eltex.laba2.Credentials;
import ru.eltex.laba2.Order;
import ru.eltex.laba2.Orders;
import ru.eltex.laba2.ShoppingCart;

@Configuration
public class UserBeans {

    @Bean("Orders")
    public Orders<Order> getOrders() {
        return new Orders<Order>();
    }

    @Bean("User")
    public Credentials getCredentials() {
        return new Credentials("Bulatov", "Alexander", "Sergeevich", "scrubi.memo@yandex.ru");
    }

    @Bean("FirstCart")
    public ShoppingCart<Product> getShoppingCart1() {
        return new ShoppingCart<Product>();
    }

    @Bean("SecondCart")
    public ShoppingCart<Product> getShoppingCart2() {
        return new ShoppingCart<Product>();
    }
}
