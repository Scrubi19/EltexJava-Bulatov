package ru.sp.db.data.database.entities;

public class TodoEntity {

    private int id;
    private String text;
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
