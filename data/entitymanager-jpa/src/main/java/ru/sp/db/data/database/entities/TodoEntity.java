package ru.sp.db.data.database.entities;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class TodoEntity {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "description")
    private String description;


    public TodoEntity() {
    }

    public static TodoEntity of(int id, String text, String description) {
        return new TodoEntity(id, text, description);
    }

    private TodoEntity(int id, String text, String description) {
        this.id = id;
        this.text = text;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
