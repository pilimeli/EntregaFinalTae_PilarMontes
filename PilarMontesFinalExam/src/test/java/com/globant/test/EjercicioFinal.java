package com.globant.test;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.EjercicioPage;

public class EjercicioFinal extends BaseTests {
    EjercicioPage page;


    @BeforeSuite
    @Parameters({"browser"})
    public void setUppage(String browser) {
        initDriver(browser);
        page = new EjercicioPage(driver);
    }

    //@AfterMethod
    //public void cerrarPage() {
        //page.dispose();
   // }

    /**
     * search a Flight
     */
    @Test (dataProvider = "flightdata", priority = 0)
    public void searchFlight(String from, String to) {
        page.goToFlightMenu();
        page.setFlightFilter(from, to);
        page.selectDepartingDate();
        page.clickOnSearch();


        Assert.assertEquals(page.countFlightResults(), page.countFlightDurationResults());

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




