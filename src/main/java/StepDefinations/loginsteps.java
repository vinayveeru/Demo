package StepDefinations;

import io.cucumber.java.en.*;

public class loginsteps {
    @Given("user customer is on login")
    public void user_customer_is_on_login() {
        System.out.println("1");
    }

    @When("entered credentials")
    public void entered_credentials() {
        System.out.println("2");

    }

    @And("when clicks on login btn")
    public void when_clicks_on_login_btn() {
        System.out.println("3");

    }

    @Then("user should be taken to dashboard")
    public void user_should_be_taken_to_dashboard() {
        System.out.println("4");

    }
}
