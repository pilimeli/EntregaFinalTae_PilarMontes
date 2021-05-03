package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WhoIsTravelingPage extends BasePage {
    /**
     * @param driver
     * @param wait
     */
    public WhoIsTravelingPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    @FindBy(xpath="//div[contains(text(),'Los Angeles (LAX) to Las Vegas (LAS)')]")
    private WebElement departure;

    @FindBy(xpath="//div[contains(text(),'Las Vegas (LAS) to Los Angeles (LAX)')]")
    private WebElement secondRound;

    @FindBy(css="h2[class='product-title']")
    private WebElement roundTrip;

    @FindBy(css="h3[class='your-price-summary']")
    private WebElement yourPriceSummary;

    @FindBy(id="complete-booking")
    private WebElement completeBooking;


    /**
     * Methods to get the information of the flight
     */

    public String informationOfDeparture(){
        useElementUntilClickable(departure);
        return departure.getText();
    }

    public String informationOfSecondRound(){
        return secondRound.getText();
    }

    public String informationOfRoundTrip(){
        return roundTrip.getText();
    }

    public String priceSummaryFlight(){
        return yourPriceSummary.getText();
    }
    public String completeBooking(){
        return completeBooking.getText();
    }


}
