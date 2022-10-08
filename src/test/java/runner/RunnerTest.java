package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.RestUtils;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = {"json:target/reports/CucumberReports.json", "pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@regressivo"
)

public class RunnerTest {
    @BeforeClass
    public static void setUp(){
        RestUtils.setBaseURI("http://localhost:8080/");
    }
    @AfterClass
    public static void report() throws IOException {
        if (System.getProperty("os.name").equals("Windows 10")) {
            Runtime.getRuntime().exec("cmd.exe /c mvn verify");
        } else {
            Runtime.getRuntime().exec("sh -c mvn verify");
        }
    }
}
