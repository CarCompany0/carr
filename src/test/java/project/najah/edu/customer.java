package project.najah.edu;

import car.database.InstallationRequestsList;
import car.database.Userslist;
import car.database.category_list;
import car.database.installationDatesList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class customer {
    private static final String passRange = "\\d{5,}";

    private static final Logger LOGGER = Logger.getLogger(customer.class.getName());

    LoginSteps loginsteps;
    Customer customer;

    public customer(LoginSteps loginsteps) {
        this.loginsteps =loginsteps;
    }

    private  String selectProduct;
    private int selectProduct2;
private String pname;
    private  String email;
    private  String select;
    private  int selectedDateIndex;

    private  String password;
    private  String location ;
    private  String username;
    private  String phoneNum;
    private int  quantity;
    private String curente;
    private String pass;
    private boolean available;
    @Given("the user is customer")
    public void the_user_is_customer() {
        loginsteps.login();
        assertTrue(loginsteps.isCustomerIsLogged());

    }

    @When("The customer enters product number {string}")
    public void the_customer_enters_product_number(String string) {

    this.selectProduct2=Integer.parseInt(string);
    }
    @When("The customer enters product name {string}")
    public void the_customer_enters_product_name(String string) {

        this.selectProduct=string;
    }
    @When("the customer  enters {string} of the quantity of that accessories")
    public void the_customer_enters_of_the_quantity_of_that_accessories(String string) {
        // Write code here that turns the phrase above into concrete actions
     this.quantity=Integer.parseInt(string);
    }

    @When("the Availabelity is {string}")
    public void the_availabelity_is(String string) {
        // Write code here that turns the phrase above into concrete actions
      this.available=Boolean.parseBoolean(string);
    }
    @When("the  customer  email {string}")
    public void the_customer_email(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.curente=string;
    }
    @When("the  customer  pass {string}")
    public void the_customer_pass(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.pass=string;
    }
    @When("the new customer  username {string}")
    public void the_new_customer_username(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.username=string;
    }
    @When("the new customer  email {string}")
    public void the_new_customer_email(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.email=string;
    }
    @When("the new customer  password {string}")
    public void the_new_customer_password(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.password=string;
    }
    @When("the new customer  location {string}")
    public void the_new_customer_location(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.location=string;
    }
    @When("the new customer  phonenumber {string}")
    public void the_new_customer_phonenumber(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.phoneNum=string;
    }

    @Then("the Customer buys it succsesfully")
    public void the_customer_buys_it_succsesfully() {
        List<Product> product1;
        product1 = category_list.getProduct();
        boolean isBouught=false;
        int selectedProductIndex = selectProduct2 - 1;
        Customer.Sss orderl = new Customer.Sss();
        List<Customer.Order> orderList = orderl.getOrderList();

        // Create an instance of Customer
        Customer cus = new Customer(null,null,null,null);

        if (selectedProductIndex >= 0 && selectedProductIndex < product1.size()) {

            Product selectedProduct = product1.get(selectedProductIndex);
     if(available==false){
         isBouught=false;
         LOGGER.info("\u001b[35mThe Product Out Of Stock\u001b[0m");
     } else{


         LOGGER.info("\u001b[35mYou have selected: \u001b[35m" + quantity + "\u001b[35m of \u001b[35m" + selectedProduct.getName() + " " + selectedProduct.getPrice() +"$"+ "\u001b[0m");

         Customer.Order newOrder = new Customer.Order(selectedProduct, quantity);
         cus.oL.addOrder(newOrder);
         isBouught=true;
         LOGGER.info("\u001b[35mOrder Added Successfully To Cart \u001b[0m"); //+ User.getUsername()

     }
     assertTrue(isBouught);
     }
    }


    @Then("the customer will not buy it")
    public void the_customer_will_not_buy_it() {
        // Write code here that turns the phrase above into concrete actions

        List<Product> product1;
        product1 = category_list.getProduct();
        boolean isBouught=false;
        int selectedProductIndex = selectProduct2 - 1;
        Customer.Sss orderl = new Customer.Sss();
        List<Customer.Order> orderList = orderl.getOrderList();

        // Create an instance of Customer
        Customer cus = new Customer(null,null,null,null);

        if (selectedProductIndex >= 0 && selectedProductIndex < product1.size()) {

            Product selectedProduct = product1.get(selectedProductIndex);
            if(available==false){
                isBouught=false;
                LOGGER.info("\u001b[35mThe Product Out Of Stock\u001b[0m");
            } else{


                LOGGER.info("\u001b[35mYou have selected: \u001b[35m" + quantity + "\u001b[35m of \u001b[35m" + selectedProduct.getName() + " " + selectedProduct.getPrice() +"$"+ "\u001b[0m");

                Customer.Order newOrder = new Customer.Order(selectedProduct, quantity);
                cus.oL.addOrder(newOrder);
                isBouught=true;
                LOGGER.info("\u001b[35mOrder Added Successfully To Cart \u001b[0m"); //+ User.getUsername()

            }
            assertFalse(isBouught);
        }
    }

    @Then("show a message why he can not buy it")
    public void show_a_message_why_he_can_not_buy_it() {
        // Write code here that turns the phrase above into concrete actions
        assertFalse(available);
        LOGGER.info("\u001b[35mThe Product Out Of Stock\u001b[0m");


    }

    @When("The customer choose {string}")
    public void the_customer_choose(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.select=string;

    }

    @Then("show the history of his orders")
    public void show_the_history_of_his_orders() {
        // Write code here that turns the phrase above into concrete actions
        Customer.displayOrders();

        assertTrue(Customer.isViewed());
    }
    @When("The customer enter the name of product {string}")
    public void the_customer_enter_the_name_of_product(String string) {
        // Write code here that turns the phrase above into concrete actions

        this.pname=string;
    }
    @Then("print all information about this product")
    public void print_all_information_about_this_product() {
        // Write code here that turns the phrase above into concrete actions
        List<Product> product1;
        product1 = category_list.getProduct();
        for (int i = 0; i < product1.size(); i++) {
            Product product = product1.get(i);
            if (product.getName().equalsIgnoreCase(pname)) {
                String productInfo = "\u001b[35m"+i + ". " + product.getType() + " , " + product.getName() +
                        " , " + product.getDescription() + " , " + product.getImage() +
                        " , " + product.getPrice() + " $ " + " , " + product.isAvailability()+"\u001b[0m";
                LOGGER.info("\u001B[35m" + productInfo + "\u001B[0m");

            }
        }

    }

    @Then("show the product list")
    public void show_the_product_list() {
        // Write code here that turns the phrase above into concrete actions
        List<Product> product11;
        product11 = category_list.getProduct();

        Product.viewProducts(product11);

    }






    @Then("The information Succsesfully")
    public void the_information_succsesfully() {
        LoginSteps.checkAuth(email, pass);

        User currentUser = null;
        for (User user : Userslist.getUsers()) {
            if (user.getEmail().equals(email)) {
                currentUser = user;
                break;
            }
        }

        if (currentUser != null) {

            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || location.isEmpty() || phoneNum.isEmpty()) {
                ErrorMsg.showError4();
            }

            if (!User.isValidEmail(email)) {
                LOGGER.info("\u001B[34mInvalid email format. Please enter a valid email address.\u001B[0m");
            }  else {
                boolean emailExists = false;

                for (User user : Userslist.getUsers()) {
                    if (!user.getEmail().equals(curente) && user.getEmail().equals(email)) {
                        LOGGER.info("\u001B[34mEmail already exists. Choose a different email.\u001B[0m");
                        emailExists = true;
                        break;
                    }
                }

                if (password != null && password.matches(passRange)) {
                    if (!emailExists) {
                        currentUser.setUsername(username);
                        currentUser.setEmail(email);
                        currentUser.setPassword(password);
                        currentUser.setLocation(location);
                        currentUser.setPhoneNum(phoneNum);
                        currentUser.setType("Customer");
                        LOGGER.info("\u001B[32minformation Updated Successfully..\u001B[0m");
                        User.printUserInfo(currentUser);
                    }
                } else {
                    ErrorMsg.passWarning();
                }
            }
        } else {
            LOGGER.warning("\u001B[34mUser not found.\u001B[0m");
        }

    }



    @Then("The information failed to update")
    public void the_information_failed_to_update() {
        // Write code here that turns the phrase above into concrete actions
        LoginSteps.checkAuth(email, pass);

        User currentUser = null;
        for (User user : Userslist.getUsers()) {
            if (user.getEmail().equals(email)) {
                currentUser = user;
                break;
            }
        }

        if (currentUser != null) {

            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || location.isEmpty() || phoneNum.isEmpty()) {
                ErrorMsg.showError4();
            }

            else if (!User.isValidEmail(email)) {
                LOGGER.info("\u001B[34mInvalid email format. Please enter a valid email address.\u001B[0m");
            }  else {
                boolean emailExists = false;

                for (User user : Userslist.getUsers()) {
                    if (!user.getEmail().equals(curente) && user.getEmail().equals(email)) {
ErrorMsg.showError3();
emailExists = true;
                        break;
                    }
                }

                if (password != null && password.matches(passRange)) {
                    if (!emailExists) {
                        currentUser.setUsername(username);
                        currentUser.setEmail(email);
                        currentUser.setPassword(password);
                        currentUser.setLocation(location);
                        currentUser.setPhoneNum(phoneNum);
                        currentUser.setType("Customer");
                        LOGGER.info("\u001B[32minformation Updated Successfully..\u001B[0m");
                        User.printUserInfo(currentUser);
                    }
                } else {
                    ErrorMsg.passWarning();
                }
            }
        } else {
            LOGGER.warning("\u001B[34mUser not found.\u001B[0m");
        }}


    @Given("the installer date {string}")
    public void the_installer_date(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.selectedDateIndex = Integer.parseInt(string) - 1;
        List<InstallerDates> inss;
        inss = installationDatesList.getInstaller();
        InstallerDates.viewDates(inss);
        }
    @Then("The installation will be requested")
    public void the_installation_will_be_requested() {
        boolean isRequsted=false;
        List<InstallerDates> inss;
        inss = installationDatesList.getInstaller();

        List<Product> product1;
        product1 = category_list.getProduct();

        List<InstallationRequest> req1;
        req1 = InstallationRequestsList.getRequest();


        // Check if the requested product exists in the product list
        boolean productExists = false;
        for (Product product : product1) {
            if (product.getName().equalsIgnoreCase(selectProduct)) {
                productExists = true;
                break;
            }
        }
        if (!productExists) {
            isRequsted=false;
            LOGGER.warning("\u001B[31mThe specified product does not exist in the product list.\u001B[0m");
            return;
        }
        LoginSteps.checkAuth(curente, pass);
        if (LoginSteps.isCustomerIsLogged()){
        User currentUser = null;
        for (User user : Userslist.getUsers()) {
            if (user.getEmail().equals(curente)) {
                currentUser = user;
                break;
            }}

            if (currentUser != null) {
        if (selectedDateIndex >= 0 && selectedDateIndex < inss.size()) {
            InstallerDates selectedInstallerDate = inss.get(selectedDateIndex);

            InstallationRequest newRequest = new InstallationRequest(selectedInstallerDate.getDay(), selectedInstallerDate.getMonth(),
                    selectedInstallerDate.getYear(), selectedInstallerDate.getHour(), selectedInstallerDate.getInstallerName(),
                    selectProduct, currentUser.getUsername(), currentUser.getLocation(), currentUser.getPhoneNum());
            req1.add(newRequest);
            isRequsted = true;
            LOGGER.info("\u001B[32mInstallation request added successfully.\u001B[0m");
            assertTrue(isRequsted);
        }
            }
            }

        }

}




