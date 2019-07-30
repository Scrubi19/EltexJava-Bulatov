package ru.eltex.laba5;
import ru.eltex.laba1.*;
import ru.eltex.laba2.*;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Credentials user = new Credentials("Булатов", "Александр", "Сергеевич", "scrubi.memo@yandex.ru");
        System.out.println("\nМеню:\n1.Чай\n2.Кофе\n");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("Сколько чая желаете?");
            int numObj1 = sc.nextInt();
            Tea[] tea = new Tea[numObj1];
            for (int i = 0; i < numObj1; i++) {
                tea[i] = new Tea();
                tea[i].create();
                tea[i].read();
            }
            ShoppingCart<Tea> cart = new ShoppingCart<Tea>();
            for (int i = 0; i < numObj1; i++) {
                cart.add(tea[i]);
            }
            System.out.println("\nКол-во товара:"+ Product.CounterObject);
            System.out.println("\n1.Оформить заказ\n2.Выход");
            int choice2 = sc.nextInt();
            if (choice2 == 1) {
                Orders<Order> orders = new Orders<>();
                orders.offer(cart, user);
                ManagerOrderFile manager = new ManagerOrderFile();
                manager.saveAll(orders);
                Orders orders2 = manager.readAll();
                System.out.println("Orders из бинарного файла");
                orders2.show();
            } else {
                return;
            }
        }
//        if (choice == 2) {
//            System.out.println("Сколько кофе желаете?");
//            int numObj2 = sc.nextInt();
//            Coffee[] coffee = new Coffee[numObj2];
//            for (int i = 0; i < numObj2; i++) {
//                coffee[i] = new Coffee();
//                coffee[i].create();
//                coffee[i].read();
//            }
//            ShoppingCart<Coffee> cart = new ShoppingCart<Coffee>();
//            for (int i = 0; i < numObj2; i++) {
//                cart.add(coffee[i]);
//            }
//            System.out.println("\nКол-во товара:"+ Product.CounterObject);
//            System.out.println("\n1.Оформить заказ\n2.Выход");
//            int choice2 = sc.nextInt();
//            if (choice2 == 1) {
//                Orders<Order> orders = new Orders<>();
//                orders.offer(cart, user);
//            } else {
//                return;
//            }
//        }
    }
}
