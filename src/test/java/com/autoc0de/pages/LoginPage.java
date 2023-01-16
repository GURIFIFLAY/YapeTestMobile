package com.autoc0de.pages;


import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import tests.MasterPage;

import java.util.List;

public class LoginPage extends MasterPage {
    //PAGE INSTANCE


    //CONSTANTS
    private final String LOGIN_WITH_EMAIL_ID ="identity_email_start";
    private final String TEXT_INPUT_ID ="identity_text_input_edit_text";
    private final String LOGIN_BUTTON_ID ="identity_landing_social_button_text";


    private final String TITLE_HOME_ID ="bui_title_title";


    public LoginPage() {
    }
    SoftAssert softAssert= new SoftAssert() ;

    //FUNCTIONS
    public void completeLogin(){
        auto_setTapElement(MobileBy.id(LOGIN_WITH_EMAIL_ID));
        auto_setTextToInput(MobileBy.id(TEXT_INPUT_ID), "nhxu_tpeou65@pihey.com");
        auto_setTapElement(MobileBy.id(LOGIN_BUTTON_ID));
        auto_setTextToInput(MobileBy.id(TEXT_INPUT_ID), "Yapetest123");
        auto_setTapElement(MobileBy.id(LOGIN_BUTTON_ID));

        Assert.assertTrue(auto_isElementVisible(MobileBy.id(TITLE_HOME_ID)));

    }











}
