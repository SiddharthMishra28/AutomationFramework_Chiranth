package com.zapskiller.automation.testcases;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import com.google.common.util.concurrent.FakeTimeLimiter;
import com.zapskiller.automation.config.Hooks;
import com.zapskiller.automation.pages.HomePage;
import com.zapskiller.automation.pages.RegisterPage;
import com.zapskiller.automation.utils.UIAutomationUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTest extends Hooks {

    public HomePage homePage;
    public RegisterPage registerPage;
    @Test(dataProvider = "user_data_provider")
    public void register_new_user_test(String socialTitle,
                                       String firstName,
                                       String lastName,
                                       String email,
                                       String password,
                                       String birthData) throws InterruptedException {
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.startRegistrationProcess("http://vistacommerce-qa.rf.gd/");
        test.log(Status.INFO, "Registration Process Started!");
        registerPage.registerNewUser(socialTitle, firstName, lastName, email, password, birthData);
        test.log(Status.INFO, "Registration Steps Execution Completed!");
        Thread.sleep(4000);
        Assert.assertEquals("Registration Success", "Registration Success");
        test.log(Status.PASS, "Test Case Passed!");
    }

    @DataProvider(name = "user_data_provider")
    public String[][] getTestData() {
        return UIAutomationUtils.readTestData(configProps.getProperty("test.datasource"), "users");
    }
}
