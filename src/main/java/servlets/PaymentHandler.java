package servlets;

import database.SubscriptionDAO;
import database.entity.Subscription;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PaymentHandler extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Subscription subscription = SubscriptionDAO.builder(req);
        if (subscription == null){
            req.setAttribute("message","Failed to purchase plan");
            req.getRequestDispatcher("/menu").forward(req,resp);
        }
        try {
            SubscriptionDAO.insert(subscription);
            req.setAttribute("message","Order is purchased Successfully");
            req.getRequestDispatcher("/menu").forward(req,resp);
        }
        catch (Exception exception){
            req.setAttribute("message","Failed to purchase plan");
            req.getRequestDispatcher("/menu").forward(req,resp);
        }


    }
}
