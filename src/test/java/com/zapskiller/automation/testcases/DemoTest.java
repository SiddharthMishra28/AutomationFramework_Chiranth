package com.zapskiller.automation.testcases;

import com.zapskiller.automation.config.Hooks;
import com.zapskiller.automation.pages.HomePage;
import org.testng.annotations.Test;

public class DemoTest extends Hooks {

    HomePage homePage = new HomePage();
    @Test
    public void register_new_user_test() {
        homePage.navigateToUrl("http://vistacommerce-qa.rf.gd/");
        homePage.clickElement(homePage.signInLink);
    }
}
