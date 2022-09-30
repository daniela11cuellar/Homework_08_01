package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Forms {

    WebDriver driver;
    WebDriverWait wait;

    By btnPractice = By.xpath("//*[ contains (text(), 'Practice')]");
    By titleForms = By.className("practice-form-wrapper");

    public Forms(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickBtnPractice(){
        driver.findElement(btnPractice).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(titleForms));
    }
}
