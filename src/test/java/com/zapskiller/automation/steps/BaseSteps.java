package com.zapskiller.automation.steps;

import com.zapskiller.automation.config.Hooks;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BaseSteps {

    @Given("I boot up the framework")
    public void i_boot_up_the_framework() {
        System.out.println("Framework Booted...");
    }

    @When("I execute a scenario from feature")
    public void i_execute_a_scenario_from_feature() {
        System.out.println("Step Execution started..");
    }

    @Then("The Test Should execute successfully")
    public void the_test_should_execute_successfully() {
        System.out.println("Step Executed Successfully");
    }
}
