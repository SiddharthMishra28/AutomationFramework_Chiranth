package com.zapskiller.automation.utils;

import com.zapskiller.automation.config.Hooks;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
     */
    public void clickElement(String page, String locator) {
        driver.findElement(parseRepository(page, locator)).click();
    }

    /**
     * <p>Sends Specified Keystrokes into the provided element reference</p>
     * @param element
     * @param keyStrokes
     */
    public void type(String page, String element, String keyStrokes) {
        driver.findElement(parseRepository(page, element)).sendKeys(keyStrokes);
    }

    public By parseRepository(String page, String element) {
        Properties readRepository = readRepository(page);
        String elemRef = readRepository.getProperty(element);
        String locatorType = elemRef.split(":")[0];
        String locatorValue = elemRef.split(":")[1];
        switch (locatorType.toUpperCase()) {
            case "NAME":
                return By.name(locatorValue);

            case "ID":
                return By.id(locatorValue);
        }
        return null;
    }

    public Properties readRepository(String repoName) {
        repoName = repoName.toLowerCase();
        System.out.println(repoName);
        String baseDirectory = "src/test/java/com/zapskiller/automation/repository";
        System.out.println(baseDirectory);
        try {
            FileInputStream fis = new FileInputStream(new File(baseDirectory+"/"+repoName+".properties"));
            Properties properties = new Properties();
            properties.load(fis);
            return properties;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
