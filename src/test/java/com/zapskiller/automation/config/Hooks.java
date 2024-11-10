package com.zapskiller.automation.config;

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
    // SELENIUM WEBDRIVER INSTANCE

    @BeforeSuite
    public void beforeSuite() {
        this.readConfig();
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class...");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test...");
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
        System.out.println("After Test...");
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
    public void readConfig() {
        try {
            FileInputStream fis = new FileInputStream(new File("src/test/resources/config-qa.properties"));
            Properties properties = new Properties();
            properties.load(fis);
            System.out.println(properties.getProperty("browser"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
