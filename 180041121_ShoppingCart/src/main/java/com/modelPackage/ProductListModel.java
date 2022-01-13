package com.modelPackage;
import java.util.Arrays;
import java.util.List;


//As the name suggests, it is the list of all products list that a user will see while jumping into the app

public class ProductListModel {
    public int itemId;
    public String itemName;
    public String itemImage;
    public double itemPrice;


    public ProductListModel(){}

    public static List<ProductListModel> productList = Arrays.asList(
            new ProductListModel(1,"T-shirt",400,"./images/t-shirt.jpg"),
            new ProductListModel(2,"Jeans Pant",1250,"./images/jeans.jpg"),
            new ProductListModel(3,"Hoodie",750,"./images/hoodie.jpg"),
            new ProductListModel(4,"Jacket",2100,"./images/jacket.jpg"),
            new ProductListModel(5,"Shirt",800,"./images/shirt.jpg"),
            new ProductListModel(6,"Sweat Shirt",550,"./images/sweat-shirt.jpg")
    );

    public ProductListModel(int Id, String Name, double Price, String Image) {
        this.itemId = Id;
        this.itemName = Name;
        this.itemPrice = Price;
        this.itemImage = Image;
    }

}
