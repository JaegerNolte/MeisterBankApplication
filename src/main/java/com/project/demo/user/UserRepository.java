package com.project.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.*;


// The UserRepository.java will convert the database results into User objects

@Repository
public class UserRepository {

    @Autowired
    private DataSource dataSource;

    private String loadSQL(String fileName) { // Loads raw sql files to be interpreted into string
        try {

            ClassPathResource resource = new ClassPathResource("sql/" + fileName);
            InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8);
            return FileCopyUtils.copyToString(reader);

        } catch (IOException exception) {

            throw new RuntimeException("Could not read sql file: " + fileName, exception);

        }
    }


    public boolean authenticateUser(String username, String passwordHash, String email) {
        String sql = loadSQL("users/select--get_users.sql");
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, passwordHash);
            stmt.setString(3, email);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // true if found
            }
        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }


    }

    public Long registerUser(UserModel user) {

        String sql = loadSQL("users/insert--create_users.sql");
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPasswordHash());
            stmt.setString(3, user.getEmail());

            int affected = stmt.executeUpdate();

            if (affected > 0) {

                try (ResultSet rs = stmt.getGeneratedKeys()) {

                    if (rs.next()) return rs.getLong(1);

                }

            }

            return (long) -1;

        } catch (SQLException e) {

            e.printStackTrace();
            return (long) -1;
        }

    }

}

