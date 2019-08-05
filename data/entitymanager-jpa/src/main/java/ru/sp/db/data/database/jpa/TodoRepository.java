package ru.sp.db.data.database.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sp.db.data.database.entities.TodoEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    TodoEntity findOneById(int id);
}
