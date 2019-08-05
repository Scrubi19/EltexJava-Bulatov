package ru.sp.db.data.services;

import org.springframework.stereotype.Service;
import ru.sp.db.data.database.TodoDAO;
import ru.sp.db.data.database.entities.TodoEntity;
import ru.sp.db.data.database.jpa.TodoRepository;

import java.util.List;

/**
 * Бизнес-слой. Данный сервис отвечает за логику ТУДУ заметок
 */
@Service
public class TodoService {

    private final TodoDAO dao;
    private final TodoRepository todoRepository;

    public TodoService(TodoDAO todoDAO, TodoRepository todoRepository) {
        this.dao = todoDAO;
        this.todoRepository = todoRepository;
    }


    public List<TodoEntity> getAll() {
        return dao.getAll();
    }

    public void save(TodoEntity todoEntity){
        dao.save(todoEntity);
    }

    public TodoEntity findById(int id) {
        return todoRepository.findOneById(id);
    }
}
