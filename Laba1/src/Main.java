import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /**
         *  программа работает от аргумента, в зависимости от вида представления(чай или кофе)
         */
        Scanner sc = new Scanner(System.in);

        if(args[0].equalsIgnoreCase("чай")) {
            System.out.println("Введите желаемое кол-во товара:" +args[0].toLowerCase());
            int numObj1 = sc.nextInt();
            Tea[] tea = new Tea[numObj1];
            for (int i = 0; i < numObj1; i++) {
                tea[i] = new Tea();
                tea[i].create();
                //tea[i].update();
                tea[i].read();
            }
            System.out.println("\nКол-во обьектов:"+ product.CounterObject);
            /**
             * Пример работы функции update
             */
            System.out.println("Ручной ввод");
            tea[0].delete();
            tea[0].update();
            tea[0].read();
            //tea[0].delete();
        } else if(args[0].equalsIgnoreCase("кофе")) {
            System.out.println("Введите желаемое кол-во товара:" +args[0].toLowerCase());
            int numObj2 = sc.nextInt();
            Coffee[] coffee = new Coffee[numObj2];

            for(int i = 0; i < numObj2; i++) {
                coffee[i] = new Coffee();
                coffee[i].create();
//                coffee[i].update();
                coffee[i].read();
            }
            System.out.println("\nКол-во обьектов:"+ product.CounterObject);
            /**
             * Пример работы функции update
             */
            System.out.println("Ручной ввод");
            coffee[0].delete();
            coffee[0].update();
            coffee[0].read();
            //coffee[0].delete();
        } else {
            System.out.println("Invalid input");
            return;
        }
        sc.close();
    }
}
