package project.najah.edu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class login {

    LoginSteps loginsteps;
    public login(LoginSteps loginsteps) {
        this.loginsteps =loginsteps;
    }

    private String email;
    private String password;
    @Given("the user is not logged in")
    public void theUserIsNotLoggedIn() {
        // Write code here that turns the phrase above into concrete actions
        LoginSteps.logout();
       assertFalse(loginsteps.isLoggedIn());
    }
    @Then("the user logs in successfully")
    public void theUserLogsInSuccessfully() {
        loginsteps.login();
        assertTrue(loginsteps.isLoggedIn());
    }

    @Then("the user will not login")
    public void theUserWillNotLogin() {
        // Write code here that turns the phrase above into concrete actions
        LoginSteps.logout();
        assertFalse(loginsteps.isLoggedIn());
    }
    @Then("show a message why he can't login")
    public void showAMessageWhyHeCanTLogin() {
        ErrorMsg.showError();// Write code here that turns the phrase above into concrete actions

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
