import java.util.*;

public class ShoppingCart <T extends Product> {

    private List<T> cart;
    private Set<UUID> uuids;

    public ShoppingCart() {
        this.cart = Collections.synchronizedList(new LinkedList<T>());
        this.uuids = new HashSet<>();
    }

    public boolean add(T product) {
        uuids.add(product.getUUID());
        return this.cart.add(product);
    }

    void delete(T product) {
        this.cart.remove(product);
    }

    public void show() {
        for(T val: cart) {
            val.read();
        }
    }
    public void show_short() {
        for(T val: cart) {
            System.out.println(val.Name+"("+val.price+")");
        }
    }

    public boolean isExistsUUID(UUID id) {
        return uuids.contains(id);
    }
}