package com.zapskiller.automation.utils;

import com.zapskiller.automation.config.Hooks;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UIAutomationUtils extends Hooks {

//    public WebDriver driver;
//
//    public UIAutomationUtils(WebDriver driver) {
//        this.driver = driver;
//    }

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
     * <p>Navigates to Provided URL</p>
     * @param url
     */
    public void navigateToUrl(String url) {
        driver.get(url);
    }

    /**
     * <p>Clicks on Provided Web Element reference</p>
     * @param element
     */
    public void clickElement(By element) {
        driver.findElement(element).click();
    }

    /**
     * <p>Sends Specified Keystrokes into the provided element reference</p>
     * @param element
     * @param keyStrokes
     */
    public void type(By element, String keyStrokes) {
        driver.findElement(element).sendKeys(keyStrokes);
    }
}
