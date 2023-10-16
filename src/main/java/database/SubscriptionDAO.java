package database;
import database.entity.Subscription;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubscriptionDAO {


    public static void insert(Subscription subscription) throws SQLException, IOException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into subscription (menu_id,username,order_date,days) values (?,?,?,?)");
        preparedStatement.setInt(1,subscription.getMenu_id());
        preparedStatement.setString(2,subscription.getUsername());
        preparedStatement.setDate(3,subscription.getOrder_date());
        preparedStatement.setInt(4,subscription.getDays());
        preparedStatement.executeUpdate();
    }

    public static void delete(Subscription subscription) throws SQLException, IOException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from subscription where id = ?");
        preparedStatement.setInt(1, subscription.getId());
        preparedStatement.executeUpdate();
    }

    public static void update(Subscription subscription) throws SQLException, IOException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update subscription  set menu_id=?,username=?,order_date=?,days=? where id = ?");        preparedStatement.setInt(1,subscription.getMenu_id());
        preparedStatement.setInt(1,subscription.getMenu_id());
        preparedStatement.setString(2,subscription.getUsername());
        preparedStatement.setDate(3,subscription.getOrder_date());
        preparedStatement.setInt(4,subscription.getDays());
        preparedStatement.setInt(5,subscription.getId());
        preparedStatement.executeUpdate();
    }

}
