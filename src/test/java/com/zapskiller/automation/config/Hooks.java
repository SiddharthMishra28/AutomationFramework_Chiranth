package com.zapskiller.automation.config;

import com.zapskiller.automation.utils.UIAutomationUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * <p>This class is responsible for controlling the framework lifecycle based on execution events</p>
 * @Author : Siddharth
 * @Version : 1.0
 */
public class Hooks {

    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);
    public WebDriver driver;
    // TEMPORARY
    public UIAutomationUtils utils = new UIAutomationUtils();

    @BeforeSuite
    public void beforeSuite() {
        UIAutomationUtils.readConfig();
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class...");
    }

    @BeforeTest
    public void beforeTest() {
        utils.launchBrowser();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method...");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method...");
    }

    @AfterTest
    public void AfterTest() {
        utils.closeBrowser();
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class...");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite...");
    }

    /**
     * <p>This method is responsible for reading configuration parameters from a resource file</p>
     * @Version 1.0
     */

}
