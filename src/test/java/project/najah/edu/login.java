package project.najah.edu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class login {

    LoginSteps loginsteps;
    public login(LoginSteps loginsteps) {
        this.loginsteps =loginsteps;
    }

    private String email;
    private String password;
    @When("email is a {string}")
    public void email_is_a(String string) {
        this.email=string  ;
    }
    @When("password is a {string}")
    public void password_is_a(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.password=string;
    }
    @Given("the user is not logged in")
    public void theUserIsNotLoggedIn() {
        // Write code here that turns the phrase above into concrete actions
        LoginSteps.logout();
        assertFalse(loginsteps.isLoggedIn());
    }
    @Then("the user logs in successfully")
    public void theUserLogsInSuccessfully() {
        LoginSteps.checkAuth(email, password);

        if (email.isEmpty() || password.isEmpty()) {
            ErrorMsg.showError2();
        }
        else if (!LoginSteps.isAdminIsLogged() && !LoginSteps.isCustomerIsLogged() && !LoginSteps.isInstallerIsLogged()) {
            ErrorMsg.showError();

        }
        else{
            loginsteps.login();
            assertTrue(loginsteps.isLoggedIn());}
    }

    @Then("the user will not login")
    public void theUserWillNotLogin() {
        LoginSteps.checkAuth(email, password);

        if (email.isEmpty() || password.isEmpty()) {
            ErrorMsg.showError2();
        }
        else if (!LoginSteps.isAdminIsLogged() && !LoginSteps.isCustomerIsLogged() && !LoginSteps.isInstallerIsLogged()) {
            ErrorMsg.showError();

        }


    }


    @Given("that the user is not logged in")
    public void thatTheUserIsNotLoggedIn() {
        // Write code here that turns the phrase above into concrete actions
        LoginSteps.logout();
        assertFalse(loginsteps.isLoggedIn());
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        // Write code here that turns the phrase above into concrete actions
        loginsteps.login();
        assertTrue(loginsteps.isLoggedIn());
    }

    @Then("the user will return to the welcome page")
    public void theUserWillReturnToTheWelcomePage() {
        loginsteps.logout();
        // Write code here that turns the phrase above into concrete actions
        assertFalse(loginsteps.isLoggedIn());
    }


}