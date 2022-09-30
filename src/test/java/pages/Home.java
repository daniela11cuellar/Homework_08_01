package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    WebDriver driver;
    WebDriverWait wait;

    By btnForms = By.xpath("//*[ contains (text(), 'Forms')]");
    By adds = By.id("fixedban");
    By headerForm = By.className("main-header");

    public Home(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickBtnForms(){
        WebElement element = driver.findElement(btnForms);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        driver.findElement(btnForms).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(headerForm));
    }

    public void removeAds() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(adds));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('fixedban').remove();");
    }
}
