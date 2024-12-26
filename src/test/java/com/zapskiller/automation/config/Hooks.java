package com.zapskiller.automation.config;

import com.zapskiller.automation.utils.UIAutomationUtils;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

public class Hooks {

    public static Properties configProps;
    public WebDriver driver;

    public UIAutomationUtils utils;

    @BeforeAll
    public static void beforeAll() {
        configProps = UIAutomationUtils.readConfig();
    }

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {

    }

    @AfterStep
    public void afterStep() {

    }

    @After
    public void after() {
        driver.quit();
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all...");
    }
}
