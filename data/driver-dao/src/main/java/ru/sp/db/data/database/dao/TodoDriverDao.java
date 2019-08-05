package ru.sp.db.data.database.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.sp.db.data.database.TodoDAO;
import ru.sp.db.data.database.entities.TodoEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
@Profile("default")
public class TodoDriverDao implements TodoDAO {

    private static final String FIELD_ID = "id";
    private static final String FIELD_TEXT = "text";
    private static final String FIELD_DESCRIPTION = "description";

    private static final String QUERY_TODO_GET_ALL = "select * from todos";
    private static final String QUERY_TODO_SAVE = "insert into todos values(?,?,?)";

    /*Одно подключение для теста, если смотреть в правильную сторону,то необходимо использовать connection pool */
    private final Connection connection;

    public TodoDriverDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<TodoEntity> getAll() {
        ArrayList<TodoEntity> allTodo = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_TODO_GET_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) allTodo.add(
                    TodoEntity.of(
                            rs.getInt(FIELD_ID),
                            rs.getString(FIELD_TEXT),
                            rs.getString(FIELD_DESCRIPTION))
            );
            return allTodo;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allTodo;
    }

    @Override
    public void save(TodoEntity entity) {
        try {
            PreparedStatement state = connection.prepareStatement(QUERY_TODO_SAVE);
            state.setInt(1, entity.getId());
            state.setString(2, entity.getText());
            state.setString(3, entity.getDescription());
            state.executeUpdate();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
