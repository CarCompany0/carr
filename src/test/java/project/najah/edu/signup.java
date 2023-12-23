package project.najah.edu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class signup {
    LoginSteps loginsteps;
    public signup(LoginSteps loginsteps) {
        this.loginsteps =loginsteps;
    }
    private String username;
    private String email;
    private String password;
    private String location;
    private String Type;
    private String phoneNum;


    @Given("that the user is not signed up")
    public void thatTheUserIsNotSignedUp() {
        // Write code here that turns the phrase above into concrete actions
LoginSteps.logout();
        assertFalse(loginsteps.isIssignedup());
    }
    @When("email is {string}")
    public void emailIs(String string) {
        this.email=string;
        // Write code here that turns the phrase above into concrete actions

    }
    @When("password is {string}")
    public void passwordIs(String string) {
        this.password=string;

    }
    @When("username is {string}")
    public void usernameIs(String string) {

        this.username=string;
        // Write code here that turns the phrase above into concrete actions

    }
    @When("type is {string}")
    public void typeIs(String string) {
        this.Type=string;
        // Write code here that turns the phrase above into concrete actions

    }
    @When("location is {string}")
    public void locationIs(String string) {
        this.location=string;
        // Write code here that turns the phrase above into concrete actions

    }
    @When("phoneNum is {string}")
    public void phoneNumIs(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.phoneNum=  string;
    }

    @Then("the user will sign up and added to userslist")
    public void theUserWillSignUpAndAddedToUserslist() {
        // Write code here that turns the phrase above into concrete actions
        loginsteps.signUp();
        assertTrue(loginsteps.isIssignedup());
    }

    @Then("the user will not sign up")
    public void theUserWillNotSignUp() {
        // Write code here that turns the phrase above into concrete actions
        assertFalse(loginsteps.isIssignedup());
    }
    @Then("show why can't sign up")
    public void showWhyCanTSignUp() {
        // Write code here that turns the phrase above into concrete actions
        ErrorMsg.showError3();
    }


}

