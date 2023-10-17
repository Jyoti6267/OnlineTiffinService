package servlets;

import database.MenuDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Menu extends HttpServlet {



    private static void initializeModel(HttpServletRequest request) {
        try {
            ArrayList<database.entity.Menu> list = MenuDAO.fetchAll();
            ArrayList<ArrayList<database.entity.Menu>> menus = new ArrayList<>();
            for (int i = 0; i <list.size();i++){
                if(i % 3 == 0 ) menus.add(new ArrayList<>());
                menus.get(menus.size()-1).add(list.get(i));
            }
            request.setAttribute("menus",menus);
        }
        catch (Exception exception){
            request.setAttribute("message","Failed to fetch menu");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        initializeModel(req);
        req.getRequestDispatcher("/views/menu.jsp").forward(req,resp);
    }
}
