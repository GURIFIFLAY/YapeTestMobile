package com.autoc0de.pages;


import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import tests.MasterPage;

import java.util.List;

public class HotelPage extends MasterPage {
    //PAGE INSTANCE


    //CONSTANTS
    private final String CHECK_IN_AND_OUT_ID ="toolbar_subtitle_textView";
    private final String SELECT_BUTTON_ROOM_ID ="select_room_cta";
    private final String SELECT_ROOMS_LAYOUT_ID ="rooms_item_select_layout";

    private final String RESERVE_PRICE_ID = "price_view_price";

    private String priceRoom ;
    private final String RESERVE_BUTTON_ID = "main_action";


    public HotelPage()  {
    }
    SoftAssert softAssert= new SoftAssert() ;

    //FUNCTIONS

    public void validateHotelScreen() {
auto_waitForElementPresence(MobileBy.id(CHECK_IN_AND_OUT_ID));
        softAssert.assertEquals(auto_getElementText(MobileBy.id(CHECK_IN_AND_OUT_ID)),"Feb 14 - Feb 28");
    }
public void tapSelectRooms(int room){
    auto_setTapElement(MobileBy.id(SELECT_BUTTON_ROOM_ID));
    List<WebElement> selectRoomWebElment= auto_getWebElements(MobileBy.id(SELECT_ROOMS_LAYOUT_ID));
auto_setTapElement(selectRoomWebElment.get(room-1));
auto_setTapElement(MobileBy.id(RESERVE_BUTTON_ID));
}

public void priceRoom (){
        setPriceRoom(auto_getElementText(MobileBy.id(RESERVE_PRICE_ID)));
}
public void setPriceRoom(String arg0){
        this.priceRoom= arg0;
}

    public String getPriceRoom() {
        return priceRoom;
    }
}
