package Config;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.rmi.UnexpectedException;
import java.util.Properties;

public class TestContext {
    private RemoteWebDriver driver;
    private static String browser = "chrome";

    public TestContext() throws IOException {
        MutableCapabilities browserOption = new MutableCapabilities();
        browserOption.setCapability("browserName", browser);
        browserOption.setCapability("browserVersion", "latest");
        browserOption.setCapability("platformName", "Windows 10");
        browserOption.setCapability("screenResolution", "1920x1080");

        URL url = new URL("https://oauth-danielacuellart11-ead1c:69ff8608-858c-4c56-8832-1ed3213c2d45@ondemand.us-west-1.saucelabs.com:443/wd/hub");
        driver = new RemoteWebDriver(url, browserOption);
    }

    public void localSetting() throws IOException {

        InputStream file = new FileInputStream("resources/config.properties");
        Properties properties = new Properties();
        properties.load(file);
        switch(browser) {
            case "chrome":
                System.setProperty(properties.getProperty("PROPERTY_CHROME"), properties.getProperty("PATH_CHROME"));
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty(properties.getProperty("PROPERTY_FIRE"), properties.getProperty("PATH_FIRE"));
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty(properties.getProperty("PROPERTY_EDGE"), properties.getProperty("PATH_EDGE"));
                driver = new EdgeDriver();
                break;
            default:
                throw new UnexpectedException("the browser: " + browser + " is not an option");
        }
    }

    public RemoteWebDriver getDriver() {
        return driver;
    }

}
