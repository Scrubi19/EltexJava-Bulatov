
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Orders orders = new Orders();

        Thread gen1 = new Thread(new Generator(orders));
        Thread gen2 = new Thread(new Generator(orders));

        gen1.start();
        gen2.start();

        Thread checkTime = new Thread(new CheckTime(orders, 3000));
        Thread checkDone = new Thread(new CheckDone(orders, 3000));
        checkTime.start();
        checkDone.start();
    }
}
