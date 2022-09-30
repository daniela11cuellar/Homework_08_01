package StepDefinitions;

import Config.TestContext;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Forms;

public class FormSteps {

    private WebDriver driver;
    private Forms forms;

    public FormSteps(TestContext context){
        driver = context.getDriver();
        forms = new Forms(driver, new WebDriverWait(driver, 10));
    }

    @When("^The users clicks on button practice")
    public void clicksOnButtonPracticeForm() {
        forms.clickBtnPractice();
    }

}
