import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public abstract class Product implements IcrudAction {

    UUID ID;
    protected String Name;
    protected int price;
    protected int counter;
    protected String provider;
    protected String country;

    public static int CounterObject;

    @Override
    public void create() {
        Random rand = new Random();
        RandValue val = new RandValue();
        this.price = rand.nextInt(1000);
        this.counter = rand.nextInt(100);
        this.provider = val.RandProvider();
        this.country = val.RandCountry();

    }

    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Введите цену товара:");
            this.price = sc.nextInt();
            System.out.println("Введите кол-во товара:");
            this.counter = sc.nextInt();
        } catch (NoSuchElementException e) {
            System.out.println("Error\n");
        }
        try {
            sc.nextLine();
            System.out.println("Введите Имя товара:");
            this.Name = sc.nextLine();
            System.out.println("Введите поставщика товара:");
            this.provider = sc.nextLine();
            System.out.println("Введите страну производителя товара:");
            this.country = sc.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println("Error");
        }
    }

    @Override
    public void read() {
        System.out.println("Название: "+this.Name);
        System.out.println("Цена: "+this.price);
        System.out.println("Cчётчик товаров: "+this.counter);
        System.out.println("Фирма поставщик: "+this.provider);
        System.out.println("Страна производитель: "+this.country);
    }

    @Override
    public void delete() {
        CounterObject--;
        this.Name = "";
        this.provider = "";
        this.country = "";
        this.price = 0;
        this.counter = 0;
    }
}

class Tea extends Product {

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

class Coffee extends Product {
    private String grainType;

    Coffee() {
        CounterObject++;
        ID =  UUID.randomUUID();
        this.Name = "";
        this.provider = "";
        this.country = "";
        this.price = 0;
        this.counter = 0;
        this.grainType = "";
    }

    Coffee(UUID Id, String name, String provider, String country, int price, int counter, String graintype) {
        CounterObject++;
        this.ID = Id;
        this.Name = name;
        this.provider = provider;
        this.country = country;
        this.price = price;
        this.counter = counter;
        this.grainType = graintype;
    }

    @Override
    public void create() {
        super.create();
        RandValue val = new RandValue();
        this.Name = val.RandNameCoffee();
        this.grainType = val.RandGrainType();

    }

    @Override
    public void update() {
        super.update();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Введите вид зерен кофе:");
            this.grainType = sc.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println("Error");
        }
    }

    @Override
    public void read() {
        super.read();
        System.out.println("ID товара: "+this.ID);
        System.out.println("Вид кофейных зерен: "+grainType+" \n--------------------------");
    }

    @Override
    public void delete() {
        super.delete();
        this.grainType = "";
    }
}