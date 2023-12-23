package car.database;

import org.example.InstallationRequest;

import java.util.ArrayList;
import java.util.List;

public class InstallationRequestsList {

    private static final List<InstallationRequest> req = new ArrayList<>();


    static{


        req.add(new InstallationRequest("09", "11", "2023", "6:00", "Ahmed", "camera", "leema","qal","02356"));
        req.add(new InstallationRequest("11", "03", "2023", "5:00", "Ali", "backseat cover", "ameed","qal","2356"));
        req.add(new InstallationRequest("02", "10", "2023", "3:00", "Maya", "tint", "ali","nab","8989"));
        req.add(new InstallationRequest("07", "12", "2023", "1:00", "Nabeel", "stearing cover","lolo","ramaallah","0259631"));
    }

    public static List<InstallationRequest> getRequest() {
        return req;
    }
    public static void addReq (InstallationRequest reqq){
        req.add(reqq);
    }


}

