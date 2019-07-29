package ru.eltex.laba4;
import ru.eltex.laba1.*;
import ru.eltex.laba2.*;

public class Generator extends ACheck {

    public Generator(Orders orders) {
        super(orders);
    }

    @Override
    public void run() {
        while (fRun) {
            int i = (int)(Math.random()*2);
            Product[] product;

            Orders orders = getOrders();
            ShoppingCart cart = new ShoppingCart<>();
            switch (i) {
                case 0 :
                    int p = (int)(Math.random()*3);
                    product = new Tea[p];
                    for (int j = 0; j < p; j++) {
                       product[j] = new Tea();
                       product[j].create();
                       cart.add(product[j]);
                    }
                    break;
                case 1 :
                    int d = (int)(Math.random()*3);
                    product = new Coffee[d];
                    for (int k = 0; k < d; k++) {
                        product[k] = new Coffee();
                        product[k].create();
                        cart.add(product[k]);
                    }
            }
            Credentials user = new Credentials("Bulatov", "Alexander", "Sergeevich", "scrubi.memo@yandex.ru");

            synchronized (orders) {
                orders.offer(cart, user);
            }
        }
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
