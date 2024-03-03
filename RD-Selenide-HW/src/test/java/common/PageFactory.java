package common;

import pages.QAElementsPage;

public class PageFactory {

    public static QAElementsPage buildElementsPage(){
        return new QAElementsPage("/");
    }

}
