package ru.sp.db.data.api;

import org.springframework.web.bind.annotation.*;
import ru.sp.db.data.database.entities.TodoEntity;
import ru.sp.db.data.services.TodoService;

import java.util.List;

@RequestMapping("api/v1/todo")
@RestController
public class TodoApiController {

    private final TodoService todoService;

    public TodoApiController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<TodoEntity> getTodos() {
        return todoService.getAll();
    }

    @PostMapping
    public void save(@RequestBody TodoEntity todoEntity){
        todoService.save(todoEntity);
    }

}
