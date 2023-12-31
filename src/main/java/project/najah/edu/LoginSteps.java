package project.najah.edu;

import car.database.Userslist;
import org.example.User;

public class LoginSteps {

    private static boolean adminIsLogged;
    private static boolean customerIsLogged;
    private static boolean installerIsLogged;
    private static boolean issignedup ;

    public  static void checkAuth(String email, String password) {
        logout();

        for (User user : Userslist.getUsers()) {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                if (user.getType().equals("Admin"))
                    adminIsLogged = true;
                if (user.getType().equals("Customer"))
                    customerIsLogged = true;
                if (user.getType().equals("Installer"))
                    installerIsLogged = true;

            }
        }
    }

    public boolean isLoggedIn() {

        return adminIsLogged && customerIsLogged && installerIsLogged;
    }
    public static void login(){
        adminIsLogged=true;
        customerIsLogged=true;
        installerIsLogged=true;
    }
    public static void logout(){
        adminIsLogged=false;
        customerIsLogged=false;
        installerIsLogged=false;
        issignedup=false;

    }
    public static void signUp(){

        issignedup=true;
    }

    public static boolean isAdminIsLogged() {
        return adminIsLogged;
    }

    public static boolean isCustomerIsLogged() {
        return customerIsLogged;
    }

    public static boolean isInstallerIsLogged() {
        return installerIsLogged;
    }

    public boolean isIssignedup() {
        return issignedup;
    }

}