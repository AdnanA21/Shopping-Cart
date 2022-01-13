import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import com.modelPackage.*;

//To logout from web app

@WebServlet(name = "LogoutServlet", value = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginCredentials.UserCart = 0;
        LoginCredentials.UserId = 0;
        LoginCredentials.Password = null;
        LoginCredentials.UserName = null;
        response.sendRedirect("login.html");
        LoginFilter.flag = false;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
