import java.util.*;

public class ShoppingCart <T extends Product> {

    private List<T> cart;
    private Set<UUID> uuids;

    public ShoppingCart() {
        this.cart = new ArrayList<>();
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

    public boolean isExistsUUID(UUID id) {
        return uuids.contains(id);
    }
}