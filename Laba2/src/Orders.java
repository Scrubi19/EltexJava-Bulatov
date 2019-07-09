import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Orders {

    private List<Order> orders;
    private Map<Date, Order> dateOrder;

    public Orders() {
        this.orders = new LinkedList<>();
        this.dateOrder = new HashMap<>();
    }

    void add_orders(Order obj) {
        this.orders.add(obj);
    }

    void delete_orders(Order obj) {
        this.orders.remove(obj);
    }

    public void offer(ShoppingCart cart, Credentials user) {
        Order order = new Order(cart, user);
        orders.add(order);
        dateOrder.put(order.getDateCreate(), order);
    }
    public void checkTime() {
        for (Order order: orders) {
            if(order.getStatus() == OrderStatus.WAITING &&
                    order.checkInterval(System.currentTimeMillis())) {
                order.setStatus(OrderStatus.DONE);
                //orders.remove(order);
            }
        }
    }
    public void checkDone() {
        for (Order order: orders) {
            if(order.getStatus() == OrderStatus.DONE) {
                order.setStatus(OrderStatus.DONE);
                orders.remove(order);
            }
        }
    }

    public void show() {
       for(Order order: orders) {
           System.out.println("----------------------------");
           order.show();
       }
    }

}


