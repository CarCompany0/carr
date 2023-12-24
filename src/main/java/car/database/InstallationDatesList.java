package car.database;

import org.example.InstallerDates;

import java.util.ArrayList;
import java.util.List;

public class InstallationDatesList {

    private static final List<InstallerDates> date = new ArrayList<>();
    // Private constructor to hide the implicit public one
    private InstallationDatesList() {}
    static{
        date.add(new InstallerDates("09", "11","2023","6:00","Ahmed"));
        date.add(new InstallerDates("11", "03","2023","5:00","Ali"));
        date.add(new InstallerDates("02", "10","2023","3:00","Maya"));
        date.add(new InstallerDates("07", "12","2023","1:00","Nabeel"));
    }

    public static List<InstallerDates> getInstaller() {
        return date;
    }


}
