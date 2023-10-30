package servlets;

import database.UserDAO;
import database.entity.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Update extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = (String) req.getSession().getAttribute("username");
            User user = UserDAO.get(username);
            req.setAttribute("user",user);
        }
        catch (Exception exception){
            req.setAttribute("message","Failed to fetch old details");
        }
        req.getRequestDispatcher("/views/update.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            User user = UserDAO.builder(req);
            UserDAO.update(user);
            req.setAttribute("message","Profile updated successfully");
            req.setAttribute("user",user);
        }
        catch (Exception exception){
            req.setAttribute("message","There is some problem");
        }
        req.getRequestDispatcher("/views/update.jsp").forward(req,resp);
    }
}
