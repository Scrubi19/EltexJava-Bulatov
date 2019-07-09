import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart {

    private ArrayList<Product> cart;

    public ShoppingCart() {
        this.cart = new ArrayList<>();
    }

    void add_cart(Product obj) {
        this.cart.add(obj);
    }

    void delete_cart(Product obj) {
        this.cart.remove(obj);
    }

    void ShowAll() {
        int i = 1;
        Iterator<Product> iter = this.cart.iterator();
        System.out.println("Содержимое корзины");
        while(iter.hasNext()){
            Product val = iter.next();
            System.out.println(i + ")-------------\nID: "+ val.ID + "\nНазвание:  " + val.Name + "\nЦена: " + val.price +"\nПоставщик: " + val.provider);
            i++;
        }
    }

}
