package com.globant.test;
import org.testng.Assert;
import org.testng.annotations.*;
import com.globant.pages.HomePage;
import com.globant.pages.ResultPage;

public class EjercicioFinal extends BaseTests {

    @BeforeMethod
    @Parameters({"browser"})
    public void initializeWebDriver(String browser) {
        initDriver(browser);

        driver.get(HomePage.URL);
    }

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

        Assert.assertEquals(resultPage.countFlightResults(), resultPage.countFlightDurationResults());
    }

    

    /**
     *
     * @return Filters flights
     */

    @DataProvider(name = "flightdata")
    public Object[][] getFlightData(){
        Object [][] roundtrip =new Object[1][2];
        roundtrip[0][0]="LAS";
        roundtrip[0][1]="LAX";
        return roundtrip;
     }
}




