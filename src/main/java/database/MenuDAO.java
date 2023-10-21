package database;
import database.entity.Menu;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import utility.PropertyHolder;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {


    private static String filesLocation = PropertyHolder.getValue("filesLocation");

    public static Menu builder(HttpServletRequest request){
        Menu menu = new Menu();
        if(ServletFileUpload.isMultipartContent(request)){
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
            try{
                List<FileItem> items = fileUpload.parseRequest(request);
                for(FileItem item : items){
                    String name = item.getFieldName();
                    String value = item.getString();
                    switch (name){

                        case "sunday":
                        {
                            menu.setSunday(value);
                            break;
                        }
                        case "monday":{
                            menu.setMonday(value);
                            break;
                        }
                        case "tuesday":{
                            menu.setTuesday(value);
                            break;
                        }
                        case "wednesday":{
                            menu.setWednesday(value);
                            break;
                        }
                        case "thursday":{
                            menu.setThursday(value);
                            break;
                        }
                        case "friday":{
                            menu.setFriday(value);
                            break;
                        }
                        case "saturday":{
                            menu.setSaturday(value);
                            break;
                        }
                        case "title":{
                            menu.setTitle(value);
                            break;
                        }
                        case "price":{
                            menu.setPrice(Integer.parseInt(value));
                            break;
                        }
                        case "image":
                        {
                            String filename = nextId()+"_"+item.getName();
                            InputStream inputStream = item.getInputStream();
                            download(request,filename,inputStream);
                            menu.setUrl(request.getContextPath()+"/"+filesLocation+"/"+filename);
                            break;
                        }

                    }
                }


                return menu;

            } catch (IOException | FileUploadException | SQLException e) {
                e.printStackTrace();
                return null;
            }

        }

        return  null;
    }

    private static void download(HttpServletRequest request , String filename,InputStream inputStream) throws IOException {
        String path = request.getServletContext().getRealPath("/")+"/"+filesLocation+"/"+filename;
        File file = new File(path);
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(inputStream.readAllBytes());
        stream.close();
        inputStream.close();
    }

    public static void deleteFile(String filesLocation,HttpServletRequest request){
        String path = request.getServletContext().getRealPath("/")+filesLocation.substring(filesLocation.indexOf("/"));
        File file = new File(path);
        file.delete();
    }

    private static int nextId() throws SQLException, IOException {
        Connection connection = GetConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT AUTO_INCREMENT\n" +
                "FROM information_schema.TABLES\n" +
                "WHERE TABLE_SCHEMA = \"OnlineTiffinService\"\n" +
                "AND TABLE_NAME = \"menu\"");

        if (resultSet.next()) return (int)resultSet.getLong("AUTO_INCREMENT");
        else return 0;
    }

    public static void insert(Menu menu) throws SQLException, IOException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into menu (title,sunday,monday,tuesday,wednesday,thursday,friday,saturday,price,url) values (?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,menu.getTitle());
        preparedStatement.setString(2,menu.getSunday());
        preparedStatement.setString(3,menu.getMonday());
        preparedStatement.setString(4,menu.getTuesday());
        preparedStatement.setString(5,menu.getWednesday());
        preparedStatement.setString(6,menu.getThursday());
        preparedStatement.setString(7,menu.getFriday());
        preparedStatement.setString(8,menu.getSaturday());
        preparedStatement.setInt(9,menu.getPrice());
        preparedStatement.setString(10,menu.getUrl());
        preparedStatement.executeUpdate();
    }

    public static void delete(Menu menu) throws SQLException, IOException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from menu where id = ?");
        preparedStatement.setInt(1,menu.getId());
        preparedStatement.executeUpdate();
    }

    public static void update(Menu menu) throws SQLException, IOException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update menu set title = ? ,sunday = ? ,monday = ? ,tuesday=?,wednesday=?,thursday=?,friday=?,saturday=?,price=?,url=? where id = ?");
        preparedStatement.setString(1,menu.getTitle());
        preparedStatement.setString(2,menu.getSunday());
        preparedStatement.setString(3,menu.getMonday());
        preparedStatement.setString(4,menu.getTuesday());
        preparedStatement.setString(5,menu.getWednesday());
        preparedStatement.setString(6,menu.getThursday());
        preparedStatement.setString(7,menu.getFriday());
        preparedStatement.setString(8,menu.getSaturday());
        preparedStatement.setInt(9,menu.getPrice());
        preparedStatement.setString(10,menu.getUrl());
        preparedStatement.setInt(11,menu.getId());
        preparedStatement.executeUpdate();
    }

    private static Menu builder(ResultSet set) throws SQLException {
        Menu menu = new Menu();
        menu.setUrl(set.getString("url"));
        menu.setPrice(set.getInt("price"));
        menu.setTitle(set.getString("title"));
        menu.setSunday(set.getString("sunday"));
        menu.setMonday(set.getString("monday"));
        menu.setTuesday(set.getString("tuesday"));
        menu.setWednesday(set.getString("wednesday"));
        menu.setThursday(set.getString("thursday"));
        menu.setFriday(set.getString("friday"));
        menu.setSaturday(set.getString("saturday"));
        menu.setId(set.getInt("id"));
        return menu;
    }

    public static ArrayList<Menu> fetchAll() throws SQLException, IOException {
        Connection connection = GetConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("select * from menu");
        ArrayList<Menu> result = new ArrayList<>();
        while (set.next()){
            result.add(builder(set));
        }
        return result;
    }


    public static Menu get(int menu_id) throws SQLException, IOException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from menu where id = ?");
        ResultSet set = preparedStatement.executeQuery();
        if (!set.next()) return null;
        return builder(set);
    }


}
