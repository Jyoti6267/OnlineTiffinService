package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registration extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/registration.jsp").forward(req,resp);
    }

    private boolean canRegister(HttpServletRequest request){

        // user exists ?
        // valid otp ?
        // valid mobile , email , name etc

        return false;
    }

    private void register(HttpServletRequest request){

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // authentication of data
        String username = null;

    }
}
