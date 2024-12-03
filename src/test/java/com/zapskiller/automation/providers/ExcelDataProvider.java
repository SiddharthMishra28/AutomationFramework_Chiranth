package com.zapskiller.automation.providers;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

    @DataProvider(name = "getData")
    public Object[][] getData() {
        // SIMULATED DATA
        return new Object[][] {
                {"name", "phone", "email"},
                {"sid", "92833920", "sid@gmail.com"},
                {"chiranth", "192948302", "chiranth@test.com"}
        };
    }

    @DataProvider(name = "getAddressData")
    public Object[][] getAddressData() {
        // SIMULATED DATA
        return new Object[][] {
                {"name", "phone", "email"},
                {"sid", "92833920", "sid@gmail.com"},
                {"chiranth", "192948302", "chiranth@test.com"}
        };
    }
}
