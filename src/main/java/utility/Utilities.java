package utility;

import javax.servlet.http.HttpServletRequest;

public class Utilities {

    public static String path(HttpServletRequest request, String path){
        return request.getContextPath()+path;
    }
}
