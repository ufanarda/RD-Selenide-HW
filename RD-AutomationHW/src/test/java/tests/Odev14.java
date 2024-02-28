package tests;

import org.testng.annotations.Test;
import pages.QAElementsPageCSS;

public class Odev14 extends BaseTest{

    @Test
    public void testQAToolsButtonsPage() {
        QAElementsPageCSS css = new QAElementsPageCSS();
        css.openElementsMeuPages("Buttons").clickMeButtons().verifyClickMeBottonsMesage();
    }

    @Test
    public void testQAToolsWebTables() throws InterruptedException {
        QAElementsPageCSS css = new QAElementsPageCSS();
        css.openElementsMeuPages("Web Tables")
                .pressWebTablesButtons("Add")
                .fillFirstName("Arda").fillLastName("Ufan").fillEmail("ufan@arda.com").fillAge("77").fillSalary("5000").fillDepartment("QATest").pressWebTablesButtons("Submit")
                .pressEntryEdit("ufan@arda.com")
                .fillFirstName("Ufan").fillLastName("Arda").fillEmail("arda@ufan.com").fillAge("66").fillSalary("6000").fillDepartment("QAAutomation").pressWebTablesButtons("Submit")
                .waitForIt(10);
    }


}
