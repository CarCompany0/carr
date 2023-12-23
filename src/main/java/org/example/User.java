package org.example;

import java.util.List;
import java.util.logging.Logger;
public class User {

    private static final Logger LOGGER = Logger.getLogger(User.class.getName());
    private String username;
    private String email;
    private String password;
    private String type;
    private String phoneNum;
    private  String location;
    private static int numUser = 0;
    private static boolean isUserUpdated=false;



    private static boolean isUserDeleted=false;
    public static int getNumUser() {
        return numUser;
    }



    public User(String username,String email, String password, String type,String location,String phoneNum) {
        this.username=username;
        this.email = email;
        this.password = password;
        this.type = type;
        this.location=location;
        this.phoneNum=phoneNum;
    }

    public User() {
    }
    public static Boolean getIsUserUpdated() {
        return isUserUpdated;
    }
    public static boolean isUserDeleted() {
        return isUserDeleted;
    }
    public String getUsername()
    {return username;}
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public String getType() {

        return type;}

    public String getLocation() {
        return location;}

    public String getPhoneNum() {
        return phoneNum;}


 public  void setUsername(String username){ this.username=username;}
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

public void setPhoneNum(String phoneNum){this.phoneNum=phoneNum;}

    public void setLocation(String location){this.location=location;}

    public static void printUserInfo(User user) {
        LOGGER.info("\u001B[34mUser Information:\u001B[0m");
        LOGGER.info("\u001B[34mUsername: " + user.getUsername()+"\u001B[0m");
        LOGGER.info("\u001B[34mEmail: " + user.getEmail()+"\u001B[0m");
        LOGGER.info("\u001B[34mPassword: " + user.getPassword()+"\u001B[0m");
        LOGGER.info("\u001B[34mLocation: " + user.getLocation()+"\u001B[0m");
        LOGGER.info("\u001B[34mPhone Number: " + user.getPhoneNum()+"\u001B[0m");
        LOGGER.info("\u001B[34m---------------\u001B[0m");
    }
    public static void viewAccounts(List<User> userList) {

        int i = 1;
        for(User user : userList)
        {
            String s = i+ "- "+ user.getUsername()+ " , " + user.getEmail()+ " , " + user.getType()+
            " , " + user.getLocation()+" , " + user.getPhoneNum();
            LOGGER.info("\u001B[35m"+s+"\u001B[0m");
            i++;
        }
        numUser = i;
    }
    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }

    public static void removeUserByNum(List<User> userList, int numUser) {
        if (numUser > 0 && numUser <= userList.size()) {
            userList.remove(numUser - 1);
            isUserDeleted=true;
            LOGGER.info("\u001B[32mUser removed successfully.\u001B[0m");
        }
        // Update numUser after removal
       else isUserDeleted=false;

    }

    public static void updateUserByNum(List<User> userList, int numUser,String newUsername, String newLocation, String newPhoneNum) {
        if (numUser > 0 && numUser <= userList.size()) {
            User userToUpdate = userList.get(numUser - 1);
           userToUpdate.setUsername(newUsername);
            userToUpdate.setLocation(newLocation);
            userToUpdate.setPhoneNum(newPhoneNum);
            isUserUpdated=true;
            LOGGER.info("\u001B[32mUser updated successfully.\u001B[0m");
        }
        else isUserUpdated=false;
    }
}

