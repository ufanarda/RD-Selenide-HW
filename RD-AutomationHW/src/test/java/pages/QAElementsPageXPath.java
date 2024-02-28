package pages;

import drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class QAElementsPageXPath extends Driver {

    public QAElementsPageXPath() {
        super();
    }

    //MENU BUTTOS
    public static final By BUTTONS_MENU = By.xpath("//*[@id='item-4']//*[text()='Buttons']");
    public static final By WEB_TABLES_MENU = By.xpath("//*[@id='item-3']//*[text()='Web Tables']");

    //BUTTONS PAGE
    public static final By CLICK_ME_BUTTON = By.xpath("//button[text()='Click Me']");
    public static final By CLICK_ME_BUTTON_MSG = By.xpath("//*[@id='dynamicClickMessage']");


    //WEB TABLES PAGE
    public static final By ADD_BUTTON = By.xpath("//button[@id='addNewRecordButton']");
    public static final By SUBMIT_BUTTON = By.xpath("//button[@id='submit']");

    public static final By FIRST_NAME_TXT = By.xpath("//input[@id='firstName']");
    public static final By LAST_NAME_TXT = By.xpath("//input[@id='lastName']");
    public static final By EMAIL_TXT = By.xpath("//input[@id='userEmail']");
    public static final By AGE_TXT = By.xpath("//input[@id='age']");
    public static final By SALARY_TXT = By.xpath("//input[@id='salary']");
    public static final By DEPARTMENT_TXT = By.xpath("//input[@id='department']");

    public WebDriverWait webDriverWait;

    public QAElementsPageXPath waitForIt(long a) throws InterruptedException {
        TimeUnit.SECONDS.sleep(a);
        return this;
    }


    public void clickElement(By by) {
        driver.findElement(by).click();
    }

    public void fillTextField(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }


    public QAElementsPageXPath openElementsMeuPages(String menuname) {

        switch (menuname) {
            case "Buttons":
                //driver.findElement(BUTTONS_MENU).click();
                clickElement(BUTTONS_MENU);
                break;
            case "Web Tables":
                clickElement(WEB_TABLES_MENU);
                break;
        }

        return this;
    }


    public QAElementsPageXPath clickMeButtons() {
        clickElement(CLICK_ME_BUTTON);
        return this;
    }

    public QAElementsPageXPath verifyClickMeBottonsMesage() {
        String message = driver.findElement(CLICK_ME_BUTTON_MSG).getText();
        Assert.assertEquals(message, "You have done a dynamic click");
        return this;
    }

    public QAElementsPageXPath pressWebTablesButtons(String button) {
        switch (button) {
            case "Add":
                clickElement(ADD_BUTTON);

                break;
            case "Submit":
                clickElement(SUBMIT_BUTTON);
                break;

        }
        return this;
    }

    public QAElementsPageXPath fillFirstName(String name) {
        fillTextField(FIRST_NAME_TXT, name);
        return this;
    }

    public QAElementsPageXPath fillLastName(String lastname) {
        fillTextField(LAST_NAME_TXT, lastname);
        return this;
    }

    public QAElementsPageXPath fillEmail(String email) {
        fillTextField(EMAIL_TXT, email);

        return this;
    }

    public QAElementsPageXPath fillAge(String age) {
        fillTextField(AGE_TXT, age);
        return this;
    }

    public QAElementsPageXPath fillSalary(String salary) {
        fillTextField(SALARY_TXT, salary);

        return this;
    }

    public QAElementsPageXPath fillDepartment(String department) {
        fillTextField(DEPARTMENT_TXT, department);

        return this;
    }


    public int findEntry(String text) {
        List<WebElement> employee_elements = driver.findElements(By.xpath("//div[@role='rowgroup']"));

        int index = 0;
        for (int i = 0; i < employee_elements.size(); i++) {
            if (employee_elements.get(i).getText().contains(text)) {
                index = i + 1;
                System.out.println(employee_elements.get(i).getText());
                break;
            }
        }
        return index;
    }

    public QAElementsPageXPath pressEntryEdit(String search) {
        clickElement(By.xpath("//span[@id='edit-record-" + findEntry(search) + "']"));
        return this;
    }

}
