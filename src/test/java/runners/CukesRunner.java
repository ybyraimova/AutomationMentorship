package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/cucumberReports.html",
        features = "src/test/resources/api",
        glue = "steps",
        tags = "@api",
        dryRun = false
        //dryRun = do you want me to check without executing the code but just check if they have implementation

        //this class is for configuration to run our feature files. when we run this class it is going to
        // trigger all other methods from feature files.
)
public class CukesRunner {
}
