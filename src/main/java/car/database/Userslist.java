package car.database;

import org.example.User;

import java.util.ArrayList;
import java.util.List;

public class Userslist {
    private Userslist() {
    }
    // Compliant, the compiler will infer the type argument
   private static final List<User> users = new ArrayList <>();


    static{
        users.add(new User("dana","dana@gmail.com","12345","Admin","nablus","469897"));
        users.add(new User("leema","leema@gmail.com","00000","Customer","Qulqiliah","564213"));
        users.add(new User("jood","jood@gmail.com","54321","Customer","Tulkarem","218610"));
        users.add(new User("saleh","saleh@gmail.com","11111", "Installer","nablus","412369"));
    }
    public static List<User> getUsers() {
        return users;
    }
    public static List<User> getAdmins() {
        return users;
    }

    public static void addUser (User h){
        users.add(h);
    }

}