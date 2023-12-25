package project.najah.edu;

import car.database.CategoryList;
import org.example.Product;

import java.util.List;
import java.util.logging.Logger;
public class Menu {
    private static final String HEAD = "\u001b[35m--------------- Welcome To Car Accessories Company -------------------\u001b[0m";
    private static final String DASHBOARD = "\u001b[35m--------------- Dashboard -------------------\u001b[0m";
    private static final Logger LOGGER = Logger.getLogger(Menu.class.getName());

    private Menu() {
        throw new AssertionError("Instantiation not allowed for Menu class.");
    }
    public static void start (){
        LOGGER.info(HEAD);
        LOGGER.info("\u001b[35m1- Login\u001b[0m");
        LOGGER.info("\u001b[35m2- Sign Up\u001b[0m");
        LOGGER.info("\u001b[35m3- exit\u001b[0m");
    }
    public static void signup(){
        LOGGER.info("\u001b[35m1- Customer\u001b[0m");
        LOGGER.info("\u001b[35m2- Installer\u001b[0m");
        LOGGER.info("\u001b[35m3- Go Back\u001b[0m");
    }

    public static void admin1(){
        LOGGER.info(DASHBOARD);
        LOGGER.info("\u001b[35m1- Manage Products\u001b[0m");
        LOGGER.info("\u001b[35m2- View Customer acounts\u001b[0m");
        LOGGER.info("\u001b[35m3- sign out\u001b[0m");
    }

    public static void admin11(){
        LOGGER.info(DASHBOARD);
        LOGGER.info("\u001b[35m1- View Products\u001b[0m");
        LOGGER.info("\u001b[35m2- Add new product\u001b[0m");
        LOGGER.info("\u001b[35m3- Search for a product/category\u001b[0m");
        LOGGER.info("\u001b[35m4- Delete Category\u001b[0m");
        LOGGER.info("\u001b[35m5- go back\u001b[0m");
    }

    public static void productlist(){
        List<Product> product1;
        product1 = CategoryList.getProduct();

        LOGGER.info("\u001B[35m--------- Select Product and Quantity To Buy  ---------\u001B[0m");
        Product.viewProducts(product1);

        String s = "\u001B[35m"+Product.getNumProduct() + "\u001B[35m- Go Back.\u001B[0m";
        LOGGER.info(s);

        LOGGER.info("\u001b[35m------------------------------------------------------\u001b[0m");
    }
    public static void productlist2(){
        List<Product> product1;
        product1 = CategoryList.getProduct();

        LOGGER.info("\u001B[35m--------- Select Product to Update or Delete  ---------\u001B[0m");
        Product.viewProducts(product1);

        String s = "\u001B[35m"+Product.getNumProduct() + "\u001B[35m- Go Back.\u001B[0m";
        LOGGER.info(s);

        LOGGER.info("\u001b[35m------------------------------------------------------\u001b[0m");
    }

    public static void manageProducts(){
        LOGGER.info(DASHBOARD);
        LOGGER.info("\u001b[35m1- Update Product\u001b[0m");
        LOGGER.info("\u001b[35m2- Delete Product\u001b[0m");
        LOGGER.info("\u001b[35m3- Go Back\u001b[0m");
    }

    public static void manageAcounts(){
        LOGGER.info(DASHBOARD);
        LOGGER.info("\u001b[35m1- Update Acount\u001b[0m");
        LOGGER.info("\u001b[35m2- Delete Acount\u001b[0m");
        LOGGER.info("\u001b[35m3- Go Back\u001b[0m");
    }
    public static void installer1(){
        LOGGER.info(DASHBOARD);
        LOGGER.info("\u001b[35m1- View Installation Requests.\u001b[0m");
        LOGGER.info("\u001b[35m2- Schedule Appointments.\u001b[0m");
        LOGGER.info("\u001b[35m3- Sign Out.\u001b[0m");
    }

    public static void customer1(){
        LOGGER.info(DASHBOARD);
        LOGGER.info("\u001b[35m1- Browse products.\u001b[0m");
        LOGGER.info("\u001b[35m2- Search for a product.\u001b[0m");
        LOGGER.info("\u001b[35m3- Request Installation.\u001b[0m");
        LOGGER.info("\u001b[35m4- View Orders.\u001b[0m");
        LOGGER.info("\u001b[35m5- Edit Profile.\u001b[0m");
        LOGGER.info("\u001b[35m6- Sign Out.\u001b[0m");
    }
    public static void searchList(){
        LOGGER.info("\u001b[35m1-Search By Name\u001b[0m");
        LOGGER.info("\u001b[35m2-Search By Category\u001b[0m");
        LOGGER.info("\u001b[35m3-Go Back\u001b[0m");
    }
}
