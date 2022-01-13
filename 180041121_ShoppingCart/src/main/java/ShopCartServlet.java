import com.modelPackage.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//This is the class that is used to add products and their quantity definition.

@WebServlet(name = "ShopCartServlet", value = "/ShopCartServlet")
public class ShopCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        boolean AddDone = false;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        ShopCartModel shopCartModel = null;
        ProductListModel productListModel1 = new ProductListModel();

        for(ShopCartModel shoppingCartModel1: ShopCartModel.CartList)
        {
            if(shoppingCartModel1.itemId == id && shoppingCartModel1.UserId == LoginCredentials.UserId)
            {
                shoppingCartModel1.itemQuantity += 1;
                AddDone = true;
                break;
            }
        }

        if(!AddDone) {
            LoginCredentials.UserCart++;
            for(ProductListModel productListmodel: productListModel1.productList )
            {

                if(productListmodel.itemId == id)
                {
                    shopCartModel = new ShopCartModel(productListmodel.itemId, LoginCredentials.UserId, productListmodel.itemName,productListmodel.itemPrice,1, productListmodel.itemImage);
                    break;
                }
            }
            ShopCartModel.CartList.add(shopCartModel);
        }
    }
}
