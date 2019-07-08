import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

class Tea extends product {

    private String typeBox;

    Tea() {
        CounterObject++;
        ID =  UUID.randomUUID();
        this.Name = "";
        this.provider = "";
        this.country = "";
        this.price = 0;
        this.counter = 0;
        this.typeBox = "";
    }

    Tea(UUID Id, String name, String provider, String country, int price, int counter, String typeBox) {
        CounterObject++;
        this.ID = Id;
        this.Name = name;
        this.provider = provider;
        this.country = country;
        this.price = price;
        this.counter = counter;
        this.typeBox = typeBox;
    }

    @Override
    public void create() {
        super.create();
        RandValue val = new RandValue();
        this.Name = val.RandNameTea();
        this.typeBox = val.RandTypeBox();
    }

    @Override
    public void update() {
        super.update();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Введите вид упаковки товара:");
            this.typeBox = sc.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println("Error");
        }
    }

    @Override
    public void read() {
        super.read();
        System.out.println("ID товара: "+this.ID);
        System.out.println("Вид упаковки товара: "+this.typeBox +"\n--------------------------");
    }

    @Override
    public void delete() {
        super.delete();
        this.typeBox = "";
    }
}