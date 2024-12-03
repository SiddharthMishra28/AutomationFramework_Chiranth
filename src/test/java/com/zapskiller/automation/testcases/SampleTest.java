package com.zapskiller.automation.testcases;

import com.zapskiller.automation.listeners.TestOutcomeListeners;
import com.zapskiller.automation.providers.ExcelDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {

    @Test(dataProviderClass = ExcelDataProvider.class, dataProvider = "getAddressData", retryAnalyzer = TestOutcomeListeners.class)
    public void sampleTest(String name, String email, String phone) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(phone);
        Assert.assertTrue(false);
    }
}
