import java.util.*;

public class ShoppingCart {

    private List<Product> cart;
    private Set<UUID> uuids;

    public ShoppingCart() {
        this.cart = new ArrayList<>();
        this.uuids = new HashSet<>();
    }

    public boolean add(Product product) {
        uuids.add(product.getUUID());
        return this.cart.add(product);
    }

    void delete(Product product) {
        this.cart.remove(product);
    }

    public void show() {
        for(Product val: cart) {
            val.read();
        }
    }

    public boolean isExistsUUID(UUID id) {
        return uuids.contains(id);
    }

}