package tests;

import drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyManager;

import java.net.MalformedURLException;

public class BaseTest {


    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager = new PropertyManager();
    String url = propertyManager.getProperty("APP_URL");


    @BeforeMethod(alwaysRun = true)
    public void before() throws MalformedURLException {
        driver = webDriver.initializeDriver();
        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        webDriver.quitDriver();
    }
}


