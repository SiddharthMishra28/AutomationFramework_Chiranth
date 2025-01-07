package com.zapskiller.automation.steps;

import com.zapskiller.automation.utils.UIAutomationUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BaseSteps {

    UIAutomationUtils utils = new UIAutomationUtils();
    @Given("I navigate to {string}")
    public void i_navigate_to(String url) {
        utils.navigateToUrl(url);
    }
    @When("I type {string} into {string} in {string}")
    public void i_type_into_in(String searchTerm, String element, String pageName) {
        utils.type(pageName, element, searchTerm);
    }

    @Then("I should be able to search the results")
    public void i_should_be_able_to_search_the_results() {

    }
}
