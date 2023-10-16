package database;

import database.entity.Otp;

import java.io.IOException;
import java.sql.*;
import java.util.Random;

public class OtpDAO {

    public static Otp generate(String email) {

        try {
            Otp otp = exists(email);
            if (otp != null) {

                Timestamp current = new Timestamp(System.currentTimeMillis());
                boolean expired = current.compareTo(otp.getExpires()) >= 0;
                if (expired) {
                    delete(otp);
                    otp = builder(email);
                    insert(otp);
                } else {
                    Timestamp expires = new Timestamp(System.currentTimeMillis() + 180 * 1000);
                    otp.setExpires(expires);
                    update(otp);
                }
            } else {
                otp = builder(email);
                insert(otp);
            }
            return otp;
        }
        catch (Exception exception){
            return null;
        }
    }

    private static void insert(Otp otp) throws SQLException, IOException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into otp (otp,expires,username)  values (?,?,?)");
        preparedStatement.setString(1,otp.getOtp());
        preparedStatement.setString(3,otp.getUsername());
        preparedStatement.setTimestamp(2,otp.getExpires());
        preparedStatement.executeUpdate();

    }

    private static void delete(Otp otp) throws SQLException, IOException {
        Connection connection = GetConnection.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("delete from otp where id = "+otp.getId());
    }

    private static void update(Otp otp) throws SQLException, IOException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update otp set expires = ? where id = ?");
        preparedStatement.setTimestamp(1,otp.getExpires());
        preparedStatement.setInt(2,otp.getId());
        preparedStatement.executeUpdate();
    }

    private static Otp builder(String email){
        Random random= new Random();
        String new_otp = ""+random.nextInt(100000,1000000);
        Timestamp expires = new Timestamp(System.currentTimeMillis() + 180*1000);
        Otp otp = new Otp();
        otp.setUsername(email);
        otp.setOtp(new_otp);
        otp.setExpires(expires);
        return otp;
    }

    private static Otp builder(ResultSet set) throws SQLException {
        if (!set.next()) return null;
        Otp otp = new Otp();
        otp.setOtp(set.getString("otp"));
        otp.setExpires(set.getTimestamp("expires"));
        otp.setId(set.getInt("id"));
        otp.setUsername(set.getString("username"));
        return otp;
    }

    private static Otp exists(String email) throws SQLException, IOException {

        Connection connection = GetConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from otp where username = '"+email+"'");
        if (resultSet.next()) return null;
        return builder(resultSet);
    }

    public static boolean authenticate(String otp , String email) throws SQLException, IOException {
        Otp actual_otp = exists(email);
        if (actual_otp == null) return false;
        Timestamp current = new Timestamp(System.currentTimeMillis());
        boolean expired = current.compareTo(actual_otp.getExpires())>=0;
        if (expired) return false;
        return actual_otp.getOtp().equals(otp);

    }


}
