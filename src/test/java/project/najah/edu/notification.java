package project.najah.edu;

import car.database.InstallationRequestsList;
import car.database.Userslist;
import car.database.CategoryList;
import car.database.InstallationDatesList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;
public class  notification {
    private static final Logger LOGGER = Logger.getLogger(customer.class.getName());

    LoginSteps loginsteps;
    private String pductname;
    private int selectedDateIndex3;
    private String email5;
    private String password5;

    private int selected3;
    private boolean available2;
    private int qua;
    public notification(LoginSteps loginsteps) {
        this.loginsteps =loginsteps;
    }
    @Given("the user is a customer")
    public void theUserIsACustomer() {
        // Write code here that turns the phrase above into concrete actions
        loginsteps.login();
        assertTrue(LoginSteps.isCustomerIsLogged());

    }
    @Given("the user is in Browse  Products Page")
    public void theUserIsInBrowseProductsPage() {
        // Write code here that turns the phrase above into concrete actions
        List<Product> product1;
        product1 = CategoryList.getProduct();
        Product.viewProducts(product1);
    }
    @Given("the user has placed an order of product {string}")
    public void theUserHasPlacedAnOrderOfProduct(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.selected3=Integer.parseInt(string);

    }
    @Given("the quantity {string}")
    public void the_quantity(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.qua=Integer.parseInt(string);
    }
    @Given("the availabelity is {string}")
    public void the_availabelity_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.available2=Boolean.parseBoolean(string);
    }
    @When("The customer enters product name is {string}")
    public void theCustomerEntersProductNameIs(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.pductname=string;
    }
    @Then("an email is to be sent to {string}")
    public void anEmailIsToBeSentTo(String string) {
        List<Product> product1;
        product1 = CategoryList.getProduct();
        boolean isBouught=false;
        int selectedProductIndex = selected3 - 1;
        Customer.Sss orderl = new Customer.Sss();
        List<Customer.Order> orderList = orderl.getOrderList();

        // Create an instance of Customer
        Customer cus = new Customer(null,null,null,null);

        if (selectedProductIndex >= 0 && selectedProductIndex < product1.size()) {

            Product selectedProduct = product1.get(selectedProductIndex);
            if(available2==false){
                isBouught=false;
                LOGGER.info("\u001b[35mThe Product Out Of Stock\u001b[0m");
            } else{


                LOGGER.info("\u001b[35mYou have selected: \u001b[35m" + qua + "\u001b[35m of \u001b[35m" + selectedProduct.getName() + " " + selectedProduct.getPrice() +"$"+ "\u001b[0m");

                Customer.Order newOrder = new Customer.Order(selectedProduct, qua);
                Customer customer=new Customer(null,null,null,null);
                cus.oL.addOrder(newOrder);
                isBouught=true;
                LOGGER.info("\u001b[35mOrder Added Successfully To Cart \u001b[0m"); //+ User.getUsername()
                newOrder.sendOrderConfirmationEmail(selectedProduct.getName(),qua,newOrder.getTotalPrice());
            }

        }

    }

    @When("the  customer  current email is {string}")
    public void the_customer_current_email_is(String string) {
        // Write code here that turns the phrase above into concrete actions
this.email5=string;
    }
    @When("the  customer  password is {string}")
    public void the_customer_password_is(String string) {
        // Write code here that turns the phrase above into concrete actions
this.password5=string;
    }
    @When("the installer date is {string}")
    public void theInstallerDateIs(String string) {
        // Write code here that turns the phrase above into concrete actions
this.selectedDateIndex3=Integer.parseInt(string);
    }

    @Then("an email will be sent to {string}")
    public void anEmailWillBeSentTo(String string) {
        // Write code here that turns the phrase above into concrete actions
        boolean isRequsted = false;
        User currentUser1 = null;
        List<InstallationRequest> req1;
        req1 = InstallationRequestsList.getRequest();

        List<Product> p1;

        p1 = CategoryList.getProduct();

        for (User user : Userslist.getUsers()) {
            if (user.getEmail().equals(email5)) {
                currentUser1 = user;
                break;
            }
        }

            String customerName = currentUser1.getUsername();
            String customerLocation = currentUser1.getLocation();
            String customerPhoneNum = currentUser1.getPhoneNum();

            List<InstallerDates> inss;
            inss = InstallationDatesList.getInstaller();
            List<Product> product11;
            product11 = CategoryList.getProduct();

            Product.viewProducts(product11);

            // Check if the requested product exists in the product list
            boolean productExists = false;
            for (Product product : p1) {
                if (product.getName().equalsIgnoreCase(pductname)) {
                    productExists = true;
                    break;
                }
            }
            if (!productExists) {
                isRequsted = false;
                LOGGER.warning("\u001B[34mThe specified product does not exist in the product list.\u001B[0m");
                return;
            }

            else if (selectedDateIndex3 >= 0 && selectedDateIndex3 < inss.size()) {
                InstallerDates selectedInstallerDate = inss.get(selectedDateIndex3);
                // Create and add the installation request
                InstallationRequest newRequest = new InstallationRequest(selectedInstallerDate.getDay(), selectedInstallerDate.getMonth(),
                        selectedInstallerDate.getYear(), selectedInstallerDate.getHour(), selectedInstallerDate.getInstallerName(), pductname, customerName, customerLocation, customerPhoneNum);
                req1.add(newRequest);

                isRequsted = true;
                LOGGER.info("\u001B[32mInstallation request added successfully.\u001B[0m");
                InstallationRequest.sendEmailNotification();

            } else LOGGER.warning("\u001B[34mInvalid Date index \u001B[0m");

    }
    }



