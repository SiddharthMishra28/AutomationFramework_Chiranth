package com.zapskiller.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * <p>This class contains re-usable methods for standard execution steps which are specific to UI Test automation</p>
 * @Version 1.0
 * @Author Siddharth
 */
public class UIAutomationUtils {

    public static Properties configProps = readConfig();
    public WebDriver driver;
    public ChromeOptions options = new ChromeOptions();

    /**
     * <p>Reads a properties / config file and its properties</p>
     * @return Properties
     * @Version 1.0
     */
    public static Properties readConfig() {
        try {
            FileInputStream fis = new FileInputStream(new File("src/test/resources/config-qa.properties"));
            Properties properties = new Properties();
            properties.load(fis);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    /**
     * <p>Clicks on provided web element</p>
     * @param element
     * @Version 1.0
     */
    public void clickElement(By element) {
        driver.findElement(element).click();
    }

    /**
     * <p>Navigates to specified url within the browser</p>
     * @param url
     * @Version 1.0
     */
    public void navigateToUrl(String url) {
        driver.get(url);
    }
}
