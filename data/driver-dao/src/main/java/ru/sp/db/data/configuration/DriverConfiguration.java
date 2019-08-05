package ru.sp.db.data.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@Profile("default")
public class DriverConfiguration {

    private static final String url = "jdbc:postgresql://localhost:5432/test";
    private static final String login = "postgres";
    private static final String pass = "1234";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Одно соедениение с БД.
     * Предназначено для показа , не используется в боевом режиме
     *
     * Для правильной организации кода и соединений с бд, смотреть HikariCP
     * @return - установленное соединение с БД
     * @throws SQLException - ошибка соедениния с БД
     */
    @Bean
    public Connection connection() throws SQLException {
        return DriverManager.getConnection(url, login, pass);
    }
}
