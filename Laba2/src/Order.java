public class Order {
    private String time_create;
    private int time_expect;
    private String status;

    public Order(String time_create, int time_expect, String status) {
        this.time_create = time_create;
        this.time_expect = time_expect;
        this.status = status;
    }

    public String getTime_create() {
        return time_create;
    }

    public int getTime_expect() {
        return time_expect;
    }

    public String getStatus() {
        return status;
    }

    public void setTime_create(String  time_create) {
        this.time_create = time_create;
    }

    public void setTime_expect(int time_expect) {
        this.time_expect = time_expect;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
