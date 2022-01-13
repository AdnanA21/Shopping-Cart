import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import com.modelPackage.*;



@WebServlet(name = "DeleteFromCartServlet", value = "/DeleteFromCartServlet")
public class DeleteFromCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //To remove a product from cart
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int id = Integer.parseInt("id");
         LoginCredentials.UserCart--;
         ShopCartModel.CartList.removeIf(item->item.itemId == id);
    }
}
