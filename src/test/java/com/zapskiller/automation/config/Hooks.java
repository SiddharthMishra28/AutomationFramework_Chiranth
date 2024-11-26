package com.zapskiller.automation.config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.zapskiller.automation.utils.UIAutomationUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
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
    public ExtentReports extentReports = new ExtentReports();
    public ExtentSparkReporter reporter;
    public ExtentTest test;


    @BeforeSuite
    public void beforeSuite() {
        configProps = UIAutomationUtils.readConfig();
        reporter = new ExtentSparkReporter(configProps.getProperty("reporting.location"));
        extentReports.attachReporter(reporter);
        reporter.config(ExtentSparkReporterConfig.builder()
                .documentTitle(configProps.getProperty("report.title"))
                .theme(Theme.DARK)
                .reportName(configProps.getProperty("report.name")).build());
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
        test = extentReports.createTest();
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
        extentReports.flush();
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
            driver.manage().window().maximize();
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
