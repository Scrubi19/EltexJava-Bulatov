package ru.sp.db.data.database;

import ru.sp.db.data.database.entities.TodoEntity;

import java.util.List;


public interface TodoDAO {

    /**
     * @return Полученее всех todo's
     */
    List<TodoEntity> getAll();

    /**
     * Сохранение entity todo в БД
     */
    void save(TodoEntity todoEntity);

}
