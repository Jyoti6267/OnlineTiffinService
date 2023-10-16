package filters;
import database.UserDAO;
import database.entity.User;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import static utility.Utilities.path;

public class LoginAuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    private boolean authenticate(String username , String password,HttpServletRequest request) {
        if (username == null || password == null) {
            request.setAttribute("message","Authentication Failed");
            return false;

        }
        else {

            try {
                User user = UserDAO.get(username);
                if (user == null) {
                    request.setAttribute("message","User does not exists");
                    return false;
                }
                else{

                    if (password.equals(user.getPassword())){
                        request.setAttribute("message","Logged In Successfully");
                        return true;
                    }
                    else{
                        request.setAttribute("message","Invalid Credentials");
                        return false;
                    }

                }
            }
            catch (Exception exception){
                request.setAttribute("message","There is some problem");
                return false;
            }

        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if (session.getAttribute("username")!=null){
            filterChain.doFilter(request,response);
        }
        else{
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            boolean status = authenticate(username,password,request);
            if (status) {
                session.setMaxInactiveInterval(60*60);
                session.setAttribute("username",username);
                filterChain.doFilter(request,response);
            }
            else response.sendRedirect(path(request,"/login?message="+request.getAttribute("message")));
        }

    }

    @Override
    public void destroy() {

    }
}
