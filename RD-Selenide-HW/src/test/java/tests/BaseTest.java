package tests;

import com.codeborne.selenide.Selenide;
import common.PageManager;
import driver.DriverFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected PageManager pageManager;

    @BeforeClass
    public void setUp(){
        pageManager = new PageManager();
    }


    @BeforeMethod
    public void openDriver() {
        Selenide.open();
    }

    @AfterMethod
    public void clearCookies() {
        DriverFactory.clearCookies();
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.close();
    }
}
