package servlets;

import database.GetConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import static utility.Utilities.path;

public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if (session.getAttribute("username")!=null) {
            resp.sendRedirect(path(req,"/profile"));
            return;
        }

        req.getRequestDispatcher("/views/login.jsp").forward(req,resp);

    }
}
