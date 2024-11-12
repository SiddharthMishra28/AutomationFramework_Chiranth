package com.zapskiller.automation.testcases;

import com.zapskiller.automation.config.Hooks;
import com.zapskiller.automation.pages.HomePage;
import org.testng.annotations.Test;

public class DemoTest extends Hooks {

    @Test
    public void add_to_cart_failure_test() throws InterruptedException {
        HomePage homePage = new HomePage();
        utils.navigateToUrl("http://vistacommerce-qa.rf.gd/");
        utils.clickElement(homePage.signInLink);
        Thread.sleep(3000);
    }
}
