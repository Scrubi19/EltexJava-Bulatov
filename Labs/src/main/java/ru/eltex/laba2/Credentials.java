package ru.eltex.laba2;

import java.io.Serializable;
import java.util.Scanner;
import java.util.UUID;

public class Credentials implements Serializable {
    UUID ID;
    private String Surname;
    private String FirstName;
    private String Secondname;
    private String email;

    public Credentials() {
        ID = UUID.randomUUID();
        Scanner sc = new Scanner(System.in);
        System.out.print("Выполни регистрацию для начала покупок:\nФамилия: ");
        this.Surname = sc.nextLine();
        System.out.print("Имя: ");
        this.FirstName = sc.nextLine();
        System.out.print("Отчество: ");
        this.Secondname = sc.nextLine();
        System.out.print("Email: ");
        this.email = sc.nextLine();
    }

    public Credentials(String surname, String firstName, String secondname, String email) {
        ID = UUID.randomUUID();
        Surname = surname;
        FirstName = firstName;
        Secondname = secondname;
        this.email = email;
    }

    public  void show() {
        System.out.println("Покупатель");
        System.out.println("ID = " +ID);
        System.out.println("Surname= " +Surname);
        System.out.println("Firstname = " +FirstName);
        System.out.println("Secondname = " +Secondname);
        System.out.println("Email = " +email);
    }

}