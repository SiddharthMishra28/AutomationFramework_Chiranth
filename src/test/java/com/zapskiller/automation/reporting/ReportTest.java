package com.zapskiller.automation.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportTest {

    public static void main(String[] args) {
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter("./report.html");
        extentReports.attachReporter(reporter);

        ExtentTest test = extentReports.createTest("Sample Test");
        test.log(Status.PASS, "Validation Successful!");
        test.log(Status.INFO, "Database Connected!");
        extentReports.flush();
    }
}
