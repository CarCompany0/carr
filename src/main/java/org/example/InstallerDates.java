package org.example;

import java.util.List;

import java.util.logging.Logger;

public class InstallerDates {
    private static final Logger LOGGER = Logger.getLogger(InstallerDates.class.getName());
    private String day;
    private String month;
    private String year;
    private String hour;
    private String installerName;

    public String getDay() {
        return day;
    }



    public String getMonth() {
        return month;
    }


    public String getYear() {
        return year;
    }


    public String getHour() {
        return hour;
    }


    public String getInstallerName() {
        return installerName;
    }

    public InstallerDates(String day, String month, String year, String hour, String installerName) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.installerName = installerName;
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
