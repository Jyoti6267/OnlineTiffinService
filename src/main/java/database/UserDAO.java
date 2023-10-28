package database;

import database.entity.User;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.*;

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
        PreparedStatement preparedStatement = connection.prepareStatement("delete from otp where username = ?");
        preparedStatement.setString(1,user.getUsername());
        preparedStatement.executeUpdate();

        preparedStatement = connection.prepareStatement("delete from subscription where username = ?");
        preparedStatement.setString(1,user.getUsername());
        preparedStatement.executeUpdate();


        preparedStatement = connection.prepareStatement("delete from user where username = ?");
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

    public static boolean exists(User user) throws SQLException, IOException {
        Connection connection = GetConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("select * from user where username = '"+user.getUsername()+"'");
        return set.next();
    }
    public static User get(String username) throws SQLException, IOException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from user where username = ?");
        statement.setString(1,username);
        ResultSet set = statement.executeQuery();
        return builder(set);
    }

    private static User builder(ResultSet set) throws SQLException {
        if (!set.next()) return null;
        User user  = new User();
        user.setUsername(set.getString("username"));
        user.setDistrict(set.getString("district"));
        user.setMobile(set.getString("mobile"));
        user.setAddress(set.getString("address"));
        user.setName(set.getString("name"));
        user.setPincode(set.getString("pincode"));
        user.setPassword(set.getString("password"));
        return user;
    }


}
