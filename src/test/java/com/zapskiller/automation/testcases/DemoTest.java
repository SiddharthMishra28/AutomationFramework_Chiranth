package com.zapskiller.automation.testcases;

import com.zapskiller.automation.config.Hooks;
import com.zapskiller.automation.pages.HomePage;
import com.zapskiller.automation.pages.RegisterPage;
import com.zapskiller.automation.utils.UIAutomationUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoTest extends Hooks {

    public HomePage homePage;
    public RegisterPage registerPage;
    @Test(dataProvider = "user_data_provider")
    public void register_new_user_test(String firstName, String lastName) {
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
//        homePage.startRegistrationProcess();
//        registerPage.registerNewUser();
    }

    @DataProvider(name = "user_data_provider")
    public String[][] getTestData() {
        return UIAutomationUtils.readTestData(configProps.getProperty("test.datasource"), "users");
    }
}
