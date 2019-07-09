import java.sql.Date;

public class Order {

    private ShoppingCart cart;
    private Credentials user;

    private Date dateCreate;
    private long timeWaiting;
    private OrderStatus status;


    public Order(ShoppingCart Cart, Credentials User) {
        this.cart = Cart;
        this.user = User;
        this.status = OrderStatus.WAITING;

        this.dateCreate = new Date(System.currentTimeMillis());
        //this.timeWaiting = (int)(Math.random() * 1000);
        this.timeWaiting = 1;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public boolean checkInterval(long time) {
        if ((dateCreate.getTime() + timeWaiting) < time) {
            return true;
        } else
            return false;
    }
    public void show() {
        System.out.println("Ваш заказ");
        cart.show();
        user.show();
        System.out.println("Status = "+ status);
        System.out.println("Data Create = " + dateCreate);
        System.out.println("Time Waiting = " + timeWaiting);
    }
}
