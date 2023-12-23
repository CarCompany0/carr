package org.example;

import car.database.category_list;
import car.database.installationDatesList;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class InstallationRequest extends InstallerDates {

    private static final Logger LOGGER = Logger.getLogger(InstallationRequest.class.getName());
    private static final Scanner scan = new Scanner(System.in);


    public static boolean isIsSented() {
        return isSented;
    }

    private  static boolean isSented=false;
    private static boolean  isRequsted=false;



    private static boolean isAppers=false;
    private static  String productName;
    public static boolean isRequsted() {
        return isRequsted;
    }
    public static boolean isAppers() {
        return isAppers;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerLocation() {
        return customerLocation;
    }

    public void setCustomerLocation(String customerLocation) {
        this.customerLocation = customerLocation;
    }

    public String getCustomerPhoneNum() {
        return customerPhoneNum;
    }

    public void setCustomerPhoneNum(String customerPhoneNum) {
        this.customerPhoneNum = customerPhoneNum;
    }

    private static String customerName;
    private static String customerLocation;
    private static String customerPhoneNum;

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

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public static void sendEmailNotification() {
        // Use the EmailSender class to send an email notification
        String from= "lemarizeq@gmail.com";
        String to = "s12029320@stu.najah.edu";
        String subject = "New Installation Request";
        String messageText = "Dear Installer,\n\nYou have a new installation request.\n\n" +
                "Customer: " + customerName + "\nLocation: " + customerLocation + "\nPhone Number: " + customerPhoneNum +
                "\nProduct: " + productName + "\n\nPlease check your dashboard for more details.";
        isSented=true;

        EmailSender.sendEmail(from, to, subject, messageText);
    }


    public static void displayInstallationRequests(List<InstallationRequest> installationRequests) {
        if (installationRequests.isEmpty()) {
            LOGGER.info("\u001B[34mNo installation requests available.\u001B[0m");
            return;
        }

        LOGGER.info("\u001B[32mInstallation Requests:\u001B[0m");

        int i = 1;
        for (InstallationRequest request : installationRequests) {
            LOGGER.info("\u001B[35m" + i + "- Product Name: " + request.getProductName() +
                    "\n Customer Name: " + request.getCustomerName() +
                    ", Location: " + request.getCustomerLocation() +
                    ", Phone Number: " + request.getCustomerPhoneNum() +
                    "\n Date-> "+ " Day/month/year: " + request.getDay() + "/" + request.getMonth() + "/" + request.getYear() +
                    ", Hour: " + request.getHour() + "/nInstaller Name:"+ request.getInstallerName() +"\u001B[0m");
            i++;
        }
        isAppers=true;
    }


    public static void requestInstallation(List<InstallationRequest> installationRequests, List<Product> productList, String cn,String cl ,String cp) {
        List<InstallerDates> inss;
        inss = installationDatesList.getInstaller();
        List<Product> product1;
        product1 = category_list.getProduct();

        Product.viewProducts(product1);
        LOGGER.info("\u001B[33mEnter Product Name for Installation Request:\u001B[0m");

        String requestedProductName = scan.nextLine();

        // Check if the requested product exists in the product list
        boolean productExists = false;
        for (Product product : productList) {
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
        int selectedDateIndex = Integer.parseInt(scan.nextLine()) - 1;

        if (selectedDateIndex >= 0 && selectedDateIndex < inss.size()) {
            InstallerDates selectedInstallerDate = inss.get(selectedDateIndex);
        // Create and add the installation request
        InstallationRequest newRequest = new InstallationRequest(selectedInstallerDate.getDay(), selectedInstallerDate.getMonth(),
                selectedInstallerDate.getYear(), selectedInstallerDate.getHour(), selectedInstallerDate.getInstallerName(), requestedProductName, cn,cl,cp);
        installationRequests.add(newRequest);

            isRequsted=true;
        LOGGER.info("\u001B[32mInstallation request added successfully.\u001B[0m");
            newRequest.sendEmailNotification();

    }
       else LOGGER.warning("\u001B[34mInvalid Date index \u001B[0m" );
}}
