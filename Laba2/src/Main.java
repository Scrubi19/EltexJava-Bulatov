import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        Credentials user = new Credentials();
//
//        ShoppingCart cart = new ShoppingCart();
//        cart.add(new Tea());
//        cart.add(new Coffee());
//        Orders orders = new Orders();
//        orders.offer(cart, user);
//
////        ShoppingCart cart2 = new ShoppingCart();
////        cart2.add(new Tea());
////        cart2.add(new Coffee());
//        Tea tea = new Tea();
//        orders.offer(cart2, user);
//
//        System.out.println(cart.isExistsUUID());

        Scanner sc = new Scanner(System.in);
        Credentials user = new Credentials();
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
                orders.show();
            } else {
                return;
            }
        }
    }
}
