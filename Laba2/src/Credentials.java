import java.util.UUID;

public class Credentials {
    UUID ID;
    private String Surname;
    private String FirstName;
    private String Secondname;
    private String email;

    public Credentials(String surname, String firstName, String secondname, String email) {
        ID = UUID.randomUUID();
        this.Surname = surname;
        this.FirstName = firstName;
        this.Secondname = secondname;
        this.email = email;
    }

    public UUID getID() {
        return ID;
    }

    public String getSurname() {
        return Surname;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getSecondname() {
        return Secondname;
    }

    public String getEmail() {
        return email;
    }

    public void setID(UUID ID) {
        ID = ID;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setSecondname(String secondname) {
        Secondname = secondname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
