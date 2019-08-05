package ru.sp.db.data.database.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.sp.db.data.database.TodoDAO;
import ru.sp.db.data.database.entities.TodoEntity;

import java.util.List;

@Component
public class TodoJDBCTemplateDao implements TodoDAO {

    private static final String QUERY_GEL_ALL = "select * from todos";
    private static final String QUERY_TODO_SAVE = "insert into todos values(?,?,?)";

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<TodoEntity> rowMapper;

    public TodoJDBCTemplateDao(JdbcTemplate jdbcTemplate, RowMapper<TodoEntity> rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public List<TodoEntity> getAll() {
        return  jdbcTemplate.query(QUERY_GEL_ALL, rowMapper);
    }

    @Override
    public void save(TodoEntity todoEntity) {
        jdbcTemplate.update(QUERY_TODO_SAVE,
                todoEntity.getId(),
                todoEntity.getText(),
                todoEntity.getDescription());
    }
}
