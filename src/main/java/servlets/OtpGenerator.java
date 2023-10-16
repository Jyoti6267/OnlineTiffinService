package servlets;
import database.OtpDAO;
import database.entity.Otp;
import email.EmailService;
import utility.PropertyHolder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OtpGenerator extends HttpServlet {




    private boolean prepareMail(String email , String otp)  {
        String body = "<font color=\"blue\"><h2>Hello "+email+",</h2></font><br><br>\n" +
                "<div style=\"box-shadow: 0px 0px 10px 10px pink; padding: 10px;\">\n" +
                "<h3>The OTP is "+otp+" for the verification<br>\n" +
                "<h4>Sent By : </h4>\n" +
                "<h4>OnlineTiffinService Team</h4>\n" +
                "</div>\n";
        String subject = "Email Verification : OTP";
        String from = PropertyHolder.getValue("from");
        try {
            EmailService.sendMail(from, email, subject, body);
            return true;
        }
        catch (Exception e){
            return false;
        }


    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");

        if(email == null || email.length() < 3){
            resp.setStatus(400);
        }
        else {

            Otp otp = OtpDAO.generate(email);

            boolean status = prepareMail(email,otp.getOtp());

            if (otp != null && status) resp.setStatus(200);

            else resp.setStatus(400);

        }

    }
}