package servlets;

import database.MenuDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Payment extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
            int menu_id = Integer.parseInt(req.getParameter("menu_id"));
            database.entity.Menu menu = MenuDAO.get(menu_id);
            if (menu == null){
                req.setAttribute("message","Invalid Plan");
                req.getRequestDispatcher("/menu").forward(req,resp);
            }
            else{
                req.setAttribute("menu",menu);
                req.getRequestDispatcher("/views/payment.jsp").forward(req,resp);
            }

        }
        catch(Exception e){
            req.setAttribute("message","There is some problem");
            req.getRequestDispatcher("/menu").forward(req,resp);
        }

    }
}
