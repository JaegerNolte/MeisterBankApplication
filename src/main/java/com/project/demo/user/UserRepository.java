package com.project.demo.user;

import com.project.demo.util.SQLFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.*;


// The UserRepository.java will convert the database results into User objects

@Repository
public class UserRepository {

    @Autowired
    private DataSource dataSource;

    SQLFileReader loadSQL = new SQLFileReader(); // import method


    public boolean authenticateUser(String username, String passwordHash, String email) {
        String sql = loadSQL.loadSQL("users/select--get_users.sql");
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

        String sql = loadSQL.loadSQL("users/insert--create_users.sql"); // loads SQL statement
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

        } catch (SQLException exception) {

            exception.printStackTrace();
            return (long) -1;
        }

    }

}

