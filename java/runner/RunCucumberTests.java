package runner;

import io.cucumber.testng.CucumberOptions;
import stepDef.ProjectDefinitionMethods;

@CucumberOptions(features = "src/test/java/feature",
                 glue = {"stepDef" , "hooks"},
                 tags = "@smoke",
                 monochrome = true,
                 publish = true)
public class RunCucumberTests extends ProjectDefinitionMethods{

}
