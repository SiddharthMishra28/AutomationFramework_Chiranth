package com.zapskiller.automation.config;

import com.zapskiller.automation.utils.UIAutomationUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
    public static Properties configProps;
    public ChromeOptions options = new ChromeOptions();
    public WebDriver driver;


    @BeforeSuite
    public void beforeSuite() {
        configProps = UIAutomationUtils.readConfig();
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class...");
    }

    @BeforeTest
    public void beforeTest() {
        launchBrowser();
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
        closeBrowser();
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
     * <p>Launches a browser based on provided config params</p>
     * @Version 1.0
     */
    public void launchBrowser() {
        if(configProps.getProperty("browser").equalsIgnoreCase("CHROME")){
            if(configProps.getProperty("browser.chrome.options.headless").equalsIgnoreCase("true")) {
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
        }
    }

    /**
     * <p>Terminates webdriver session</p>
     * @Version 1.0
     */
    public void closeBrowser() {
        driver.quit();
    }

}
