import javax.print.attribute.standard.OrientationRequested;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Выполни регистрацию для начала покупок:\nФамилия: ");
        String Surname = sc.nextLine();
        System.out.print("Имя: ");
        String FirstName = sc.nextLine();
        System.out.print("Отчество: ");
        String Secondname = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        Credentials cred = new Credentials(Surname, FirstName, Secondname, email);

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
            System.out.println("\nКол-во товара:"+ product.CounterObject + "\n1.Оформить заказ\n2.Выход");
            int choice2 = sc.nextInt();
            if(choice2 == 1) {
                ArrayList<Tea> ShoppingCart = new ArrayList<>(numObj1);
                Date date = new Date();
                for (int i = 0; i < numObj1; i++) {
                    Order  order  = new Order(date.toString(), 2, "в ожидании");
                    ShoppingCart.add(tea[i]);
                }
            } else {
                return;
            }
//            Order order = new Order();
//
//            LinkedList<Order> Orders = new LinkedList<Order>();
//            Orders.add(order);


        }


    }
}
