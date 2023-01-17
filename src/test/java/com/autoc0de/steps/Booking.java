package com.autoc0de.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.autoc0de.pages.*;

import java.util.Arrays;
import java.util.List;

public class Booking {

    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    HotelPage hotelPage = new HotelPage();
    PayPage payPage = new PayPage();


    @Given("I am on the booking website homepage")
    public void iAmOnTheBookingWebsiteHomepage() {
        homePage.validateHomeScreen();
    }

    @When("I search for available hotels in {string}")
    public void iSearchForAvailableHotelsIn(String arg0) {
        homePage.searchDestination(arg0);
    }

    @And("I select the check-in date {string} and check-out date {string}")
    public void iSelectTheCheckInDateAndCheckOutDate(String arg0, String arg1) {
        homePage.selectCheckInAndCheckOut(arg0,arg1);
    }

    @And("I select {int} room, {int} adults and {int} child of {int} years old")
    public void iSelectRoomAdultsAndChildOfYearsOld(int arg0, int arg1, int arg2, int arg3) {
        homePage.selectOccupancy(arg3);
    }



    @Then("I should see a confirmation page with the details of my reservation")
    public void iShouldSeeAConfirmationPageWithTheDetailsOfMyReservation() {
        payPage.auto_genericScroll(50,1850,50,300);
        payPage.validatePrice(hotelPage.getPriceRoom());


    }

    @And("I choose the {int}nd hotel from the search results")
    public void iChooseTheNdHotelFromTheSearchResults(int arg0) {
        homePage.search();
        searchPage.validateSearchScreen();
        searchPage.tapHotelsearch(arg0);
    }

    @And("I select the {int} option of room type")
    public void iSelectTheFirstOptionOfRoomType(int arg0) {
        hotelPage.validateHotelScreen();
        hotelPage.priceRoom();
        hotelPage.tapSelectRooms(arg0);
    }

    @And("I enter my card info {string}, {string}, {string} and confirm the reservation")
    public void iEnterCardExpCVCAndConfirmTheReservation(String arg0,String arg1,String arg2) {
        List<String> dataForm = Arrays.asList(arg0, arg1, arg2);
        payPage.validatePrice(hotelPage.getPriceRoom());
        payPage.completeCreditCardForm(dataForm);
    }

    @And("I enter my personal info {string}, {string}, {string},{string},{string}")
    public void iEnterMyPersonalInfo(String arg0, String arg1, String arg2, String arg3, String arg4) {
        List<String> dataForm = Arrays.asList(arg0, arg1, arg2,arg3,arg4);
        payPage.validatePayScreen();
        payPage.completeForm(dataForm);

    }

    @And("I dont enter my personal info")
    public void iDontEnterMyPersonalInfo() {
        payPage.tapContact();
    }


    @Then("I should see a alert with {string}")
    public void iShouldSeeAAlertWith(String arg0) {
        payPage.validateAlert(arg0);
    }
}