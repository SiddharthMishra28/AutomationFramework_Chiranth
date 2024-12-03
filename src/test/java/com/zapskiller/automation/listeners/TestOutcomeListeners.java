package com.zapskiller.automation.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestOutcomeListeners implements IRetryAnalyzer {

    int maxRetryCount = 3;
    int retryCount = 1;

    @Override
    public boolean retry(ITestResult result) {
        if(result.getStatus()==ITestResult.FAILURE && retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }else {
            return false;
        }
    }
}
