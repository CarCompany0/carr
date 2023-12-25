package org.example;



import java.util.List;
import java.util.logging.Logger;

public class InstallationRequest extends InstallerDates {
    private static final Logger LOGGER = Logger.getLogger(InstallationRequest.class.getName());
    private static final String RESET = "\u001B[0m";
    private static boolean isAppers=false;
    public static boolean isAppers() {
        return isAppers;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getCustomerLocation() {
        return customerLocation;
    }

    private static String customerName;
    private static String customerLocation;
    private static String customerPhoneNum;
    private static String productName;
    public InstallationRequest(String day, String month, String year, String hour, String installerName,
                               String productName, String cName,String cLoc,String cPhnum) {
        super(day, month, year, hour, installerName);
        this.productName = productName;
        this.customerName = cName;
        this.customerLocation = cLoc;
        this.customerPhoneNum = cPhnum;
    }
    public String getProductName() {
        return productName;
    }
    public static void sendEmailNotification() {
        // Use the EmailSender class to send an email notification
        String from= "lemarizeq@gmail.com";
        String to = "s12029320@stu.najah.edu";
        String subject = "New Installation Request";
        String messageText = "Dear Installer,\n\nYou have a new installation request.\n\n" +
                "Customer: " + customerName + "\nLocation: " + customerLocation + "\nPhone Number: " + customerPhoneNum +
                "\nProduct: " + productName + "\n\nPlease check your dashboard for more details.";

        EmailSender.sendEmail(from, to, subject, messageText);
    }

    public static void displayInstallationRequests(List<InstallationRequest> installationRequests) {


        LOGGER.info("\u001B[32mInstallation Requests:\u001B[0m");

        for (InstallationRequest request : installationRequests) {
            LOGGER.info("\u001B[34m- Product Name: " + request.getProductName()+RESET);
            LOGGER.info("\u001B[34mCustomer Name: " + request.getCustomerName()+RESET);
            LOGGER.info("\u001B[34mLocation: " + request.getCustomerLocation()+RESET);
            LOGGER.info("\u001B[34mDATE:"+RESET);
            LOGGER.info("\u001B[34mDay/month/year: " + request.getDay() + "/" + request.getMonth() + "/" + request.getYear() +
                    ", Hour: " + request.getHour()+RESET);
            LOGGER.info("\u001B[34mInstaller Name:"+ request.getInstallerName()+RESET);
            LOGGER.info("\u001B[34m---------------"+RESET);
        }
        isAppers=true;
    }

}
