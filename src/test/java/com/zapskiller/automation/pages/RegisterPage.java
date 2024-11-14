package com.zapskiller.automation.pages;

import com.zapskiller.automation.utils.UIAutomationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends UIAutomationUtils {

    public WebDriver driver;
    public By socialTitle = By.id("field-id_gender-1");
    public By firstName = By.id("field-firstname");
    public By lastName = By.id("field-lastname");

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }



}
