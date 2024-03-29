package ru.eltex.laba3;

import ru.eltex.laba1.*;
import ru.eltex.laba2.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Credentials user = new Credentials("Булатников", "Алексей", "Ипатович", "scrubismemo@yandex.ru");
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
            ShoppingCart cart = new ShoppingCart();
            for (int i = 0; i < numObj1; i++) {
                cart.add(tea[i]);
            }
            System.out.println("\nКол-во товара:"+ Product.CounterObject);
            System.out.println("\n1.Оформить заказ\n2.Выход");
            int choice2 = sc.nextInt();
            if (choice2 == 1) {
                Orders orders = new Orders();
                orders.offer(cart, user);
                Thread.sleep(10);
                orders.checkTime();
                orders.show();
                System.out.println("Проверка: " + cart.isExistsUUID(tea[0].getUUID()));
            } else {
                return;
            }
        }
        if (choice == 2) {
            System.out.println("Сколько кофе желаете?");
            int numObj2 = sc.nextInt();
            Coffee[] coffee = new Coffee[numObj2];
            for (int i = 0; i < numObj2; i++) {
                coffee[i] = new Coffee();
                coffee[i].create();
                coffee[i].read();
            }
            ShoppingCart cart = new ShoppingCart();
            for (int i = 0; i < numObj2; i++) {
                cart.add(coffee[i]);
            }
            System.out.println("\nКол-во товара:"+ Product.CounterObject);
            System.out.println("\n1.Оформить заказ\n2.Выход");
            int choice2 = sc.nextInt();
            if (choice2 == 1) {
                Orders orders = new Orders();
                orders.offer(cart, user);
                Thread.sleep(10);
                orders.checkTime();
                orders.show();
                System.out.println("Проверка: " + cart.isExistsUUID(coffee[0].getUUID()));
            } else {
                return;
            }
        }
    }
}
