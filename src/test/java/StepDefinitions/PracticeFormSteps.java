package StepDefinitions;

import Config.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.ModalPage;
import pages.PracticeForm;
import pages.SelectDatePage;

public class PracticeFormSteps {

    private WebDriver driver;
    private PracticeForm practiceForm;
    private SelectDatePage selectDatePage;
    private ModalPage modal;

    String month;
    String year;
    String day;
    String gender;
    String hobby;
    String city;
    String state;
    String file;

    public PracticeFormSteps(TestContext context){
        driver = context.getDriver();
        practiceForm = new PracticeForm(driver, new WebDriverWait(driver, 10));
    }

    @Given("^The user fills the form with: \"(.*)\" - \"(.*)\" - \"(.*)\" - \"(.*)\" - \"(.*)\" - \"(.*)\"$")
    public void clicksOnButtonPracticeForm(String name, String lastName, String email, String mobile, String subject, String address) {
        practiceForm.typeFirstName(name);
        practiceForm.typeLastName(lastName);
        practiceForm.typeEmail(email);
        practiceForm.typeMobile(mobile);
        practiceForm.typeSubject(subject);
        practiceForm.typeAddress(address);
    }

    @When("^The form was filled with: \"(.*)\" - \"(.*)\" - \"(.*)\" - \"(.*)\" - \"(.*)\" - \"(.*)\"$")
    public void validateTheNameField(String name, String lastName, String email, String mobile, String subject, String address){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(practiceForm.getFirstName(), name, "The name isn't the expected");
        softAssert.assertEquals(practiceForm.getLastName(), lastName, "The last name isn't the expected");
        softAssert.assertEquals(practiceForm.getEmail(), email, "The email isn't the expected");
        softAssert.assertEquals(practiceForm.getMobile(), mobile, "The mobile isn't the expected");
        softAssert.assertEquals(practiceForm.getSubject(), subject, "The subject isn't the expected");
        softAssert.assertEquals(practiceForm.getAddress(), address, "The address isn't the expected");
        softAssert.assertAll();
    }

    @And("The user selects a gender")
    public void theUserSelectsAGender() {
        gender = practiceForm.clickBtnGender();
        practiceForm.clickBirth();
    }

    @And("The user selects a date with day: {string}")
    public void theUserSelectsADate(String day) {
        selectDatePage = new SelectDatePage(driver);
        month = selectDatePage.selectMonth();
        year = selectDatePage.selectYear();
        selectDatePage.selectDay(day);
        this.day = day;
    }

    @And("The date are selected")
    public void theDateAreSelected() {
        practiceForm.assertDate(day, month, year);
    }

    @And("The user selects a hobby")
    public void theUserSelectsAHobby() {
        hobby = practiceForm.clickBtnHobbies();
    }

    @And("The user uploads an image with path: {string} and name: {string}")
    public void theUserUploadsAnImageWithPathAndName(String path, String file) {
        this.file = file;
        practiceForm.uploadImage(path+file);
    }

    @And("The user selects the state: {string} and city: {string}")
    public void theUserSelectsTheStateAndCity(String state, String city) {
        this.state = state;
        this.city = city;
        practiceForm.selectState(state);
        practiceForm.selectCity(city);
    }

    @And("The user sends the form")
    public void theUserSendsTheForm() {
        practiceForm.clickSubmit();
    }

    @Then("The modal shows the information: \"(.*)\" - \"(.*)\" - \"(.*)\" - \"(.*)\" - \"(.*)\" - \"(.*)\"$")
    public void theModalShowsTheInformation(String name, String lastName, String email, String mobile, String subject, String address) {
        modal = new ModalPage(driver);
        modal.assertModalIsPresent();
        modal.assertInformation(name, lastName, email, gender, mobile, day, month, year,
                subject, address, hobby, file, state, city);
    }
}
