import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Order {
    private LocalTime TimeCreate;
    private LocalTime TimeExpect;
    private boolean status;

    public Order() {
        this.TimeCreate = LocalTime.now();
        this.TimeExpect = getTime_expect();
        this.status = false;
    }

    void Check() {
        long secBetween = ChronoUnit.SECONDS.between(this.TimeCreate, this.TimeExpect);

        if(secBetween == 5 ) {
            this.status = true;
        }
    }

    public LocalTime getTime_create() {
        return TimeCreate;
    }

    public LocalTime getTime_expect() {
        return TimeExpect;
    }

    public boolean isStatus() {
        return status;
    }
}
