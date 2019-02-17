package org.craftsmanship.katas.simple;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "classpath:features",
        plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber-html-report/cucumber.json"},
        tags = {}
)

public class CucumberRunner {

}