package filters;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginAuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    private String path(HttpServletRequest request,String path){
        return request.getContextPath()+path;
    }


    private boolean authenticate(String username , String password){
        if (username == null || password == null) return false;
        else {

            // authenticated successfully .....

            return true;

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
            boolean status = authenticate(username,password);
            if (status) filterChain.doFilter(request,response);
            else response.sendRedirect(path(request,"/login"));
        }

    }

    @Override
    public void destroy() {

    }
}
