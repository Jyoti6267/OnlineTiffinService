package database;

import database.entity.User;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    public static User builder(HttpServletRequest request){

        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setAddress(request.getParameter("address"));
        user.setUsername(request.getParameter("username"));
        user.setPincode(request.getParameter("pincode"));
        user.setMobile(request.getParameter("mobile"));
        user.setDistrict(request.getParameter("district"));
        return user;
    }

    public static void insert(User user) throws SQLException, IOException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into user (username,password,mobile,address,pincode,district,name) values (?,?,?,?,?,?,?)");
        preparedStatement.setString(1,user.getUsername());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setString(3,user.getMobile());
        preparedStatement.setString(4,user.getAddress());
        preparedStatement.setString(5,user.getPincode());
        preparedStatement.setString(6,user.getDistrict());
        preparedStatement.setString(7,user.getName());
        preparedStatement.executeUpdate();
    }

    public static void delete(User user) throws SQLException, IOException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from user where username = ?");
        preparedStatement.setString(1,user.getUsername());
        preparedStatement.executeUpdate();
    }

    public static void update(User user) throws SQLException, IOException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update user  set password = ? ,mobile= ?,address=?,pincode=?,district=?,name=? where username = ?");
        preparedStatement.setString(7,user.getUsername());
        preparedStatement.setString(1,user.getPassword());
        preparedStatement.setString(2,user.getMobile());
        preparedStatement.setString(3,user.getAddress());
        preparedStatement.setString(4,user.getPincode());
        preparedStatement.setString(5,user.getDistrict());
        preparedStatement.setString(6,user.getName());
        preparedStatement.executeUpdate();
    }

}
