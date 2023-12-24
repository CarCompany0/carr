package project.najah.edu;

import car.database.Userslist;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.User;

import java.util.logging.Logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class signup {
    private static final Logger LOGGER = Logger.getLogger(customer.class.getName());
    private static final String passRange = "\\d{5,}";
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
        User.isValidEmail(email);

        if(User.isValidEmail(email)) {
            boolean emailExists = false;
            for (User user : Userslist.getUsers()) {
                if (user.getEmail().equals(email)) {
                    LOGGER.info("\u001B[34m Email already exists. Choose a different email.\u001B[0m");
                    emailExists = true;
                    break;
                }
            }
            if (password != null && password.matches(passRange)) {
                // Continue with your logic when the password is valid
                if (!emailExists) {
                    // Proceed with the sign-up process since the email does not exist
                    User newUser = new User(username, email, password, "Customer", location, phoneNum);
                    Userslist.addUser(newUser);
                    LOGGER.info("\u001B[32m Sign Up Successfully.\u001B[0m");
                }

            } else {
                ErrorMsg.passWarning();

            }}
    }

    @Then("the user will not sign up")
    public void theUserWillNotSignUp() {
        // Write code here that turns the phrase above into concrete actions
        User.isValidEmail(email);

         if(User.isValidEmail(email)) {
             for (User user : Userslist.getUsers()) {
            if (user.getEmail().equals(email)) {
                LOGGER.info("\u001B[34m Email already exists. Choose a different email.\u001B[0m");
                break;
            }
        }}
        else if (password != null && password.matches(passRange)){
            ErrorMsg.passWarning();
        }
    }
    @Then("show why can't sign up")
    public void showWhyCanTSignUp() {
        // Write code here that turns the phrase above into concrete actions
        if (!User.isValidEmail(email)) {
            LOGGER.info("\u001b[34m Invalid email format. Please enter a valid email address.\u001b[0m");

        }
    }


}

