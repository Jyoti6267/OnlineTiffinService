package database;
import database.entity.Subscription;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    private static Subscription  builder(ResultSet resultSet) throws SQLException {
        Subscription subscription = new Subscription();
        subscription.setUsername(resultSet.getString("username"));
        subscription.setMenu_id(resultSet.getInt("menu_id"));
        subscription.setDays(resultSet.getInt("days"));
        subscription.setId(resultSet.getInt("id"));
        subscription.setOrder_date(resultSet.getDate("order_date"));
        return subscription;
    }


    public static ArrayList<Subscription> fetchAll(String username) throws SQLException, IOException {
            Connection connection = GetConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from subscriptions where username  = ?");
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Subscription> subscriptions = new ArrayList<>();
            while(resultSet.next()){
                subscriptions.add(builder(resultSet));
            }
            return subscriptions;

    }

//    public static void delete(Subscription subscription) throws SQLException, IOException {
//        Connection connection = GetConnection.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement("delete from subscription where id = ?");
//        preparedStatement.setInt(1, subscription.getId());
//        preparedStatement.executeUpdate();
//    }

//    public static void update(Subscription subscription) throws SQLException, IOException {
//        Connection connection = GetConnection.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement("update subscription  set menu_id=?,username=?,order_date=?,days=? where id = ?");        preparedStatement.setInt(1,subscription.getMenu_id());
//        preparedStatement.setInt(1,subscription.getMenu_id());
//        preparedStatement.setString(2,subscription.getUsername());
//        preparedStatement.setDate(3,subscription.getOrder_date());
//        preparedStatement.setInt(4,subscription.getDays());
//        preparedStatement.setInt(5,subscription.getId());
//        preparedStatement.executeUpdate();
//    }

    public static Subscription builder(HttpServletRequest request){

        try {
            Subscription subscription = new Subscription();
            String days = request.getParameter("days");
            if (days == null) return null;
            subscription.setDays(Integer.parseInt(days));
            String menu_id = request.getParameter("menu_id");
            if (menu_id == null) return null;
            subscription.setMenu_id(Integer.parseInt(menu_id));
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            if (username == null) return null;
            subscription.setUsername(username);
            Date current_date = new Date(System.currentTimeMillis());
            subscription.setOrder_date(current_date);
            return subscription;
        }
        catch (Exception exception){
            return null;
        }



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
        ResultSet set = statement.executeQuery("select * from (select \"Breakfast\" as Meal union select \"Lunch\" union select \"Dinner\") as food_type  , (select address,district,menu_id,subscription.id as order_id,user.username as username,pincode   from subscription , user  where  user.username = subscription.username and order_date + interval days day > current_date()) as unprocessed where (unprocessed.order_id,food_type.Meal,current_date()) not in (select order_id,meal_type,date_ from dispatched)");
        ArrayList<UnprocessedOrder> orders = new ArrayList<>();
        while(set.next()){
            UnprocessedOrder unprocessedOrder = new UnprocessedOrder();
            unprocessedOrder.setOrder_id(set.getInt("order_id"));
            unprocessedOrder.setAddress(set.getString("address"));
            unprocessedOrder.setDistrict(set.getString("district"));
            unprocessedOrder.setPincode(set.getString("pincode"));
            unprocessedOrder.setMenu_id(set.getInt("menu_id"));
            unprocessedOrder.setUsername(set.getString("username"));
            unprocessedOrder.setMeal_type(set.getString("Meal"));
            orders.add(unprocessedOrder);
        }
        return orders;
    }
}
