package database;

import database.entity.Dispatched;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class DispatchedDAO {


    public static Dispatched builder(String meal_type , int order_id , Date date){
        Dispatched dispatched = new Dispatched();
        dispatched.setDate(date);
        dispatched.setOrder_id(order_id);
        dispatched.setMeal_type(meal_type);
        return dispatched;
    }

    public static boolean insert(Dispatched dispatched){
        try {
            Connection connection = GetConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into dispatched (date_,order_id,meal_type) values (?,?,?)");
            preparedStatement.setDate(1,dispatched.getDate());
            preparedStatement.setInt(2,dispatched.getOrder_id());
            preparedStatement.setString(3,dispatched.getMeal_type());
            preparedStatement.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
