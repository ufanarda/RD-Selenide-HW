package common;

import driver.DriverFactory;
import pages.QAElementsPage;

public class PageManager {
    public QAElementsPage elementsPage;

    public PageManager(){
        DriverFactory.initDriver();
        elementsPage = PageFactory.buildElementsPage();
    }


}
