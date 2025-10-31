package com.project.demo.account;

import com.project.demo.user.UserModel;
import com.project.demo.util.SQLFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

/*
* IMPORTANT DO FIRST THEN WORK ON BUSINESS LOGIC
*/

@Repository
public class AccountRepository {

    @Autowired
    private DataSource datasource;

    SQLFileReader loadSQL = new SQLFileReader();

    private UserModel user;

    public long registerAccount(AccountModel accountModel) {
        String sql = loadSQL.loadSQL("account/insert--create_user.sql");
        try (Connection conn = datasource.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, user.getAppUserId()); // gets the AppUserId hopefully
            stmt.setLong(2, accountModel.getAccountTypeId());
            stmt.setString(3, accountModel.getAccountNickname());

            int affected = stmt.executeUpdate();

            if (affected > 0) {

                try (ResultSet rs = stmt.getGeneratedKeys()) {

                    if (rs.next()) return rs.getLong(1);

                }

            }

            return -1;

        } catch (SQLException exception) {

            exception.printStackTrace();
            return -1;

        }

    }

}
