package com.autoc0de.pages;


import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import tests.MasterPage;

import java.util.List;

public class HomePage extends MasterPage {
    //PAGE INSTANCE


    //CONSTANTS

    private final String DESTINATION_INPUT_ID = "facet_with_bui_free_search_booking_header_toolbar_content";
    private final String DESTINATION_ID = "facet_search_box_basic_field_label";
    private final String DESTINATION_CONFIRMATION_ID = "view_disambiguation_destination_title";

    private final String OCCUPANCY_ID = "facet_search_box_accommodation_occupancy";
    private final String CLOSE_ACCESIBILITY_ID = "Navigate up";
    private String CHECK_IN_ACCESIBILITY_ID = "14 February 2023";
    private String CHECK_OUT_ACCESIBILITY_ID = "28 February 2023";
    private final String BUTTON_DATE_CONFIRMATION_ID = "facet_date_picker_confirm";

    private final String ADD_CHILD_ID = "bui_input_stepper_add_button";
    private final String AGE_OF_CHILD_XPATH = "//android.widget.Button[2]";
    private final String OK_BUTTON_ID = "android:id/button1";
    private final String APPLY_BUTTON_ID = "group_config_apply_button";
    private final String SEARCH_BUTTON_ID = "facet_search_box_cta";

    public HomePage() {
    }
    SoftAssert softAssert= new SoftAssert() ;
    //FUNCTIONS
    public void validateHomeScreen(){
        auto_setTapElement(MobileBy.AccessibilityId(CLOSE_ACCESIBILITY_ID));


    }

    public void searchDestination(String destination){
        auto_setTapElement(MobileBy.id(DESTINATION_ID));
        auto_setTextToInput(MobileBy.id(DESTINATION_INPUT_ID), destination);
      softAssert.assertEquals(auto_getElementText(MobileBy.id(DESTINATION_CONFIRMATION_ID)),"Cusco");
        auto_setTapElement(MobileBy.id(DESTINATION_CONFIRMATION_ID));

    }

    public void selectCheckInAndCheckOut(String checkIn,String checkOut){
        CHECK_IN_ACCESIBILITY_ID = checkIn;
        CHECK_OUT_ACCESIBILITY_ID= checkOut;
        auto_setTapElement(MobileBy.AccessibilityId(CHECK_IN_ACCESIBILITY_ID));
        auto_setTapElement(MobileBy.AccessibilityId(CHECK_OUT_ACCESIBILITY_ID));
        auto_setTapElement(MobileBy.id(BUTTON_DATE_CONFIRMATION_ID));


    }

    public void selectOccupancy(int ageChild){
        List<WebElement> addButtonChild ;
        auto_setTapElement(MobileBy.id(OCCUPANCY_ID));
        addButtonChild = auto_getWebElements(MobileBy.id(ADD_CHILD_ID));
        auto_setTapElement(addButtonChild.get(2));
        for  (int i = -1; i < ageChild;i++) auto_setTapElement(MobileBy.xpath(AGE_OF_CHILD_XPATH));
        auto_setTapElement(MobileBy.id(OK_BUTTON_ID));
        auto_setTapElement(MobileBy.id(APPLY_BUTTON_ID));

    }
    public void search(){
        auto_setTapElement(MobileBy.id(SEARCH_BUTTON_ID));
    }

}
