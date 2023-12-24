package org.example;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class InstallerDates {
    private static final Logger LOGGER = Logger.getLogger(InstallerDates.class.getName());
    private static final Scanner scan = new Scanner(System.in);
    private String day;
    private String month;
    private String year;
    private String hour;
    private String installerName;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getInstallerName() {
        return installerName;
    }

    public void setInstallerName(String installerName) {
        this.installerName = installerName;
    }

    public InstallerDates(String day, String month, String year, String hour, String installerName) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.installerName = installerName;
    }
    public static void addDate(List<InstallerDates> installerDatesList, String namee) {

        // Create a new Product with the provided information

        LOGGER.info("\u001B[33m Enter New Date:\u001B[0m");
        LOGGER.info("\u001B[33m Day:\u001B[0m");
        String dayy = scan.nextLine();


        LOGGER.info("\u001B[33m Month:\u001B[0m");
        String monthh = scan.nextLine();


        LOGGER.info("\u001B[33m Year:\u001B[0m");
        String yearr = scan.nextLine();


        LOGGER.info("\u001B[33m Hour:\u001B[0m");
        String hourr = scan.nextLine();


        InstallerDates newDate = new InstallerDates(dayy, monthh, yearr, hourr, namee);

        // Add the new product to the productList
        installerDatesList.add(newDate);
        LOGGER.info("\u001B[32mDate Added successfully.\u001B[0m");
    }
    public static void viewDates(List<InstallerDates> installerDatesList) {
        int x = 1;

        for (InstallerDates installerDates : installerDatesList) {
            String s = x + "- Installer Name: " + installerDates.getInstallerName() + " \n Day/month/year: " + installerDates.getDay() + "/" + installerDates.getMonth() +
                    "/" + installerDates.getYear() + " , Hour: " + installerDates.getHour();
            LOGGER.info("\u001B[35m"+ s +"\u001B[0m");
            x++;
        }

    }
}
