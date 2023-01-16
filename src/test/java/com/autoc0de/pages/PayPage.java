
package com.autoc0de.pages;


import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import tests.MasterPage;

import java.util.List;

public class PayPage extends MasterPage {
    //PAGE INSTANCE


    //CONSTANTS
    private final String CONTACT_FORM_ID = "bstage1_contact_layout";
    private final String CONTACT_INPUT_ID = "bui_input_container_content";
    private final String PRIMARY_PURPOSE_CHECKBOX_ID = "business_purpose_leisure";
    private final String TOTAL_OVERVIEW_ID = "bp_price_summary_total_price_value";
    private final String TOTAL_OVERVIEW_FULL_ID = "bp_price_summary_total_price_strikethrough_price_view";
    private final String FINAL_PRICE_ID = "title";

    private final String CREDIT_CARD_INPUT_ID = "new_credit_card_number_edit";
    private final String EXPIRATION_CARD_INPUT_ID = "new_credit_card_expiry_date_edit";

    private final String CVC_INPUT_ID = "new_credit_card_cvc_edit_text";
    private final String MAIN_BUTTON_ID = "action_button";


    public PayPage() {
    }

    SoftAssert softAssert = new SoftAssert();

    //FUNCTIONS

    public void validatePayScreen() {
        auto_waitForElementPresence(MobileBy.id(CONTACT_FORM_ID));
    }

    public void completeForm(List<String> dataForm) {
        List<WebElement> inputTextElements = auto_getWebElements(MobileBy.id(CONTACT_INPUT_ID));
        for (int i = 0; i < inputTextElements.size(); i++)
            auto_setTextToInput(inputTextElements.get(i), dataForm.get(i));
        auto_selectCheckbox(MobileBy.id(PRIMARY_PURPOSE_CHECKBOX_ID));
        auto_setTapElement(MobileBy.id(MAIN_BUTTON_ID));
    }

    public void validatePrice(String arg0) {
        Assert.assertEquals( auto_getElementText(MobileBy.id(TOTAL_OVERVIEW_ID)), arg0);
    }

    public void completeCreditCardForm(List<String> dataForm ) {
        auto_setTapElement(MobileBy.id(MAIN_BUTTON_ID));
        auto_setTextToInput(MobileBy.id(CREDIT_CARD_INPUT_ID),dataForm.get(0));
        auto_setTextToInput(MobileBy.id(EXPIRATION_CARD_INPUT_ID),dataForm.get(1));
       auto_isElementVisible(MobileBy.id(CVC_INPUT_ID));
       auto_setTextToInput(MobileBy.id(CVC_INPUT_ID),dataForm.get(2));
       auto_isElementPresent(MobileBy.id(MAIN_BUTTON_ID));
    }

}