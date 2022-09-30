package StepDefinitions;

import Config.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomeSteps {

    private WebDriver driver;
    private pages.Home home;

    public HomeSteps(TestContext context){
        driver = context.getDriver();
        home = new pages.Home(driver, new WebDriverWait(driver, 10));
    }

    @And("^Remove adds")
    public void removeAdds(){
        home.removeAds();
    }

    @When("^The users clicks on button forms")
    public void clickOnBtnForms() {
        home.clickBtnForms();
    }

    @Then("^The url is \"(.*)\"$")
    public void clickOnBtnForms(String urlExpected) {
        Assert.assertEquals(driver.getCurrentUrl(), urlExpected, "The urls aren't the same");
    }

}
