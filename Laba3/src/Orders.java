import java.lang.reflect.Constructor;
import java.sql.Date;
import java.util.*;
import java.util.function.Supplier;

public class Orders <T extends Order> {

    private List<T> orders;
    private Map<Date, T> dateOrder;

    public Orders() {
        this.orders = new LinkedList<>();
        this.dateOrder = new HashMap<>();
    }

    void add(T obj) {
        this.orders.add(obj);
    }

    void delete(T obj) {
        this.orders.remove(obj);
    }

    public void offer(ShoppingCart cart, Credentials user){
        Order order = new Order(cart, user);
        orders.add((T) order);
        dateOrder.put(order.getDateCreate(), (T) order);
    }
    public void checkTime() {
        for (T order: orders) {
            if(order.getStatus() == OrderStatus.WAITING &&
                    order.checkInterval(System.currentTimeMillis())) {
                order.setStatus(OrderStatus.DONE);
                //orders.remove(order);
            }
        }
    }
    public void checkDone() {
        for (T order: orders) {
            if(order.getStatus() == OrderStatus.DONE) {
                order.setStatus(OrderStatus.DONE);
                orders.remove(order);
            }
        }
    }

    public void show() {
       for(T order: orders) {
           System.out.println("----------------------------");
           order.show();
       }
    }

}


