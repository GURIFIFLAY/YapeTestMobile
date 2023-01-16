package com.autoc0de.pages;


import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import tests.MasterPage;

import java.util.List;

public class SearchPage extends MasterPage {
    //PAGE INSTANCE


    //CONSTANTS
    private final String INFO_SEARCH_ID ="sr_toolbar";
    private final String PRICE_WEB_ELEMENT_LIST_ID ="price_view_price";
    public SearchPage()  {
    }
    SoftAssert softAssert= new SoftAssert() ;

    //FUNCTIONS

    public void validateSearchScreen() {
auto_waitForElementPresence(MobileBy.id(INFO_SEARCH_ID));
        System.out.println(auto_getElementText(MobileBy.id(INFO_SEARCH_ID)));
        softAssert.assertEquals(auto_getElementText(MobileBy.id(INFO_SEARCH_ID)),"Cusco");
    }
public void tapHotelsearch(int numberHotel){
    List<WebElement> priceWebElment= auto_getWebElements(MobileBy.id(PRICE_WEB_ELEMENT_LIST_ID));
    auto_setTapElement(priceWebElment.get(numberHotel-1));

}
}
