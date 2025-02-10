package americanRunner;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "Step",
    dryRun = true
)
public class Runner {

}
