package servlets;

import database.MenuDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Menu extends HttpServlet {



    private void initializeModel(HttpServletRequest request) {
        try {
            ArrayList<database.entity.Menu> list = MenuDAO.fetchAll();
            // initializing all menu details
        }
        catch (Exception exception){
            request.setAttribute("message","Failed to fetch menu");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("/views/menu.jsp").forward(req,resp);
    }
}
