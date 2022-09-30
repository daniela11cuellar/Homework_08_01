package StepDefinitions;

import Config.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Steps0801 {

    WebDriver driver;
    String baseUrl;

    public Steps0801(TestContext context){
        driver = context.getDriver();
    }

    @Given("^The user goes to url \"(.*)\"$")
    public void  openUrl(String url){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        baseUrl = url;
    }

    @When("Select the radio button #{int}")
    public void selectTheRadioButton(int index) {
        List<WebElement> options = driver.findElements(By.name("radioButton")) ;
        options.get(index-1).click();
    }

    @Then("The radio #{int} is selected")
    public void theRadioIsSelected(int index) {
        List<WebElement> options = driver.findElements(By.name("radioButton")) ;
        Assert.assertTrue(options.get(index-1).isSelected(), "The option was not selected");
    }

    @When("^The user sends a country \"(.*)\"$")
    public void typeCountry (String country) {
        WebElement input = driver.findElement(By.id("autocomplete"));
        input.sendKeys(country);
    }

    @And("^The user clicks a country")
    public void clickCountry () {
        WebElement country = driver.findElement(By.className("ui-menu-item-wrapper"));
        country.click();
    }

    @Then("^The country selected is \"(.*)\"$")
    public void assertCountry (String country) {
        WebElement input = driver.findElement(By.id("autocomplete"));
        String nameCountry = input.getAttribute("value");
        Assert.assertEquals(nameCountry, country, " the country is not the expected");
    }

    @When("^The user selects an option \"(.*)\"$")
    public void selectAnOptionDropDown(String option){
        Select select = new Select(driver.findElement(By.id("dropdown-class-example")));
        select.selectByValue(option);
    }

    @Then("^The option selected is \"(.*)\"$")
    public void assertAndOptionDropDown(String option){
        Select select = new Select(driver.findElement(By.id("dropdown-class-example")));
        String value = select.getAllSelectedOptions().get(0).getAttribute("value");
        Assert.assertEquals(option, value, "The option was not selected");
    }

    @When("^The user clicks on the header button \"(.*)\"$")
    public void clickOnTheHeaderButton(String button){
        WebElement header = driver.findElement(By.xpath("/html/body/header"));
        WebElement buttonElement = header.findElement(By.xpath("//button[contains(text(),'"+button+"')]"));
        buttonElement.click();
    }

    @Then("^The urls are \"(.*)\"$")
    public void verifyIfTheURLsAreTheSame(String sameUrl){
        if(sameUrl.equals("The same")){
            Assert.assertEquals(driver.getCurrentUrl(), baseUrl, "The urls are not the same");
        }else{
            Assert.assertNotEquals(driver.getCurrentUrl(), baseUrl, "The urls are the same");
        }
    }

    @When("The user opens the #{int} of tabs")
    public void theUserOpensTabs(Integer tabsToOpen) throws InterruptedException {
        int totalTabs = 0;
        while(totalTabs < tabsToOpen-1){
            ((JavascriptExecutor)driver).executeScript("window.open()");
            totalTabs++;
            ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(totalTabs));
            Thread.sleep(500);
            driver.switchTo().window(tabs.get(0));
        }
    }

    @Then("The browser has #{int} of tabs")
    public void verifyIfTheTabsAreOpened(int tabsOpened) {
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        int numTabs = tabs.size();
        Assert.assertEquals(numTabs, tabsOpened, "The tabs are not the same");
    }

    @After
    public void after(){
        driver.quit();
    }
}
