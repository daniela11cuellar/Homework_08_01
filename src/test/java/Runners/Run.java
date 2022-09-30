package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
            features = {
                    "src/test/resources/test0801.feature",
                    "src/test/resources/HomeTest.feature",
                    "src/test/resources/FormTest.feature",
                    "src/test/resources/PracticeFormTest.feature"
            },
            glue = {"StepDefinitions"}
)

public class Run extends AbstractTestNGCucumberTests {
}
