import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart {

    private ArrayList<product> cart;

    public ShoppingCart() {
        this.cart = new ArrayList<>();
    }

    void add_cart(product obj) {
        this.cart.add(obj);
    }

    void delete_cart(product obj) {
        this.cart.remove(obj);
    }

    void ShowAll() {
        int i = 1;
        Iterator<product> iter = this.cart.iterator();
        System.out.println("Содержимое корзины");
        while(iter.hasNext()){
            product val = iter.next();
            System.out.println(i + ")-------------\nID: "+ val.ID + "\nНазвание:  " + val.Name + "\nЦена: " + val.price +"\nПоставщик: " + val.provider);
            i++;
        }
    }

}
