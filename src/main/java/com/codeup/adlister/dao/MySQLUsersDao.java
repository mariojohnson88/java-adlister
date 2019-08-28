package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.api.mysqla.result.Resultset;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


//    Getting information from an existing user

    private User extractUser(ResultSet results) throws SQLException {
        return new User(
                results.getLong("id"),
                results.getString("username"),
                results.getString("email"),
                results.getString("password")
        );
    }

    private List<User> createAdsFromResults(ResultSet results) throws SQLException {
        List<User> users = new ArrayList<>();
        while (results.next()) {
            users.add(extractUser(results));
        }
        return users;
    }

    @Override
    public User findByUsername(String username) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            stmt.setString(1, username);
            ResultSet results = stmt.executeQuery();
            results.next();
            return extractUser(results);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long insert(User user) {
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO users(username, email, password) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet results = stmt.getGeneratedKeys();
            results.next();
            return results.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
