package project.najah.edu;

import java.util.logging.Logger;

public class ErrorMsg {
    private ErrorMsg() {
       
    }
    private static final Logger LOGGER = Logger.getLogger(ErrorMsg.class.getName());
    public static void showError() {
        LOGGER.info("\u001B[34mIncorrect Email/Password\u001B[0m");

        }
public static void showError2() {
        LOGGER.info("\u001B[34mplease enter Email/Password\u001B[0m");
        }
public static void showError3() {
        LOGGER.info("\u001B[34memail is used,Try with another email\u001B[0m");
        }
public static void showError4() {LOGGER.info("\u001B[34mPlease fill all fields\u001B[0m");}
   
    public static void showWarning(){LOGGER.warning("Invalid input. Please enter a valid option.");}
    public static void passWarning(){LOGGER.info("\u001B[34mWarning: Password must contain only digits and have a length of 5 or more.\u001B[0m");}

}
