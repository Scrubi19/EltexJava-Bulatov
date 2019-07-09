import java.util.LinkedList;

public class Orders {

    private LinkedList<Order> orders;

    public Orders() {
        this.orders = new LinkedList<>();
    }

    void add_orders(Order obj) {
        this.orders.add(obj);
    }

    void delete_orders(Order obj) {
        this.orders.remove(obj);
    }

}


