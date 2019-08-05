package ru.sp.db.data.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.sp.db.data.database.entities.TodoEntity;

import javax.sql.DataSource;

@Configuration
public class JDBCTemplate {
    private static final String url = "jdbc:postgresql://localhost:5432/test";
    private static final String login = "postgres";
    private static final String pass = "1234";
    private static final String driverName = "org.postgresql.Driver";

    private static final String FIELD_ID = "id";
    private static final String FIELD_TEXT = "text";
    private static final String FIELD_DESCRIPTION = "description";

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driver = new DriverManagerDataSource();
        driver.setUrl(url);
        driver.setUsername(login);
        driver.setPassword(pass);
        driver.setDriverClassName(driverName);
        return driver;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public RowMapper<TodoEntity> rowMapper() {
        return ((rs, i) -> TodoEntity.of(rs.getInt(FIELD_ID), rs.getString(FIELD_TEXT), rs.getString(FIELD_DESCRIPTION)));
    }

}
