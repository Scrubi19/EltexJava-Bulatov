import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

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
            System.out.println("\nКол-во товара:"+ Product.CounterObject + "\n1.Оформить заказ\n2.Выход");
            int choice2 = sc.nextInt();
            if(choice2 == 1) {
                Order order = new Order();
//                System.out.println("Время создания: " + order.getTime_create());
            } else {
                return;
            }
            ShoppingCart cart = new ShoppingCart();
            for (int i = 0; i < numObj1; i++) {
                cart.add_cart(tea[i]);
            }
            cart.ShowAll();

        }

        //long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
    }
}
