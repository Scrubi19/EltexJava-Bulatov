import java.util.Scanner;
import java.util.UUID;

public class Credentials {
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

}