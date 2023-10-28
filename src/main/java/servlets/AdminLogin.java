package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static utility.Utilities.path;

public class AdminLogin extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if (session.getAttribute("admin")!=null) {
            resp.sendRedirect(path(req,"/admin_section"));
            return;
        }

        req.getRequestDispatcher("/views/admin_login.jsp").forward(req,resp);
    }
}
