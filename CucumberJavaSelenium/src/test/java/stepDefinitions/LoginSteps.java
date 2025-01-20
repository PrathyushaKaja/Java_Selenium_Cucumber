package stepDefinitions;

import io.cucumber.java.en.*;

public class LoginSteps {

    @Given("user is on the login page")
    public void user_is_on_login_page() {
        System.out.println(">>> User is on login page");
    }

    @When("user enters the valid {string}")
    public void user_enters_the_valid(String username) {
        System.out.println(">>> User entered valid username: " + username);
    }

    @And("enters the valid {string}")
    public void enters_the_valid(String password) {
        System.out.println(">>> User entered valid password: " + password);
    }

    @And("user clicks on login button")
    public void user_clicks_on_login_button() {
        System.out.println(">>> User clicked on login button");
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        System.out.println(">>> User navigated to the home page");
    }
    
    @When("user entered the invalid {string}")
    public void user_entered_the_invalid_username(String username) {
    	System.out.println(">>> User entered the invalid username");
    }
    
    @And("entered the valid {string}")
    public void entered_the_valid_password(String password) {
    	System.out.println(">>> User entered the valid password");
    }
    
    @Then("user got warning message")
    	public void user_got_warning_message() {
    		System.out.println(">>> User got warning message");
    }
}
