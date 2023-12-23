package project.najah.edu;

import car.database.InstallationRequestsList;
import car.database.Userslist;
import car.database.CategoryList;
import car.database.InstallationDatesList;
import org.example.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final Scanner scan = new Scanner(System.in);
    private static final LoginSteps loginSteps = new LoginSteps();
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
                                                                        Product.updateByNum(selectProduct);
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
                                        Product.add();
                                        // Display the updated user list
                                        break;
                                    case 3:

                                        productList = CategoryList.getProduct();
                                        Product.search(productList);
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
                                        Customer.Order.placeOrder(product1, selectedProductIndex);
                                    }
                                }
                                break;

                            case "2":

                                p1 = CategoryList.getProduct();
                                Customer.search(p1);
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

                                    InstallationRequest.requestInstallation(req1, p1, customerName, customerLocation, customerPhoneNum);
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
                                    InstallerDates.addDate(inss,currentUser);
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

