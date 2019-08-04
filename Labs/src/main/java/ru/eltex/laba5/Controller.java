package ru.eltex.laba5;

import ru.eltex.laba1.Coffee;
import ru.eltex.laba1.Product;
import ru.eltex.laba1.Tea;
import ru.eltex.laba2.Credentials;
import ru.eltex.laba2.Order;
import ru.eltex.laba2.Orders;
import ru.eltex.laba2.ShoppingCart;

import java.util.Scanner;

public class Controller {
    public static void OrderFileTest() {
        Scanner sc = new Scanner(System.in);
        Credentials user = new Credentials("Булатов", "Александр", "Сергеевич", "scrubi.memo@yandex.ru");
        System.out.println("\nМеню:\n1.Чай\n2.Кофе\n");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("Сколько чая желаете?");
            int numObj1 = sc.nextInt();
            Tea[] tea = new Tea[numObj1];
            ShoppingCart<Tea> cart = new ShoppingCart<Tea>();
            for (int i = 0; i < numObj1; i++) {
                tea[i] = new Tea();
                tea[i].create();
                tea[i].read();
                cart.add(tea[i]);
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
                ShoppingCart<Tea> cart2 = new ShoppingCart<Tea>();
                Tea[] tea2 = new Tea[numObj1];
                for (int i = 0; i < numObj1; i++) {
                    tea2[i] = new Tea();
                    tea2[i].create();
                    tea2[i].read();
                    cart2.add(tea2[i]);
                }
                Order order2 = new Order(cart, user2);
                manager.saveByID(order2);
                System.out.println("Заказ из бинарного файла");
                Order example2 = manager.readByID(order2.getUUID());
                example2.show();
                System.out.println("Test Json1");
                ManagerOrderJSON json = new ManagerOrderJSON();
                Order order3 = new Order(cart, user2);
//                json.saveByID(order3);
//                Order example3 = json.readByID(order3.getUUID());
//                example3.show();
                System.out.println("Test Json2");
                json.saveAll(orders);
                Orders example = json.readAll();
                example.show();
            } else {
                return;
            }
        }

        if (choice == 2) {
            System.out.println("Сколько кофе желаете?");
            int numObj2 = sc.nextInt();
            Coffee[] coffee = new Coffee[numObj2];
            ShoppingCart<Coffee> cart = new ShoppingCart<Coffee>();
            for (int i = 0; i < numObj2; i++) {
                coffee[i] = new Coffee();
                coffee[i].create();
                coffee[i].read();
                cart.add(coffee[i]);
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
                ShoppingCart<Coffee> cart2 = new ShoppingCart<Coffee>();
                Coffee[] coffee2 = new Coffee[numObj2];
                for (int i = 0; i < numObj2; i++) {
                    coffee2[i] = new Coffee();
                    coffee2[i].create();
                    coffee2[i].read();
                    cart2.add(coffee2[i]);
                }
                Order order2 = new Order(cart, user2);
                manager.saveByID(order2);
                System.out.println("Заказ из бинарного файла");
                Order example2 = manager.readByID(order2.getUUID());
                example2.show();
            } else {
                return;
            }
        }

    }
}
