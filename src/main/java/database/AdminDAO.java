package database;

import database.entity.Admin;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

    public static Admin get(String username) throws SQLException, IOException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from admin where username=?");
        preparedStatement.setString(1,username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) return null;
        Admin admin= new Admin();
        admin.setPassword(resultSet.getString("password"));
        admin.setUsername(resultSet.getString("username"));
        return admin;
    }

}
