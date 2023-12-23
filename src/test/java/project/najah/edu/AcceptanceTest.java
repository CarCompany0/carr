package project.najah.edu;
import io.cucumber.junit.CucumberOptions.SnippetType;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/requirments",
        plugin = { "summary", "html:target/cucumber/wikipidia.html"},
        monochrome=true,
        snippets = SnippetType.CAMELCASE,
        glue="project.najah.edu")


public class AcceptanceTest{

}
