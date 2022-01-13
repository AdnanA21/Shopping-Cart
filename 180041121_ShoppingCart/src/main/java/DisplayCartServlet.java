import com.modelPackage.LoginCredentials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DisplayCartServlet", value = "/DisplayCartServlet")
public class DisplayCartServlet extends HttpServlet {

    //To show all elements that I added to my cart

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        double totalPrice = 0;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        out.println("<html>\n"+
                "<head>\n"+
                "<title>My Cart</title>\n"+
                "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n" +
                "</head>\n"+
                "<body>\n"+
                "<div class=\"container\">\n"+
                "\n"+
                "<div class=\"m-3 w-100 d-flex flex-row bd-highlight mb-3 position-absolute top-0\">"+
                "<b><a href=\"ListOfProduct.jsp\" class=\"mx-2 w-50 \">Back</a></b>"+
                "<br>"+
                "<b><a href=\"LogoutServlet\" class=\"mx-2 w-50 \">Log Out</a></b></div>"+
                "<div class=\"d-flex my-5 bd-highlight\">\n"+
                "     <span class=\"p-2 fs-4 w-50\">Item</span>\n" +
                "     <span class=\"p-2 fs-4 w-25\">Price</span>\n" +
                "     <span class=\"p-2 fs-4 w-50\">Quantity</span>\n" +
                "</div>\n"
        );

        for(ShopCartModel shoppingCartModel:ShopCartModel.CartList) {

            if (shoppingCartModel.UserId == LoginCredentials.UserId) {
                totalPrice += shoppingCartModel.itemPrice * shoppingCartModel.itemQuantity;
                out.println
                        ("<div class=\"d-flex bd-highlight\">\n" +
                        "<div class=\"p-2 w-50\">\n" +
                        "<img class=\"\" src=" + shoppingCartModel.itemImage+ " width=\"100\" height=\"100\">\n" +
                        "<span class=\"m-2 fs-5\">" + shoppingCartModel.itemName + "</span>\n" +
                        "</div>\n" +
                        "<span class=\"p-2 fs-5 w-25\">\n" +
                        "            " + shoppingCartModel.itemPrice + "\n" +
                        "</span>\n" +
                        "<div class=\"p-2 w-50\">\n" +
                        "<input id=\"quantity" + shoppingCartModel.itemId + "\"size=\"4\" maxlength=\"4\" type=\"number\" onchange=\"UpdateQuantity(this.id)\" class=\"rounded-3\" value=\"" + shoppingCartModel.itemQuantity + "\">\n" +
                        "<button id=\"" + shoppingCartModel.itemId + "\" class=\"btn btn-danger\" onclick=removeItem(this.id)>Remove</button>\n" +
                        "</div>\n" +
                        "</div>\n");
            }
        }
        out.println(
                "<div class=\"text-center mt-3 me-5\">\n" +
                        "    <strong class=\"fs-5 fw-bold me-3\">Your Total</strong>\n" +
                        "    <span class=\"fs-6\">" + totalPrice + " BDT</span>\n" +
                        "</div>\n" +
                        "<div class=\"text-center mt-3 me-5\"><button class=\"btn btn-primary\" onclick=purchase()>Check Out</button></div>" +
                        "</div>\n" +
                        "<script>\n" +
                        "    function removeItem(clickedID) {\n" +
                        "        var xhttp = new XMLHttpRequest()\n" +
                        "        var parameter;\n" +
                        " console.log(clickedID);" +
                        "        parameter =\"id=\".concat(clickedID);\n" +
                        "        xhttp.open(\"POST\",\"?DeleteFromCartServlet\",true);\n" +
                        "        xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n" +
                        "        xhttp.send(parameter);\n" +
                        "window.location.reload();" +
                        "    }\n" +
                        "function UpdateQuantity(clickedID)\n" +
                        "    {\n" +
                        "        var id = clickedID.substring(8,10);\n" +
                        "        var xhttp = new XMLHttpRequest()\n" +
                        "        var parameter;\n" +
                        "        var newValue = document.getElementById(clickedID).value;\n" +
                        "if(newValue ==\"0\"){" +
                        "removeItem(id);" +
                        "}else{"+
                        "        parameter =\"id=\".concat(id);\n" +
                        "        parameter = parameter.concat(\"&value=\");\n" +
                        "        parameter = parameter.concat(newValue);\n" +
                        "        xhttp.open(\"POST\",\"UpdateQuantityServlet\",true);\n" +
                        "        xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n" +
                        "        xhttp.send(parameter);\n" +
                        "        window.location.reload();\n" +
                        "    }" +
                        "}\n" +
                        "function purchase(){\n" +
                        "        var xhttp = new XMLHttpRequest();\n" +
                        "        xhttp.open(\"POST\",\"PurchaseServlet\",true);\n" +
                        "        xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n" +
                        "        xhttp.send();\n" +
                        "window.location.reload();"+
                        "    }"+
                        "</script>" +
                        "</body>\n" +
                        "</html>\n");
    }
}
