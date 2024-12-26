package com.zapskiller.automation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/com/zapskiller/automation/features"},
        plugin = {"pretty",
                "json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-reports/cucumber-report.html"
        },
        tags = "@sanity",
        glue = {"com.zapskiller.automation.steps", "com.zapskiller.automation.config"}
)
public class Runner {
}
