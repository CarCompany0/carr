package project.najah.edu;

import car.database.CategoryList;
import car.database.Userslist;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Product;
import org.example.User;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class admin {
    private static final Logger LOGGER = Logger.getLogger(admin.class.getName());

    LoginSteps loginsteps;
    private String pr;
    private Integer pnum;
    private String type;
    private String img;
    private String name;
    private String des;
    private String price;
    private String ava;
    private String cName;
    private String username;
    private String loc;
    private String phnum;
    private int unum;
    private String cat;
    public admin(LoginSteps loginsteps) {
        this.loginsteps =loginsteps;
    }
    @Given("that the user is an admin")
    public void that_the_user_is_an_admin() {
        // Write code here that turns the phrase above into concrete actions
        loginsteps.login();
        assertTrue(loginsteps.isAdminIsLogged());

    }
    @When("the type is {string}")
    public void the_type_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.type=string;
    }
    @When("the name is {string}")
    public void the_name_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.name=string;
    }
    @When("the des is {string}")
    public void the_des_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.des=string;
    }
    @When("the image is {string}")
    public void the_image_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.img=string;
    }

    @When("the price is {string}")
    public void the_price_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.price=string;
    }
    @When("availablity is {string}")
    public void availablity_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.ava= string;
    }

    @Then("The product is added successfully")
    public void theProductIsAddedSuccessfully() {
        // Write code here that turns the phrase above into concrete actions
        List<Product> prosuctList;
        prosuctList = CategoryList.getProduct();
        if (type.isEmpty() || name.isEmpty() || des.isEmpty() || img.isEmpty() || price.isEmpty() || ava.isEmpty()) {
            Product.showError();
        }
        else {   Product.addProduct(prosuctList,type,name,des,img,price,ava);
            assertTrue(Product.isAdded());}
    }

    @Then("The product is failed to add")
    public void the_product_is_failed_to_add() {
        // Write code here that turns the phrase above into concrete actions
        if (type.isEmpty() || name.isEmpty() || des.isEmpty() || img.isEmpty() || price.isEmpty() || ava.isEmpty()) {
            Product.showError();
            assertFalse(Product.isAdded());
        }

    }
    @When("Product num {string}")
    public void product_num(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.pnum=Integer.parseInt(string);
    }
    @Then("the product\\/category is failed to Update")
    public void the_product_category_is_failed_to_update() {
        // Write code here that turns the phrase above into concrete actions
        if (type.isEmpty() || name.isEmpty() || des.isEmpty() || img.isEmpty() || price.isEmpty() || ava.isEmpty()) {
            Product.showError();
            assertFalse(Product.isUpdated());
        }


    }

    @Then("the product\\/category is Updated successfully in the list")
    public void the_product_category_is_updated_successfully_in_the_list() {
        List<Product> prosuctList;
        prosuctList = CategoryList.getProduct();
        if (pnum==null ||type.isEmpty() || name.isEmpty() || des.isEmpty() || img.isEmpty() || price.isEmpty() || ava.isEmpty()) {
            Product.showError();
        }
        else {
            boolean av = Boolean.parseBoolean(ava);
            Product product=new Product(type,name,des,img,price,av);
            Product.updateProductByNum(prosuctList, pnum,product);
            assertTrue(Product.isUpdated());
        }
    }
    @When("Category name {string}")
    public void category_name(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.cName=string;
    }




    @Then("product is failed to Update or delete")
    public void product_is_failed_to_update_or_delete() {
        // Write code here that turns the phrase above into concrete actions
        List<Product> prosuctList;
        prosuctList = CategoryList.getProduct();
        if(pnum>prosuctList.size()+1){
            Product.showError2();
            assertFalse(Product.isDeleted()&&Product.isUpdated());

        }
        else{
            boolean av = Boolean.parseBoolean(ava);
            Product product=new Product(type,name,des,img,price,av);
            Product.updateProductByNum(prosuctList, pnum,product);
            Product.removeProductByNum(prosuctList, pnum);
        }
    }


    @Then("The product is deleted successfully from the list")
    public void the_product_is_deleted_successfully_from_the_list() {
        // Write code here that turns the phrase above into concrete actions
        List<Product> prosuctList;
        prosuctList = CategoryList.getProduct();

        if(pnum>prosuctList.size()+1){
            Product.showError2();

        }
        else
            Product.removeProductByNum(prosuctList, pnum);
        assertTrue(Product.isDeleted());
    }





    @Then("The category is deleted successfully from the list")
    public void the_category_is_deleted_successfully_from_the_list() {
        // Write code here that turns the phrase above into concrete actions
        List<Product> productList;
        productList = CategoryList.getProduct();
        boolean typeExists = false;
        for (Product product : CategoryList.getProduct()) {
            if (product.getType().equals(cName)) {

                Product.removeProductByType(productList, cName);
                LOGGER.info("\u001B[32m The Category Deleted Successfully.\u001B[0m");
                Product.viewProducts(productList);
                typeExists=true;
                assertTrue(typeExists);
                break;
            }
            else{
                if(!typeExists)
                    LOGGER.info("\u001B[35mThe Category Doesn't Exists\u001B[0m");

            }

        }}


    @Then("The category is failed to delete")
    public void the_category_is_failed_to_delete() {
        // Write code here that turns the phrase above into concrete actions
        List<Product> productList;
        productList = CategoryList.getProduct();
        boolean typeExists = false;
        for (Product product : CategoryList.getProduct()) {
            if (product.getType().equals(cName)) {

                Product.removeProductByType(productList, cName);
                LOGGER.info("\u001B[32m The Category Deleted Successfully.\u001B[0m");
                Product.viewProducts(productList);
                typeExists=true;
                break;
            }
            else{
                if(!typeExists)
                    LOGGER.info("\u001B[35mThe Category Doesn't Exists\u001B[0m");
                assertFalse(typeExists);

            }

        }
    }

    /////////
    @When("usernum {string}")
    public void usernum(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.unum= Integer.parseInt(string);
    }
    @When("the username is {string}")
    public void the_username_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.username=string;
    }

    @When("the location is {string}")
    public void the_location_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.loc=string;
    }

    @When("the phonenumber is {string}")
    public void the_phonenumber_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.phnum=string;
    }



    @Then("The User information will be Updated successfully")
    public void the_user_information_will_be_updated_successfully() {
        // Write code here that turns the phrase above into concrete actions
        List<User> userList;
        userList = Userslist.getUsers();
        User.updateUserByNum(userList,unum,username,loc,phnum);
        assertTrue(User.getIsUserUpdated());
    }






    @Then("The Account deleted successfully")
    public void the_account_deleted_successfully() {
        // Write code here that turns the phrase above into concrete actions
        List<User> userList;
        userList = Userslist.getUsers();
        User.removeUserByNum(userList,unum);
        assertTrue(User.isUserDeleted());
    }
    @When("The customer enter the name of product is {string}")
    public void the_customer_enter_the_name_of_product_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.pr=string;
    }

    @Then("print all details about this product")
    public void print_all_details_about_this_product() {
        // Write code here that turns the phrase above into concrete actions
        List<Product> productList;
        productList = CategoryList.getProduct();
        boolean isExisted = false;
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (product.getName().equalsIgnoreCase(pr)) {
                isExisted = true;
                assertTrue(isExisted);
                String productInfo = "\u001b[35m" + i + ". " + product.getType() + " , " + product.getName() +
                        " , " + product.getDescription() + " , " + product.getImage() +
                        " , " + product.getPrice() + " $ " + " , " + product.isAvailability() + "\u001b[0m";
                LOGGER.info("\u001B[35m" + productInfo + "\u001B[0m");

                isExisted = true;
            }
        }}



    @When("The customer enter the name of Category {string}")
    public void the_customer_enter_the_name_of_category(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.cat=string;
    }

    @Then("print all products that have the same category")
    public void print_all_products_that_have_the_same_category() {
        // Write code here that turns the phrase above into concrete actions
        List<Product> productList;
        productList = CategoryList.getProduct();
        boolean isExisted = false;
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (product.getType().equalsIgnoreCase(cat)) {
                isExisted = true;
                assertTrue(isExisted);
                String productInfo = "\u001b[35m" + i + ". " + product.getType() + " , " + product.getName() +
                        " , " + product.getDescription() + " , " + product.getImage() +
                        " , " + product.getPrice() + " $ " + " , " + product.isAvailability() + "\u001b[0m";
                LOGGER.info("\u001B[35m" + productInfo + "\u001B[0m");

                isExisted = true;
            }
        }
    }
}
