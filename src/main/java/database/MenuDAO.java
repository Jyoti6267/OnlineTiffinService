package database;

import database.entity.Menu;
import database.entity.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import utility.PropertyHolder;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.sql.*;
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

            } catch (IOException | FileUploadException | SQLException e) {
                e.printStackTrace();
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
