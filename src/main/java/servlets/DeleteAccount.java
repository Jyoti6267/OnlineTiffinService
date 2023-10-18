package servlets;

import database.UserDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteAccount extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        try {
            UserDAO.delete(UserDAO.get(username));
            req.setAttribute("message","Account is deleted successfully");
            req.getRequestDispatcher("/home").forward(req,resp);
        }
        catch (Exception e){
            req.setAttribute("message","Not able to delete account");
            req.getRequestDispatcher("/profile").forward(req,resp);
        }

    }
}
