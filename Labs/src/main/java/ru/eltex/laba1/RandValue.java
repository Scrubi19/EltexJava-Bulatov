package ru.eltex.laba1;

import java.util.Random;

public class RandValue {
    private String [] NameTea = { "Высокогорный", "Принцесса Нури", "Lipton", "Nestea", "Richard", "AhmadTea"};
    private String [] NameCoffee = { "Nescafe", "Jardin", "Carte Noire", "Nespresso", "Klimbo", "Lavazza", "Живой кофе"};
    private String [] Provider = {"KDV", "Nestlea", "JFK", "T&ME"};
    private String [] Country = {"Россия", "Китай", "Индия", "Германия","Испания"};
    private String [] TypeBox = {"Картон","Бумага", "Целлофан"};
    private String [] GrainType = {"Арабика", "Робуста"};

    String RandNameTea() {
        Random rand = new Random();
        return NameTea[rand.nextInt(6)];
    }

    String RandNameCoffee() {
        Random rand = new Random();
        return NameCoffee[rand.nextInt(7)];
    }

    String RandProvider() {
        Random rand = new Random();
        return Provider[rand.nextInt(4)];
    }
    String RandCountry() {
        Random rand = new Random();
        return Country[rand.nextInt(5)];
    }

    String RandTypeBox() {
        Random rand = new Random();
        return TypeBox[rand.nextInt(3)];
    }

    String RandGrainType() {
        Random rand = new Random();
        return GrainType[rand.nextInt(2)];
    }

}
