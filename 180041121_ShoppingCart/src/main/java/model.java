import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// User model and Shop cart is defined here with hardcoded data

class UserModel{
    int UserId;
    String UserName;
    String Password;


    public static List<UserModel> UserList = Arrays.asList(
            new UserModel(1,"Harold","12345"),
            new UserModel(2,"Finch","67890"),
            new UserModel(3,"John","12345"),
            new UserModel(4,"Reese","67890"),
            new UserModel(5,"Root","12345")
    );

    public UserModel(){

    }

    public UserModel(int UserId, String UserName, String Password) {
        this.UserId = UserId;
        this.UserName = UserName;
        this.Password = Password;
    }
}



class ShopCartModel {
    int itemId;
    int UserId;
    String itemName;
    double itemPrice;
    int itemQuantity;
    String itemImage;
    public static List<ShopCartModel> CartList = new ArrayList<ShopCartModel>();

    public ShopCartModel() {
    }
    public ShopCartModel(int itemId, int UserId, String itemName, double itemPrice, int itemQuantity,String itemImage) {
        this.itemId = itemId;
        this.UserId = UserId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.itemImage = itemImage;
    }
}