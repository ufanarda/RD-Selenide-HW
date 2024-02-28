package pages;

import drivers.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class QAElementsPageCSS extends Driver {

    public QAElementsPageCSS() {
        super();
    }

    //MENU BUTTOS
    public static final By BUTTONS_MENU = By.cssSelector("[class='element-list collapse show'] [id='item-4'] span[class='text']");
    public static final By WEB_TABLES_MENU = By.cssSelector("[class='element-list collapse show'] [id='item-3'] span[class='text']");

    //BUTTONS PAGE
    public static final By CLICK_ME_BUTTON = By.cssSelector("button:not(#doubleClickBtn,#rightClickBtn).btn.btn-primary");
    //    public static final By CLICK_ME_BUTTON = By.xpath("//button[text()='Click Me']")
    public static final By CLICK_ME_BUTTON_MSG = By.cssSelector("#dynamicClickMessage");


    //WEB TABLES PAGE
    public static final By ADD_BUTTON = By.cssSelector("#addNewRecordButton");
    public static final By SUBMIT_BUTTON = By.cssSelector("#submit");

    public static final By FIRST_NAME_TXT = By.cssSelector("#firstName-wrapper #firstName");
    public static final By LAST_NAME_TXT = By.cssSelector("#lastName-wrapper #lastName");
    public static final By EMAIL_TXT = By.cssSelector("#userEmail-wrapper #userEmail");
    public static final By AGE_TXT = By.cssSelector("#age-wrapper #age");
    public static final By SALARY_TXT = By.cssSelector("#salary-wrapper #salary");
    public static final By DEPARTMENT_TXT = By.cssSelector("#department-wrapper #department");

    public WebDriverWait webDriverWait;

    public QAElementsPageCSS waitForIt(long a) throws InterruptedException {
        TimeUnit.SECONDS.sleep(a);
        return this;
    }


    public void clickElement(By by) {
       driver.findElement(by).click();
    }

    public void fillTextField(By by, String text){
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }



    public QAElementsPageCSS openElementsMeuPages(String menuname) {

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


    public QAElementsPageCSS clickMeButtons() {
        clickElement(CLICK_ME_BUTTON);
        return this;
    }

    public QAElementsPageCSS verifyClickMeBottonsMesage() {
        String message = driver.findElement(CLICK_ME_BUTTON_MSG).getText();
        Assert.assertEquals(message, "You have done a dynamic click");
        return this;
    }

    public QAElementsPageCSS pressWebTablesButtons(String button) {
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

    public QAElementsPageCSS fillFirstName(String name) {
        fillTextField(FIRST_NAME_TXT, name);
        return this;
    }

    public QAElementsPageCSS fillLastName(String lastname) {
        fillTextField(LAST_NAME_TXT, lastname);
        return this;
    }

    public QAElementsPageCSS fillEmail(String email) {
        fillTextField(EMAIL_TXT, email);

        return this;
    }

    public QAElementsPageCSS fillAge(String age) {
        fillTextField(AGE_TXT, age);
        return this;
    }

    public QAElementsPageCSS fillSalary(String salary) {
        fillTextField(SALARY_TXT, salary);

        return this;
    }

    public QAElementsPageCSS fillDepartment(String department) {
        fillTextField(DEPARTMENT_TXT, department);

        return this;
    }


    public int findEntry(String text) {
        List<WebElement> employee_elements = driver.findElements(By.cssSelector(".rt-table .rt-tbody [role='row']"));

        int index = 0;
        for(int i=0; i< employee_elements.size();i++){
            if (employee_elements.get(i).getText().contains(text)){
                index = i+1;
                break;
            }
        }
        return index;
    }

    public QAElementsPageCSS pressEntryEdit(String search) {
        clickElement(By.cssSelector("#edit-record-" + findEntry(search)));
        return this;
    }

}
