<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 1/13/2022
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.modelPackage.LoginCredentials"%>
<%@ page import="com.modelPackage.ProductListModel"%>
<%! int i=0;%>

<html lang="en">
<html>
<head>
    <meta charset="UTF-8">
    <title>ProductListModel</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
</head>


<body>
<div class=container">
    <center><h1 style="color: Blue">Products</h1></center>

    <div class="d-flex flex-row bd-highlight mb-3">
        <% for(i=0;i<ProductListModel.productList.size();i++){%>
        <div class="p-2 bd-highlight">
            <div class="product-top">
                <img src="<%=ProductListModel.productList.get(i).itemImage%>" width="225px" height="225px">
            </div>
            <div class="product-bottom text-center">
                <h3><%=ProductListModel.productList.get(i).itemName%></h3>
                <h5 style="color: Magenta"><%=ProductListModel.productList.get(i).itemPrice%> Taka</h5>
                <button id="<%=ProductListModel.productList.get(i).itemId%>" onclick='buyProduct(this.id)' type="button" class="btn btn-secondary">Buy Now</button>
            </div>
        </div>
        <%}%>
    </div>

    <div class="mx-3 d-flex flex-row bd-highlight mb-3 position-absolute top-0 end-0">
        <a href="LogoutServlet" class="mx-2 text-decoration-none">Log Out</a>
        <br>
        <a  href="DisplayCartServlet" class="mx-2 text-decoration-none" id="cart">My Cart</a>
        <p id="shoppingcartValue" class="mx-2"><%=LoginCredentials.UserCart%></p>
    </div>
</div>



<script>
    function buyProduct(clickedID) {
        var xhttp = new XMLHttpRequest();
        var parameter;
        var value = document.getElementById("shoppingcartValue").innerHTML;
        value++;
        document.getElementById("shoppingcartValue").innerHTML = value;
        parameter ="id=".concat(clickedID);
        xhttp.open("POST","ShopCartServlet",true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send(parameter);
        window.location.reload();

    }
</script>

</body>
</html>
