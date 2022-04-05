package runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\Login.feature",
        glue = "stepDef",
        tags = "@Test1",
        plugin = {"pretty", "html:target/HtmlReports.html"}
)

public class RunLogin {

}
