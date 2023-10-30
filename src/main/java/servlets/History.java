package servlets;

import com.mysql.cj.result.LocalDateTimeValueFactory;
import database.MenuDAO;
import database.SubscriptionDAO;
import database.entity.Subscription;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class History extends HttpServlet {


    private static void initializeData(HttpServletRequest request){

        try {

            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            ArrayList<Subscription> orders = SubscriptionDAO.fetchAll(username);
            if (orders.size() == 0 ){
                request.setAttribute("message","No History");
                return;
            }
            ArrayList<database.entity.Menu> menus = MenuDAO.fetchAll();
            request.setAttribute("orders", orders);
            request.setAttribute("menus", menus);
            for (Subscription subscription : orders) {
                Date date = subscription.getOrder_date();
                int days = subscription.getDays();
                LocalDate last_date = date.toLocalDate().plusDays(days);
                LocalDate current_date = LocalDate.now();
                int days_left = (int) ChronoUnit.DAYS.between(current_date, last_date);
                subscription.setDays(days_left);
            }
        }
        catch (Exception exception){
                System.out.println(exception);
                request.setAttribute("message","Failed to fetch history");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            initializeData(req);
            req.getRequestDispatcher("/views/history.jsp").forward(req,resp);
    }
}
