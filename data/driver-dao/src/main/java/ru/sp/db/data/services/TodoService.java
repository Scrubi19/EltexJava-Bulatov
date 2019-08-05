package ru.sp.db.data.services;

import org.springframework.stereotype.Service;
import ru.sp.db.data.database.TodoDAO;
import ru.sp.db.data.database.entities.TodoEntity;

import java.util.List;

/**
 * Бизнес-слой. Данный сервис отвечает за логику ТУДУ заметок
 */
@Service
public class TodoService {

    private final TodoDAO dao;

    public TodoService(TodoDAO todoDAO) {
        this.dao = todoDAO;
    }


    public List<TodoEntity> getAll() {
        return dao.getAll();
    }

    public void save(TodoEntity todoEntity){
        dao.save(todoEntity);
    }

}
