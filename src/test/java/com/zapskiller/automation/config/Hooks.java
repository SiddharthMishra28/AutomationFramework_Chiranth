package com.zapskiller.automation.config;

import com.zapskiller.automation.steps.BaseSteps;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;

public class Hooks {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All..");
    }

    @BeforeStep
    public void beforeStep() {
        System.out.println("Before Step...");
    }

    @AfterStep
    public void afterStep() {
        System.out.println("After Step...");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all...");
    }
}
