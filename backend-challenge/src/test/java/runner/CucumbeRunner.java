package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = "com.tokenvalidator.app.validator",
        tags = "@api and @CT_002"
)
public class CucumbeRunner {
}
