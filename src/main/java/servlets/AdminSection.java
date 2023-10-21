package servlets;
import database.MenuDAO;
import database.SubscriptionDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AdminSection extends HttpServlet {


    private static void initializeData(HttpServletRequest request){

        try {
            ArrayList<SubscriptionDAO.UnprocessedOrder> orders = SubscriptionDAO.fetchAllUnprocessedOrders();
            ArrayList<database.entity.Menu> menus = MenuDAO.fetchAll();
            request.setAttribute("orders",orders);
            request.setAttribute("menus",menus);
        } catch (Exception e) {
            request.setAttribute("message","Failed to fetch orders");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        initializeData(req);
        req.getRequestDispatcher("/views/admin_section.jsp").forward(req,resp);
    }
}
