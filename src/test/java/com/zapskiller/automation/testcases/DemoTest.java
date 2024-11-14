package com.zapskiller.automation.testcases;

import com.zapskiller.automation.config.Hooks;
import com.zapskiller.automation.pages.HomePage;
import com.zapskiller.automation.pages.RegisterPage;
import org.testng.annotations.Test;

public class DemoTest extends Hooks {

    public HomePage homePage;
    public RegisterPage registerPage;
    @Test
    public void register_new_user_test() {
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.navigateToUrl("http://vistacommerce-qa.rf.gd/");
        homePage.clickElement(homePage.signInLink);
        homePage.clickElement(homePage.registerLink);
        registerPage.clickElement(registerPage.socialTitle);
        registerPage.typeIntoField(registerPage.firstName, "Sid");
        registerPage.typeIntoField(registerPage.lastName, "Mishra");
    }
}
