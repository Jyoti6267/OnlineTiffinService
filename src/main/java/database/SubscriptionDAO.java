package database;
import database.entity.Subscription;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

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

    public static class UnprocessedOrder{
        private String meal_type;
        private int order_id;
        private int menu_id;
        private String address;
        private String username;
        private String district;
        private String pincode;

        public String getMeal_type() {
            return meal_type;
        }

        public void setMeal_type(String meal_type) {
            this.meal_type = meal_type;
        }

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }


        public int getMenu_id() {
            return menu_id;
        }

        public void setMenu_id(int menu_id) {
            this.menu_id = menu_id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getPincode() {
            return pincode;
        }

        public void setPincode(String pincode) {
            this.pincode = pincode;
        }
    }


    public static ArrayList<UnprocessedOrder> fetchAllUnprocessedOrders() throws SQLException, IOException {
        Connection connection = GetConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("select * from (select \"Breakfast\" as Meal union select \"Lunch\" union select \"Dinner\") as food_type  , (select *   from subscription , user  where  user.username = subscription.username and order_date + interval days day <= current_date()) as unprocessed where (unprocessed.order_id,food_type.Meal,current_date()) not in (select * from dispatched(order_id,meal_type,date_))");
        ArrayList<UnprocessedOrder> orders = new ArrayList<>();
        while(set.next()){
            UnprocessedOrder unprocessedOrder = new UnprocessedOrder();
            unprocessedOrder.setOrder_id(set.getInt("order_id"));
            unprocessedOrder.setAddress(set.getString("address"));
            unprocessedOrder.setDistrict(set.getString("district"));
            unprocessedOrder.setPincode(set.getString("pincode"));
            unprocessedOrder.setMenu_id(set.getInt("menu_id"));
            unprocessedOrder.setUsername(set.getString("subscription.username"));
            unprocessedOrder.setMeal_type(set.getString("meal_type"));
            orders.add(unprocessedOrder);
        }
        return orders;
    }
}
