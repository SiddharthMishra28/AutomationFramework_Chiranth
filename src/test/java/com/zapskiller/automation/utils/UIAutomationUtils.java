package com.zapskiller.automation.utils;

import com.zapskiller.automation.config.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

/**
 * <p>This class contains re-usable methods for standard execution steps which are specific to UI Test automation</p>
 * @Version 1.0
 * @Author Siddharth
 */
public class UIAutomationUtils {

    public WebDriver driver;
    public WebDriverWait wait;

    public UIAutomationUtils(WebDriver driver) {
        this.driver = driver;
    }

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
     * <p>Clicks on provided web element</p>
     * @param element
     * @Version 1.0
     */
    public void clickElement(By element) {
//        waitForElementVisibility(element);
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

    /**
     * <p>Waits for Visibility of WebElement for configured number of seconds</p>
     * @param locator
     * @Version 1.0
     */
    public void waitForElementVisibility(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(Hooks.configProps.getProperty("webdriver.wait.inseconds"))));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * <p>Types or Sends Keystrokes to the mentioned Input Field</p>
     * @param locator
     * @param value
     * @Version 1.0
     */
    public void typeIntoField(By locator, String value) {
        waitForElementVisibility(locator);
        driver.findElement(locator).sendKeys(value);
    }
}
