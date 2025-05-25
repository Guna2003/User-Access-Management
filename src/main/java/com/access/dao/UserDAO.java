package com.access.dao;

import com.access.model.User;
import java.sql.*;

public class UserDAO {
    private final String jdbcURL = "jdbc:postgresql://localhost:5432/your_db";
    private final String jdbcUsername = "your_username";
    private final String jdbcPassword = "your_password";

    private static final String INSERT_USER_SQL = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";

    public void registerUser(User user) throws SQLException {
        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement ps = conn.prepareStatement(INSERT_USER_SQL)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
