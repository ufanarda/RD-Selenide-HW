package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Odev16 extends BaseTest{

    @BeforeMethod
    public void before(){
        pageManager.elementsPage.open();
    }

    @Test
    public void testQAToolsButtonsPage(){
        pageManager.elementsPage.openElementsMeuPages("Buttons")
                .clickMeButtons().verifyClickMeBottonsMesage();
    }

    @Test
    public void testQAToolsWebTables(){
        pageManager.elementsPage.openElementsMeuPages("Web Tables")
                .pressWebTablesButtons("Add")
                .fillFirstName("Arda").fillLastName("Ufan").fillEmail("ufan@arda.com").fillAge("77").fillSalary("5000").fillDepartment("QATest").pressWebTablesButtons("Submit")
                .pressEntryEdit("ufan@arda.com")
                .fillFirstName("Ufan").fillLastName("Arda").fillEmail("arda@ufan.com").fillAge("66").fillSalary("6000").fillDepartment("QAAutomation")
                .pressWebTablesButtons("Submit");
    }

}
