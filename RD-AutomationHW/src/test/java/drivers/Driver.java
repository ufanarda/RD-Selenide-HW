package drivers;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.time.Duration;

public class Driver {
    public static WebDriver driver;

    public WebDriver initializeDriver() throws MalformedURLException {
        driver = DriverFactory.getDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        return driver;
    }


    public void quitDriver() {
        driver.quit();
    }
}