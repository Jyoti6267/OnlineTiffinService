package servlets;

import database.MenuDAO;
import database.entity.Menu;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MealRegistration extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         req.getRequestDispatcher("/views/meal_registration.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Menu menu = MenuDAO.builder(req);
        if (menu != null){
            try {
                MenuDAO.insert(menu);
                req.setAttribute("message","Meal is registered successfully");
            }
            catch (Exception exception){
                MenuDAO.deleteFile(menu.getUrl(),req);
                req.setAttribute("message","Registration Failed");
            }
        }
        doGet(req,resp);
    }
}