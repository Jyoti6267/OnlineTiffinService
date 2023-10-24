package servlets;

import database.UserDAO;
import database.entity.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class Profile extends HttpServlet {


    private static void initializeData(HttpServletRequest request) throws IOException {


            HttpSession session = request.getSession();

            String username = (String)session.getAttribute("username");
            try {
                User user = UserDAO.get(username);
                request.setAttribute("userDetails",user);
            }
            catch (Exception e){
                request.setAttribute("message","Failed to fetch profile");
            }



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        initializeData(req);
        req.getRequestDispatcher("/views/profile.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        initializeData(req);
        req.getRequestDispatcher("/views/profile.jsp").forward(req,resp);
    }
}
