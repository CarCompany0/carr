package project.najah.edu;

import car.database.InstallationRequestsList;
import car.database.Userslist;
import car.database.InstallationDatesList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.InstallationRequest;
import org.example.InstallerDates;
import org.example.User;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class installer {
    private static final Logger LOGGER = Logger.getLogger(customer.class.getName());

    LoginSteps loginsteps;
    private  String select;
    private  String day;
    private  String mounth;
    private  String year;
    private  String hour;
    private  String current;
    private  String password;
    public installer(LoginSteps loginsteps) {
        this.loginsteps =loginsteps;
    }

    @Given("the user is installer")
    public void theUserIsInstaller() {
        // Write code here that turns the phrase above into concrete actions
        loginsteps.login();
        assertTrue(loginsteps.isInstallerIsLogged());
    }
    @When("the user chooses {string}")
    public void theUserChooses(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.select=string;
    }
    @Then("the installation requests appears.")
    public void theInstallationRequestsAppears() {
        // Write code here that turns the phrase above into concrete actions
        List<InstallationRequest> requests;
        requests = InstallationRequestsList.getRequest();
        InstallationRequest.displayInstallationRequests(requests);
        assertTrue(InstallationRequest.isAppers());
    }


    @When("the installer choose {string}")
    public void theInstallerChoose(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.select=string;
    }
    @When("the  customer  email is {string}")
    public void the_customer_email_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.current=string;
    }
    @When("the  customer  pass is {string}")
    public void the_customer_pass_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.password=string;
    }
    @When("the day {string}")
    public void theDay(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.day=string;
    }
    @When("the mounth {string}")
    public void theMounth(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.mounth=string;
    }
    @When("the year {string}")
    public void theYear(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.year=string;
    }
    @When("the hour {string}")
    public void theHour(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.hour=string;
    }
    @Then("The new appointment Added succsesfully")
    public void theNewAppointmentAddedSuccsesfully() {
        boolean isAdded=false;
        List<InstallerDates> inss;
        inss = InstallationDatesList.getInstaller();
        LoginSteps.checkAuth(current, password);
        if (LoginSteps.isCustomerIsLogged()){
            String currentUser;
            for (User user : Userslist.getUsers()) {
                if (user.getEmail().equals(current)) {
                    currentUser = user.getUsername();
                    isAdded=true;
                    InstallerDates newDate = new InstallerDates(day, mounth, year, hour, currentUser);

                    // Add the new product to the productList
                    inss.add(newDate);


                }
            }
            LOGGER.info("\u001B[32mDate Added successfully.\u001B[0m");
            InstallerDates.viewDates(inss);
            assertTrue(isAdded);
        }

    }
}
