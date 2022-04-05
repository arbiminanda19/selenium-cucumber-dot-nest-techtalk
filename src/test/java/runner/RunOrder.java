package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src\\test\\resources\\features\\Order.feature",
        glue="stepDef",
        plugin={"pretty", "html:target/HtmlReports.html", "json:target/JSONReports/report.json", "junit:target/JUnitReports/report.xml"}
)


public class RunOrder {
}
