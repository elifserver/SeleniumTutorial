package runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;



@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports",
                "junit:target/cucumber.xml"
        },
        features = {"src/test/resources/"},
        glue = { "steps"},
        //glue = {"src/test/java/steps"},
        dryRun = false,
        tags = {""}
)

public class TestRunner {

}
