package servlets;

import database.DispatchedDAO;
import database.entity.Dispatched;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class DispatchOrder extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String type = req.getParameter("meal_type");
            int id = Integer.parseInt(req.getParameter("order_id"));
            Date date = new Date(System.currentTimeMillis());
            Dispatched dispatched = DispatchedDAO.builder(type, id, date);
            DispatchedDAO.insert(dispatched);
            req.setAttribute("message","Order is dispatched successfully");
        }
        catch (Exception exception){
            System.out.println(exception);
            req.setAttribute("message","Failed to dispatch");
        }
        req.getRequestDispatcher("/admin_section").forward(req,resp);
    }
}
