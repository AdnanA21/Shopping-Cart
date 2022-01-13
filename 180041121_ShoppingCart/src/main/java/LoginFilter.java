import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import com.modelPackage.*;

//To filter the user existence.

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public static int UserId = 0;
    public static boolean flag = false;


    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        if (LoginCredentials.UserName == null && LoginCredentials.Password == null) {
            LoginCredentials.UserName = request.getParameter("username");
            LoginCredentials.Password = request.getParameter("password");
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (LoginCredentials.UserName != null && LoginCredentials.Password != null) {

            if (LoginCredentials.UserId == 0) {

                for (UserModel UserModel1 : UserModel.UserList) {

                    if (LoginCredentials.UserName.equals(UserModel1.UserName) && LoginCredentials.Password.equals(UserModel1.Password)) {
                        LoginCredentials.UserId = UserModel1.UserId;

                        for (ShopCartModel shopCartModel : ShopCartModel.CartList) {
                            if (shopCartModel.UserId == LoginCredentials.UserId) {
                                LoginCredentials.UserCart++;
                            }

                        }

                        flag = true;
                        break;
                    }
                }
            }

            if(flag == true)
            {
                chain.doFilter(request, response);
            }
            else
            {
                LoginCredentials.UserId = 0;
                LoginCredentials.UserName = null;
                LoginCredentials.Password = null;
                out.println("<html><body><script>alert('Login Credential Does not match');" +
                        "window.location.replace('login.html');" +
                        "</script></body></html>");
            }

        }

        else
        {
            out.println("<html><body><script>alert('Please Login First');" +
                    "window.location.replace('login.html');" +
                    "</script></body></html>");
        }




    }
}
