package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;

public class QAElementsPage extends BasePage {

    public QAElementsPage(String pageUrl) {
        super(pageUrl);
    }


    //MENU BUTTOS

    public SelenideElement BUTTONS_MENU = $("[class='element-list collapse show'] [id='item-4'] span[class='text']");
    public SelenideElement WEB_TABLES_MENU = $("[class='element-list collapse show'] [id='item-3'] span[class='text']");


    //BUTTONS PAGE

    public SelenideElement CLICK_ME_BUTTON = $("button:not(#doubleClickBtn,#rightClickBtn).btn.btn-primary");
    public SelenideElement CLICK_ME_BUTTON_MSG = $("#dynamicClickMessage");


    //WEB TABLES PAGE

    public SelenideElement ADD_BUTTON = $("#addNewRecordButton");
    public SelenideElement SUBMIT_BUTTON = $("#submit");

    public SelenideElement FIRST_NAME_TXT = $("#firstName-wrapper #firstName");
    public SelenideElement LAST_NAME_TXT = $("#lastName-wrapper #lastName");
    public SelenideElement EMAIL_TXT = $("#userEmail-wrapper #userEmail");
    public SelenideElement AGE_TXT = $("#age-wrapper #age");
    public SelenideElement SALARY_TXT = $("#salary-wrapper #salary");
    public SelenideElement DEPARTMENT_TXT = $("#department-wrapper #department");


    public QAElementsPage openElementsMeuPages(String menuname) {

        switch (menuname) {
            case "Buttons":
                BUTTONS_MENU.click();
                break;
            case "Web Tables":
                WEB_TABLES_MENU.click();
                break;
        }

        return this;
    }

    public QAElementsPage clickMeButtons() {
        CLICK_ME_BUTTON.click();
        return this;
    }

    public QAElementsPage verifyClickMeBottonsMesage() {
        String message = CLICK_ME_BUTTON_MSG.getText();
        assertThat(message).isEqualTo("You have done a dynamic click");
        return this;
    }

    public QAElementsPage pressWebTablesButtons(String button) {
        switch (button) {
            case "Add":
                ADD_BUTTON.click();
                break;
            case "Submit":
                SUBMIT_BUTTON.click();
                break;
        }
        return this;
    }

    public QAElementsPage fillFirstName(String name) {
        FIRST_NAME_TXT.setValue(name);
        return this;
    }

    public QAElementsPage fillLastName(String lastname) {
        LAST_NAME_TXT.setValue(lastname);
        return this;
    }

    public QAElementsPage fillEmail(String email) {
        EMAIL_TXT.setValue(email);

        return this;
    }

    public QAElementsPage fillAge(String age) {
        AGE_TXT.setValue(age);
        return this;
    }

    public QAElementsPage fillSalary(String salary) {
        SALARY_TXT.setValue(salary);

        return this;
    }

    public QAElementsPage fillDepartment(String department) {
        DEPARTMENT_TXT.setValue(department);
        return this;
    }

    public int findEntry(String text) {

        ElementsCollection employee_elements = $$(".rt-table .rt-tbody [role='row']");

        int index = 0;

        for(int i=0; i<employee_elements.size();i++){
            if(employee_elements.get(i).getText().contains(text)){
                index = i+1;
                break;
            }
        }

        return index;
    }

    public QAElementsPage pressEntryEdit(String search) {
        $("#edit-record-" + findEntry(search)).click();
        return this;
    }



}
