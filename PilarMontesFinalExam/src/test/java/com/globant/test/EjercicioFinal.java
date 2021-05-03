package com.globant.test;

import com.globant.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class EjercicioFinal extends BaseTests {

    @BeforeMethod
    @Parameters({"browser"})
    public void initializeWebDriver(String browser) {
        initDriver(browser);

        driver.get(HomePage.URL);
    }

    /**
     Close the browser
     */
    @AfterMethod
    public void closeBrowser() {
      if (driver != null) {
          driver.close();
        }
    }

    /**
     * search a Flight
     */
    @Test (dataProvider = "flightdata", priority = 0)
    public void searchFlight(String from, String to) {
        HomePage homePage = new HomePage(driver, wait);

        homePage.goToFlightMenu();
        homePage.setFlightFilter(from, to);
        homePage.selectDepartingDate();
        ResultPage resultPage = homePage.search();

        /**
         *  Flight duration and comparate the results and dropdwon list
         */
        Assert.assertEquals(resultPage.countFlightResults(), resultPage.countFlightDurationResults());
        validateDropdown(resultPage);
        resultPage.orderByDuration();

        /**
         * Assert to see the Duration sort
         */
        Assert.assertTrue(resultPage.isResultSorted());
    }

    /**
     * Box to comparate dropdown list
     */
    private void validateDropdown(ResultPage resultPage){
        for (String item : dropDownList()){
            Assert.assertTrue(resultPage.isSortContain(item));
        }
    }

    /**
     * Select first result ,continue third result and continue
     * @return
     */
    @Test (dataProvider = "flightdata", priority = 1)
    public void validateFlightsPositionAndConfirmPage(String from, String to){
        HomePage homePage = new HomePage(driver, wait);
        homePage.goToFlightMenu();
        homePage.setFlightFilter(from, to);
        homePage.selectDepartingDate();
        ResultPage resultPage = homePage.search();
        resultPage.selectFirstFlight();
        resultPage.clickOnContinue();
        resultPage.selectThirdFlight();
        resultPage.clickOnContinue();
        resultPage.noThanksbutton();
        resultPage.changeToCheckOutPage("Flight Details");

        /**
         * ChecOutpage validations about price, departure and return flight
         */

         CheckOutPage checkOutPage = new CheckOutPage(driver,wait);


         Assert.assertEquals("Trip total", checkOutPage.totalPriceFlight());
         Assert.assertEquals("Las Vegas to Los Angeles", checkOutPage.informationFlightDeparture());
         Assert.assertEquals("Los Angeles to Las Vegas", checkOutPage.informationFlightReturn());
         checkOutPage.clickOnCheckout();
         }

    /**
     * Test Of Who's Traveling, five validations
     * @param from
     * @param to
     */

    @Test (dataProvider = "flightdata", priority = 2)
    public void validateWhoIsTraveling(String from, String to){
        HomePage homePage = new HomePage(driver, wait);
        homePage.goToFlightMenu();
        homePage.setFlightFilter(from, to);
        homePage.selectDepartingDate();
        ResultPage resultPage = homePage.search();
        resultPage.selectFirstFlight();
        resultPage.clickOnContinue();
        resultPage.selectThirdFlight();
        resultPage.clickOnContinue();
        resultPage.noThanksbutton();
        resultPage.changeToCheckOutPage("Flight Details");

        /**
         * ChecOutpage validations about price, departure and return flight
         */

        CheckOutPage checkOutPage = new CheckOutPage(driver,wait);


        Assert.assertEquals("Trip total", checkOutPage.totalPriceFlight());
        Assert.assertEquals("Las Vegas to Los Angeles", checkOutPage.informationFlightDeparture());
        Assert.assertEquals("Los Angeles to Las Vegas", checkOutPage.informationFlightReturn());
        checkOutPage.clickOnCheckout();

        /**
         * Validations five points
         */
        WhoIsTravelingPage whoisTravelingPage = new WhoIsTravelingPage(driver,wait);
        Assert.assertEquals(whoisTravelingPage.informationOfDeparture() ,"Los Angeles (LAX) to Las Vegas (LAS)");
        Assert.assertEquals(whoisTravelingPage.informationOfSecondRound() ,"Las Vegas (LAS) to Los Angeles (LAX)");
        Assert.assertEquals(whoisTravelingPage.informationOfRoundTrip() ,"Roundtrip flight");
        Assert.assertEquals(whoisTravelingPage.priceSummaryFlight() ,"Your price summary");
        Assert.assertEquals(whoisTravelingPage.completeBooking() ,"Complete Booking");
    }

    /**
     *
     * @return Data Filters flights
     */
    @DataProvider(name = "flightdata")
    public Object[][] getFlightData(){
        Object [][] roundtrip =new Object[1][2];
        roundtrip[0][0]="LAS";
        roundtrip[0][1]="LAX";
        return roundtrip;
     }

    /**
     * Return the box order by Price,departure, Arrival and duration
     */
    public List<String> dropDownList(){
        List<String> items = new ArrayList<>();
        items.add("Price");
        items.add("Duration");
        items.add("Departure");
        items.add("Arrival");
        return items;
    }
}




