package project.najah.edu;

import car.database.InstallationRequestsList;
import car.database.Userslist;
import car.database.CategoryList;
import car.database.InstallationDatesList;
import org.example.*;

import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
public class Main {
    private static final PrintWriter writer = new PrintWriter(System.out, true);
    public static void println(String message) {print(message);}
    private static void print(String output) {writer.println(output);}
    private static final String RESET = "\u001B[0m";
    private static final String SET =  "\u001B[35m";
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final Scanner scan = new Scanner(System.in);
    private static final LoginSteps loginSteps = new LoginSteps();
    private static boolean isExisted = false;
    private static boolean  isRequsted=false;

    private static final String LINE = "\u001b[35m--------------------------------------------\u001b[0m";
    private static void line() {
        LOGGER.info(Main.LINE);
    }
    private static final String passRange = "\\d{5,}";
    private static void mail(){LOGGER.info("\u001b[35mEnter your email:\u001b[0m");}
    private static void pass(){LOGGER.info("\u001b[35mEnter Password:\u001b[0m");}
    public static void main(String[] args) {

        while (true) {
           Menu.start();
            int inputt = scan.nextInt();

            if (inputt == 1) {
                line();
                mail();
                String email = scan.next();
                pass();
                String password = scan.next();
                LoginSteps.checkAuth(email, password);
                if (email.isEmpty() || password.isEmpty()) {
                    ErrorMsg.showError2();
                }
                int selectProduct;
                if (!loginSteps.isAdminIsLogged() && !LoginSteps.isCustomerIsLogged() && !loginSteps.isInstallerIsLogged()) {
                    ErrorMsg.showError();

                }
                else if (loginSteps.isAdminIsLogged()) {
                    while (true) {
                       Menu.admin1();
                        int in = scan.nextInt();
                        if (in == 1) {
                            boolean exitOuterLoop = false;

                            while (!exitOuterLoop) {
                                Menu.admin11();
                                int inp = scan.nextInt();
                                List<Product> productList;
                                switch (inp) {

                                    case 1:

                                        while (true) {
                                            productList = CategoryList.getProduct();
                                            Menu.productlist();

                                            try {
                                                if (scan.hasNextInt()) {
                                                    selectProduct = scan.nextInt();

                                                    // Check if selectProduct is within a valid range
                                                    if (selectProduct >= 1 && selectProduct <= productList.size() + 1) {
                                                        // Check if selectProduct matches the exit condition
                                                        if (selectProduct == Product.getNumProduct()) {
                                                            break;
                                                        } else {
                                                            // Inner loop to manage products
                                                            boolean exitInnerLoop = false;

                                                            while (!exitInnerLoop) {
                                                                Menu.manageProducts();
                                                                int inp1 = scan.nextInt();

                                                                switch (inp1) {
                                                                    case 1:

                                                                        LOGGER.info(LINE);


                                                                        LOGGER.info("\u001b[35mEnter new type:\u001b[0m");
                                                                        String type = scan.next();

                                                                        LOGGER.info("\u001b[35mEnter new product name:\u001b[0m");
                                                                        String pname2 = scan.next();

                                                                        LOGGER.info("\u001b[35mEnter new description:\u001b[0m");
                                                                        String des = scan.next();

                                                                        LOGGER.info("\u001b[35mEnter new image URL:\u001b[0m");
                                                                        String url = scan.next();

                                                                        LOGGER.info("\u001b[35mEnter new price:\u001b[0m");
                                                                        String price = scan.next();

                                                                        LOGGER.info("\u001b[35mIs it available? (true/false):\u001b[0m");
                                                                        String ava = scan.next();

                                                                        if (type.isEmpty() || pname2.isEmpty() || des.isEmpty() || url.isEmpty() || price.isEmpty() || ava.isEmpty()) {
                                                                            ErrorMsg.showError4();
                                                                        }
                                                                        boolean av = Boolean.parseBoolean(ava);
                                                                        Product product3= new Product(type, pname2, des, url, price, av);
                                                                        if (product3 != null) {
                                                                            Product.updateProductByNum(productList, selectProduct, product3);

                                                                        } else {
                                                                            ErrorMsg.showError4();
                                                                        }
                                                                        exitInnerLoop = true;
                                                                        break;
                                                                    case 2:

                                                                        Product.removeProductByNum(productList, selectProduct);
                                                                        exitInnerLoop = true;
                                                                        break;
                                                                    case 3:
                                                                        exitInnerLoop = true; // Exit the inner loop
                                                                        break;
                                                                    default:
                                                                       ErrorMsg.showWarning();
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        LOGGER.warning("\u001B[34mInvalid product index \u001B[0m");
                                                    }
                                                } else {
                                                    // Consume the invalid input to avoid an infinite loop
                                                    scan.next();
                                                    // Handle the case when a non-integer is provided
                                                    LOGGER.warning("\u001B[34mPlease enter a valid integer.\u001B[0m");
                                                }
                                            } catch (InputMismatchException e) {
                                                // Consume the invalid input to avoid an infinite loop
                                                scan.next();
                                                // Handle the exception
                                                LOGGER.warning("Input mismatch. Please enter a valid integer.");
                                            }
                                        }
                                        break;
                                    case 2:
                                        List<Product> productList1;
                                        productList1 = CategoryList.getProduct();

                                        LOGGER.info(LINE);
                                        LOGGER.info("\u001b[35mEnter Categry:\u001b[0m");
                                        String cat = scan.next();

                                        LOGGER.info("\u001b[35mEnter Product Name:\u001b[0m");
                                        String namee = scan.next();

                                        LOGGER.info("\u001b[35mEnter Description:\u001b[0m");
                                        String dess = scan.next();

                                        LOGGER.info("\u001b[35mEnter Image:\u001b[0m");
                                        String imgg = scan.next();

                                        LOGGER.info("\u001b[35mEnter Price:\u001b[0m");
                                        String pr = scan.next();

                                        LOGGER.info("\u001b[35mIs it available? (true/false):\u001b[0m");
                                        String avv = scan.next();

                                        if (cat.isEmpty() || namee.isEmpty() || dess.isEmpty() || imgg.isEmpty() || pr.isEmpty() || avv.isEmpty()) {
                                            ErrorMsg.showError4();
                                        }
                                        // Call the updateUserByNum method with the desired user number and new information
                                        Product.addProduct(productList1, cat,namee,dess,imgg,pr,avv);
                                        Product.viewProducts(productList1);
                                        // Display the updated user list
                                        break;
                                    case 3:

                                        List<Product> product1;
                                        product1 = CategoryList.getProduct();

                                        Menu.searchList();
                                        String select = scan.next();

                                        if (select.equals("1")) {
                                            LOGGER.info("\u001b[35mEnter the product name:\u001b[0m");
                                            String pname = scan.next();

                                            boolean isExisted = false;
                                            for (int i = 0; i < product1.size(); i++) {
                                                Product product = product1.get(i);
                                                if (product.getName().equalsIgnoreCase(pname)) {
                                                    String productInfo = "\u001b[35m" + i + ". " + product.getType() + " , " + product.getName() +
                                                            " , " + product.getDescription() + " , " + product.getImage() +
                                                            " , " + product.getPrice() + " $ " + " , " + product.isAvailability() + "\u001b[0m";
                                                    println(SET + productInfo + RESET);

                                                    isExisted = true;
                                                    // Ask if the user wants to buy the product
                                                    Menu.manageProducts();
                                                    String choose = scan.next();

                                                    // Process the user's decision
                                                    switch (choose) {
                                                        case "1":
                                                            // Pass the index of the selected product to the PlaceOrder method
                                                            List<Product> productList4 = CategoryList.getProduct();
                                                            LOGGER.info(LINE);

                                                            LOGGER.info("\u001b[35mEnter new type:\u001b[0m");
                                                            String type = scan.next();

                                                            LOGGER.info("\u001b[35mEnter new product name:\u001b[0m");
                                                            String pname2 = scan.next();

                                                            LOGGER.info("\u001b[35mEnter new description:\u001b[0m");
                                                            String des = scan.next();

                                                            LOGGER.info("\u001b[35mEnter new image URL:\u001b[0m");
                                                            String url = scan.next();

                                                            LOGGER.info("\u001b[35mEnter new price:\u001b[0m");
                                                            String price = scan.next();

                                                            LOGGER.info("\u001b[35mIs it available? (true/false):\u001b[0m");
                                                            String ava = scan.next();

                                                            if (type.isEmpty() || pname2.isEmpty() || des.isEmpty() || url.isEmpty() || price.isEmpty() || ava.isEmpty()) {
                                                               ErrorMsg.showError4();
                                                            }
                                                            boolean av = Boolean.parseBoolean(ava);
                                                            Product product3= new Product(type, pname2, des, url, price, av);
                                                            if (product3 != null) {
                                                                Product.updateProductByName(productList4, pname2, product3);

                                                            } else {
                                                                ErrorMsg.showError4();
                                                            }
                                                            break;

                                                        case "2":
                                                            Product.removeProductByName(product1, product.getName());
                                                            break;

                                                        case "3":
                                                            // No action needed for option 3
                                                            break;

                                                        default:
                                                            ErrorMsg.showWarning();
                                                            break;
                                                    }
                                                    // Break out of the loop since the product is found
                                                }
                                            }
                                            if (!isExisted) {
                                                LOGGER.info("\u001b[34mProduct not found. Please check the product name and try again.\u001b[0m");
                                            }
                                        }
                                        else if (select.equals("2")) {
                                            LOGGER.info("\u001b[35mEnter the product Category:\u001b[0m");
                                            String searchProductType = scan.next();
                                            boolean isExisted2 = false;

                                            // Display all products of the specified category
                                            for (int i = 1; i < product1.size(); i++) {
                                                Product product = product1.get(i);
                                                if (product.getType().equalsIgnoreCase(searchProductType)) {
                                                    String productInfo = "\u001b[35m" + i + ". " + product.getType() + " , " + product.getName() +
                                                            " , " + product.getDescription() + " , " + product.getImage() +
                                                            " , " + product.getPrice() + " $ " + " , " + product.isAvailability() + "\u001b[0m";
                                                    println(SET+ productInfo +RESET);
                                                    isExisted2 = true;
                                                }
                                            }
                                            if (isExisted2) {
                                                LOGGER.info("\u001b[35m Do You Want to Delete Category (yes/no): \u001b[0m");
                                                String choose = scan.next();

                                                if (choose.equalsIgnoreCase("yes")) {
                                                    Product.removeProductByType(product1, searchProductType);
                                                } else if (choose.equalsIgnoreCase("no")) {
                                                    LOGGER.info("\u001b[34mMaybe next time. Have a great day!\u001b[0m");
                                                } else {
                                                    ErrorMsg.showWarning();
                                                }
                                            } else {
                                                LOGGER.info("\u001b[34mCategory not found. Please check the Category name and try again.\u001b[0m");
                                            }
                                        }

                                        else if (select.equals("3")){
                                            break;
                                        }
                                        else
                                            ErrorMsg.showWarning();

                                        break;
                                    case 4:
                                        productList = CategoryList.getProduct();

                                        line();

                                        LOGGER.info("\u001b[35mEnter Category Name:\u001b[0m");
                                        String typee = scan.next();
                                        boolean typeExists = false;
                                        for (Product product : CategoryList.getProduct()) {
                                            if (product.getType().equals(typee)) {
                                                Product.removeProductByType(productList, typee);
                                                Product.viewProducts(productList);
                                                typeExists = true;
                                                break;
                                            }
                                        }
                                        if (!typeExists) {
                                            LOGGER.info("\u001B[34mThe Category Doesn't Exists\u001B[0m");
                                        }
                                        break;
                                    case 5:
                                        exitOuterLoop = true; // Exit the outer loop
                                        break;
                                    default:
                                        ErrorMsg.showWarning();
                                }
                            }

                        }
                        else if (in == 2) {
                            while (true) {
                                List<User> users1;
                                users1 = Userslist.getUsers();
                                LOGGER.info("\u001B[35m--------- Select account To Update Or Delete ---------\u001B[0m");
                                User.viewAccounts(users1);
                                String s = "\u001B[35m"+User.getNumUser() + "\u001b[35m- Go Back.\u001b[0m";
                                LOGGER.info(s);
                                LOGGER.info("\u001b[35m------------------------------------------------------\u001b[0m");
                                int selectAccount = scan.nextInt();
                                if(selectAccount > users1.size()+1)
                                    LOGGER.warning("\u001B[34mInvalid User index \u001B[0m" );

                                else if (selectAccount == User.getNumUser()) {
                                    break;
                                }
                                  else {
                                    boolean exitOuterLoop = false;

                                    while (!exitOuterLoop) {
                                        Menu.manageProducts();
                                        int in2 = scan.nextInt();

                                        switch (in2) {
                                            case 1:
                                                List<User> userList;
                                                userList = Userslist.getUsers();

                                                LOGGER.info(LINE);

                                                LOGGER.info("\u001b[35mEnter new username :\u001b[0m");
                                                String username = scan.next();

                                                LOGGER.info("\u001b[35mEnter new location:\u001b[0m");
                                                String location = scan.next();

                                                LOGGER.info("\u001b[35mEnter new phone Number:\u001b[0m");
                                                String phoneNum = scan.next();

                                                if (username.isEmpty() || location.isEmpty() || phoneNum.isEmpty()) {
                                                    ErrorMsg.showError2();
                                                }

                                                // Call the updateUserByNum method with the desired user number and new information
                                                User.updateUserByNum(userList, selectAccount, username, location, phoneNum);

                                                // Display the updated user list
                                                exitOuterLoop = true;
                                                break;

                                            case 2:
                                                List<User> userList2;
                                                userList2 = Userslist.getUsers();
                                                User.removeUserByNum(userList2, selectAccount);
                                                exitOuterLoop = true;
                                                break;

                                            default:
                                                ErrorMsg.showWarning();
                                                break;
                                        }
                                    }

                                }}
                        }
                        else break;
                        }
                } else if (LoginSteps.isCustomerIsLogged()) {

                    while (true) {
                        Menu.customer1();
                        String open = scan.next();
                        List<Product> p1;
                        switch (open) {
                            case "1":
                                while (true) {
                                    List<Product> product1;
                                    product1 = CategoryList.getProduct();

                                    LOGGER.info("\u001B[35m--------- Select Product and Quantity To Buy  ---------\u001B[0m");
                                    Product.viewProducts(product1);

                                    String s = "\u001B[35m" + Product.getNumProduct() + "\u001B[35m- Go Back.\u001B[0m";
                                    LOGGER.info(s);

                                    LOGGER.info("\u001b[35m------------------------------------------------------\u001b[0m");
                                    selectProduct = scan.nextInt();
                                    int prductnum2 = selectProduct;

                                    if (prductnum2 > product1.size() + 1) {
                                        LOGGER.warning("\u001B[34mInvalid product index \u001B[0m");
                                    } else if (prductnum2 == Product.getNumProduct()) {
                                        break;
                                    } else {
                                        int selectedProductIndex = selectProduct - 1;

                                        if (selectedProductIndex >= 0 && selectedProductIndex < product1.size()) {
                                            Product selectedProduct = product1.get(selectedProductIndex);

                                            if (selectedProduct.isAvailability()) {
                                                LOGGER.info("\u001b[35mQuantity:\u001b[0m");
                                                int quantity = scan.nextInt();

                                                println("\u001b[35mYou have selected: \u001b[35m" + quantity + "\u001b[35m of \u001b[35m" +
                                                        selectedProduct.getName() + " " + selectedProduct.getPrice() + "$" + "\u001b[0m");


                                                // Add the order to the customer's order list
                                                Customer.Order newOrder = new Customer.Order(selectedProduct, quantity);
                                                Customer.oL.addOrder(newOrder);

                                                LOGGER.info("\u001b[35mOrder Added Successfully To Cart \u001b[0m");

                                                // Send order confirmation email
                                               newOrder.sendOrderConfirmationEmail(selectedProduct.getName(), quantity, newOrder.getTotalPrice());
                                            } else {
                                                LOGGER.info("\u001b[34mThe Product Out Of Stock\u001b[0m");
                                            }
                                        }
                                    }
                                }
                                break;

                            case "2":

                                p1 = CategoryList.getProduct();
                                List<Product> product1;
                                product1 = CategoryList.getProduct();


                                LOGGER.info("\u001b[35mEnter the product name:\u001b[0m");
                                String pname = scan.next();

                                for (int i = 1; i < p1.size(); i++) {
                                    Product product = p1.get(i);
                                    if (product.getName().equalsIgnoreCase(pname)) {
                                        String productInfo = "\u001b[35m"+i + ". " + product.getType() + " , " + product.getName() +
                                                " , " + product.getDescription() + " , " + product.getImage() +
                                                " , " + product.getPrice() + " $ " + " , " + product.isAvailability()+"\u001b[0m";
                                        println("\u001B[35m" + productInfo + RESET);
                                        isExisted=true;


                                        // Ask if the user wants to buy the product
                                        LOGGER.info("\u001b[35mDo you want to buy it? (yes/no): \u001b[0m");
                                        String buyDecision = scan.next();

                                        // Process the user's decision
                                        switch (buyDecision.toLowerCase()) {
                                            case "yes":
                                                // Pass the index of the selected product to the PlaceOrder method
                                                if (i >= 0 && i < product1.size()) {
                                                    Product selectedProduct = product1.get(i);

                                                    if (selectedProduct.isAvailability()) {
                                                        LOGGER.info("\u001b[35mQuantity:\u001b[0m");
                                                        int quantity = scan.nextInt();

                                                        println("\u001b[35mYou have selected: \u001b[35m" + quantity + "\u001b[35m of \u001b[35m" +
                                                                selectedProduct.getName() + " " + selectedProduct.getPrice() + "$" + "\u001b[0m");


                                                        // Add the order to the customer's order list
                                                        Customer.Order newOrder = new Customer.Order(selectedProduct, quantity);
                                                        Customer.oL.addOrder(newOrder);

                                                        LOGGER.info("\u001b[35mOrder Added Successfully To Cart \u001b[0m");

                                                        // Send order confirmation email
                                                       newOrder.sendOrderConfirmationEmail(selectedProduct.getName(), quantity, newOrder.getTotalPrice());
                                                    } else {
                                                        LOGGER.info("\u001b[34mThe Product Out Of Stock\u001b[0m");
                                                    }
                                                }
                                                break;

                                            case "no":
                                                LOGGER.info("\u001b[34mMaybe next time. Have a great day!\u001b[0m");
                                                break;

                                            default:
                                                LOGGER.info("\u001b[34mInvalid Input. Please try again\u001b[0m");
                                                // No need for a break here since it's the last case
                                        }
                                        // Break out of the loop since the product is found
                                    }
                                }
                                if (!isExisted) {
                                    LOGGER.info("\u001b[34mProduct not found. Please check the product name and try again.\u001b[0m");
                                }
                                break;

                            case "3":
                                User currentUser1 = null;
                                List<InstallationRequest> req1;
                                req1 = InstallationRequestsList.getRequest();


                                p1 = CategoryList.getProduct();

                                for (User user : Userslist.getUsers()) {
                                    if (user.getEmail().equals(email)) {
                                        currentUser1 = user;
                                        break;
                                    }
                                }

                                if (currentUser1 != null) {
                                    String customerName = currentUser1.getUsername();
                                    String customerLocation = currentUser1.getLocation();
                                    String customerPhoneNum = currentUser1.getPhoneNum();

                                    List<InstallerDates> inss;
                                    inss = InstallationDatesList.getInstaller();
                                    List<Product> product11;
                                    product11 = CategoryList.getProduct();

                                    Product.viewProducts(product11);
                                    LOGGER.info("\u001B[33mEnter Product Name for Installation Request:\u001B[0m");

                                    String requestedProductName = scan.next();

                                    // Check if the requested product exists in the product list
                                    boolean productExists = false;
                                    for (Product product : p1) {
                                        if (product.getName().equalsIgnoreCase(requestedProductName)) {
                                            productExists = true;
                                            break;
                                        }
                                    }
                                    if (!productExists) {
                                        isRequsted=false;
                                        LOGGER.warning("\u001B[34mThe specified product does not exist in the product list.\u001B[0m");
                                        return;
                                    }

                                    InstallerDates.viewDates(inss);
                                    LOGGER.info("\u001B[33m Select preferred date:\u001B[0m");
                                    int selectedDateIndex = Integer.parseInt(scan.next()) - 1;

                                    if (selectedDateIndex >= 0 && selectedDateIndex < inss.size()) {
                                        InstallerDates selectedInstallerDate = inss.get(selectedDateIndex);
                                        // Create and add the installation request
                                        InstallationRequest newRequest = new InstallationRequest(selectedInstallerDate.getDay(), selectedInstallerDate.getMonth(),
                                                selectedInstallerDate.getYear(), selectedInstallerDate.getHour(), selectedInstallerDate.getInstallerName(), requestedProductName, customerName,customerLocation,customerPhoneNum);
                                        req1.add(newRequest);

                                        isRequsted=true;
                                        LOGGER.info("\u001B[32mInstallation request added successfully.\u001B[0m");
                                        InstallationRequest.sendEmailNotification();

                                    }
                                    else LOGGER.warning("\u001B[34mInvalid Date index \u001B[0m" );
                                }
                                break;

                            case "4":
                                Customer.displayOrders();
                                break;

                            case "5":
                                User currentUser = null;
                                for (User user : Userslist.getUsers()) {
                                    if (user.getEmail().equals(email)) {
                                        currentUser = user;
                                        break;
                                    }
                                }

                                if (currentUser != null) {
                                    LOGGER.info(LINE);

                                    LOGGER.info("\u001b[35mEnter new username :\u001b[0m");
                                    String newUsername = scan.nextLine().trim().strip();

                                    LOGGER.info("\u001b[35mEnter new email:\u001b[0m");
                                    String newEmail = scan.nextLine();

                                    LOGGER.info("\u001b[35mEnter new Password:\u001b[0m");
                                    String newPassword = scan.nextLine();

                                    LOGGER.info("\u001b[35mEnter new location:\u001b[0m");
                                    String newLocation = scan.nextLine();

                                    LOGGER.info("\u001b[35mEnter new phone Number:\u001b[0m");
                                    String newPhoneNum = scan.nextLine();

                                    if (newUsername.isEmpty() || newEmail.isEmpty() || newPassword.isEmpty() || newLocation.isEmpty() || newPhoneNum.isEmpty()) {
                                        ErrorMsg.showError2();
                                    }

                                    if (!User.isValidEmail(newEmail)) {
                                        LOGGER.info("\u001B[34mInvalid email format. Please enter a valid email address.\u001B[0m");
                                    } else {
                                        boolean emailExists = false;

                                        for (User user : Userslist.getUsers()) {
                                            if (!user.getEmail().equals(email) && user.getEmail().equals(newEmail)) {
                                                LOGGER.info("\u001B[34mEmail already exists. Choose a different email.\u001B[0m");
                                                emailExists = true;
                                                break;
                                            }
                                        }

                                        if (newPassword != null && newPassword.matches(passRange)) {
                                            if (!emailExists) {
                                                currentUser.setUsername(newUsername);
                                                currentUser.setEmail(newEmail);
                                                currentUser.setPassword(newPassword);
                                                currentUser.setLocation(newLocation);
                                                currentUser.setPhoneNum(newPhoneNum);
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
                                break;

                            case "6":
                                return; // exit the outer loop
                            default:
                                ErrorMsg.showWarning();
                                break;
                        }
                    }

                }
                else if (loginSteps.isInstallerIsLogged()) {
                    while (true) {
                        Menu.installer1();
                        int open = scan.nextInt();
                        if(open==3)
                            break;
                        else if(open==1){
                            List<InstallationRequest> requests;
                            requests = InstallationRequestsList.getRequest();
                            InstallationRequest.displayInstallationRequests(requests);
                        }
                        else if(open==2){
                            List<InstallerDates> inss;
                            inss = InstallationDatesList.getInstaller();
                            String currentUser;
                            for (User user : Userslist.getUsers()) {
                                if (user.getEmail().equals(email)) {
                                    currentUser = user.getUsername();

                                    LOGGER.info("\u001B[33m Enter New Date:\u001B[0m");
                                    LOGGER.info("\u001B[33m Day:\u001B[0m");
                                    String dayy = scan.nextLine();

                                    LOGGER.info("\u001B[33m Month:\u001B[0m");
                                    String monthh = scan.nextLine();
                                    LOGGER.info("\u001B[33m Year:\u001B[0m");
                                    String yearr = scan.nextLine();
                                    LOGGER.info("\u001B[33m Hour:\u001B[0m");
                                    String hourr = scan.nextLine();

                                    InstallerDates newDate = new InstallerDates(dayy, monthh, yearr, hourr, currentUser);
                                    // Add the new product to the productList
                                    inss.add(newDate);
                                    LOGGER.info("\u001B[32mDate Added successfully.\u001B[0m");
                                }
                            }
                            InstallerDates.viewDates(inss);
                        }
                    }
                } else break;
            }

            if (inputt == 2) {
                line();
                Menu.signup();
                int w = scan.nextInt();
                if (w == 1) {

                    line();


                    LOGGER.info("\u001b[35mEnter your username :\u001b[0m");
                        String username = scan.next().trim().strip();

                        mail();
                        String email = scan.next();

                        pass();
                        String password = scan.next();

                        LOGGER.info("\u001b[35mEnter your location:\u001b[0m");
                        String location = scan.next();

                        LOGGER.info("\u001b[35mEnter your phone Number:\u001b[0m");
                        String phoneNum = scan.next();

                        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || location.isEmpty()) {
                            ErrorMsg.showError2();
                        }
                        if (!User.isValidEmail(email)) {
                        LOGGER.info("\u001b[34m Invalid email format. Please enter a valid email address.\u001b[0m");

                        } else {
                            boolean emailExists = false;

                            for (User user : Userslist.getUsers()) {
                                if (user.getEmail().equals(email)) {
                                    LOGGER.info("\u001B[34m Email already exists. Choose a different email.\u001B[0m");
                                    emailExists = true;
                                    break;
                                }
                            }
                            if (password != null && password.matches(passRange)) {
                                // Continue with your logic when the password is valid
                                if (!emailExists) {
                                    // Proceed with the sign-up process since the email does not exist
                                    User newUser = new User(username, email, password, "Customer", location, phoneNum);
                                    Userslist.addUser(newUser);
                                    LOGGER.info("\u001B[32m Sign Up Successfully.\u001B[0m");
                                }

                            } else {
                                ErrorMsg.passWarning();

                            }
                        }}
                else if (w == 2) {
                    line();
                        LOGGER.info("\u001b[35mEnter your username :\u001b[0m");
                        String username = scan.next();

                        mail();
                        String email = scan.next();

                        pass();
                        String password = scan.next();

                        LOGGER.info("\u001b[35mEnter your location:\u001b[0m");
                        String location = scan.next();

                        LOGGER.info("\u001b[35mEnter your phone Number:\u001b[0m");
                    String phoneNum = scan.next();


                        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || location.isEmpty()) {
                            ErrorMsg.showError2();
                        }
                    if (!User.isValidEmail(email)) {
                        LOGGER.info("\u001B[34mInvalid email format. Please enter a valid email address.\u001B[0m");
                    } else {
                        boolean emailExists = false;

                        for (User user : Userslist.getUsers()) {
                            if (user.getEmail().equals(email)) {
                                LOGGER.info("\u001B[34mEmail already exists. Choose a different email.\u001B[0m");
                                emailExists = true;
                                break;
                            }
                        }
                        if (password != null && password.matches(passRange)) {
                            // Continue with your logic when the password is valid
                            if (!emailExists) {
                                // Proceed with the sign-up process since the email does not exist
                                User newUser = new User(username, email, password, "Installer", location, phoneNum);
                                Userslist.addUser(newUser);
                                LOGGER.info("\u001B[32mSign Up Successfully.\u001B[0m");
                            }

                        } else {
                           ErrorMsg.passWarning();

                            }}}}
            else if (inputt == 3){
                break;
            }
            else
                ErrorMsg.showWarning();

        }

    }
}

