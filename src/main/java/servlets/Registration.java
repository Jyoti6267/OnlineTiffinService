package servlets;

import database.OtpDAO;
import database.UserDAO;
import database.entity.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registration extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = req.getScheme()+"://"+req.getServerName()+":"+req.getLocalPort()+req.getServletContext().getContextPath()+"/otp_request";
        req.setAttribute("link",link);
        req.getRequestDispatcher("/views/registration.jsp").forward(req,resp);
    }

    private boolean verifyOtp(HttpServletRequest request){
        String otp = request.getParameter("otp");
        try {
            boolean status = OtpDAO.authenticate(otp, request.getParameter("username"));
            if (status){
                return true;
            }
            else {
                request.setAttribute("message","Wrong OTP");
                return false;
            }
        }
        catch (Exception e){
            request.setAttribute("message","OTP Authentication Failed");
            return false;
        }
    }

    private boolean canRegister(User user,HttpServletRequest request) {
        try {
            boolean exists = UserDAO.exists(user);
            if (exists) {
                request.setAttribute("message", "User already exists");
                return false;
            }
            return verifyOtp(request);
        }
        catch (Exception e){
            request.setAttribute("message","There is some problem");
            return false;
        }
    }

    private void register(User user,HttpServletRequest request){
        try{
            UserDAO.insert(user);
            request.setAttribute("message","User registered successfully");
        }
        catch (Exception exception){
            request.setAttribute("message","There is some problem");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = UserDAO.builder(req);
        if (canRegister(user,req)){
            register(user,req);
        }
        req.setAttribute("user",user);
        doGet(req,resp);
    }
}
