package ru.eltex.laba1;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

public class Coffee extends Product {
    private String grainType;

    public Coffee() {
        CounterObject++;
        ID = UUID.randomUUID();
        this.Name = "";
        this.provider = "";
        this.country = "";
        this.price = 0;
        this.counter = 0;
        this.grainType = "";
    }

    public Coffee(String name, String provider, String country, int price, int counter, String graintype) {
        CounterObject++;
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
        System.out.println("ID товара: " + this.ID);
        System.out.println("Вид кофейных зерен: " + grainType + " \n--------------------------");
    }

    @Override
    public void delete() {
        super.delete();
        this.grainType = "";
    }
}