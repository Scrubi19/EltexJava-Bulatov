package ru.eltex.laba5;

import com.google.gson.internal.bind.util.ISO8601Utils;
import ru.eltex.laba1.Coffee;
import ru.eltex.laba1.Product;
import ru.eltex.laba1.Tea;
import ru.eltex.laba2.Credentials;
import ru.eltex.laba2.Order;
import ru.eltex.laba2.Orders;
import ru.eltex.laba2.ShoppingCart;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Controller {
    public static void OrderFileTest(int choice) {
        Credentials user = new Credentials("Булатов", "Александр", "Сергеевич", "scrubi.memo@yandex.ru");
        Scanner sc = new Scanner(System.in);
        ShoppingCart<Product> cart = new ShoppingCart<>();

        int numObj = 0;
        if (choice == 1) {
            System.out.println("Сколько продуктов требуется?");
            numObj = sc.nextInt();
            Tea[] products = new Tea[numObj];
            for (int i = 0; i < numObj; i++) {
                products[i] = new Tea();
                products[i].create();
                products[i].read();
                cart.add(products[i]);
            }
        }
        if (choice == 2) {
            System.out.println("Сколько продуктов требуется?");
            numObj = sc.nextInt();
            Coffee[] products = new Coffee[numObj];
            for (int i = 0; i < numObj; i++) {
                products[i] = new Coffee();
                products[i].create();
                products[i].read();
                cart.add(products[i]);
            }
        }
        System.out.println("\nКол-во товара:" + Product.CounterObject);
        System.out.println("\n1.Оформить заказ\n2.Выход");
        int choice2 = sc.nextInt();
        if (choice2 == 1) {
            Orders<Order> orders = new Orders<>();
            orders.offer(cart, user);
            ManagerOrderFile manager = new ManagerOrderFile();
            manager.saveAll(orders);
            Orders example1 = manager.readAll();
            System.out.println("Orders из бинарного файла");
            example1.show();

            System.out.println("Пример работы saveByID и readByID" + "\n" + "==================================================");

            Credentials user2 = new Credentials("Булатников", "Алексей", "Ипатович", "scrubismemo@yandex.ru");
            Order order2 = new Order(cart, user2);
            manager.saveByID(order2);
            System.out.println("Заказ из бинарного файла");
            Order example2 = manager.readByID(order2.getUUID());
            example2.show();

            System.out.println("Test Json1");
            ManagerOrderJSON json = new ManagerOrderJSON();
            Order order3 = new Order(cart, user2);
            json.saveByID(order3);
            Order example3 = json.readByID(order3.getUUID());
            System.out.println("Order из JSON-------------------");
            example3.show();

            System.out.println("Test Json2");
            json.saveAll(orders);
            Orders example = json.readAll();
            System.out.println("Orders из JSON------------------");
            example.show();
        } else {
            return;
        }
    }
}

