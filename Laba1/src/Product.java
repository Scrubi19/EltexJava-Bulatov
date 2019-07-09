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
