package tests;

import org.testng.annotations.Test;
import pages.QAElementsPageXPath;

public class Odev15 extends BaseTest{
    @Test
    public void testQAToolsButtonsPage() {
        QAElementsPageXPath xpath = new QAElementsPageXPath();
        xpath.openElementsMeuPages("Buttons").clickMeButtons().verifyClickMeBottonsMesage();
    }

    @Test
    public void testQAToolsWebTables() throws InterruptedException {
        QAElementsPageXPath xpath = new QAElementsPageXPath();
        xpath.openElementsMeuPages("Web Tables")
                .pressWebTablesButtons("Add")
                .fillFirstName("Arda").fillLastName("Ufan").fillEmail("ufan@arda.com").fillAge("77").fillSalary("5000").fillDepartment("QATest").pressWebTablesButtons("Submit")
                .pressEntryEdit("ufan@arda.com")
                .fillFirstName("Ufan").fillLastName("Arda").fillEmail("arda@ufan.com").fillAge("66").fillSalary("6000").fillDepartment("QAAutomation").pressWebTablesButtons("Submit")
                .waitForIt(10);
    }
}
