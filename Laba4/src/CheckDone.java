public class CheckDone extends ACheck {

    CheckDone(Orders orders) {
        super(orders);
    }

    CheckDone(Orders orders, long pause) {
        super(orders);
        this.pause = pause;
    }

    @Override
    public void run() {
        while(fRun) {
            getOrders().checkDone();
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
