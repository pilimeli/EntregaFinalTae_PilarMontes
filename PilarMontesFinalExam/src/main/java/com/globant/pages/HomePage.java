package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {
    public final static String URL = "https://www.travelocity.com/";

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * Variables declaration
     */
    @FindBy(css=".uitk-tabs-container li:nth-child(2)")
    WebElement flightMenu;

    @FindBy(css="#location-field-leg1-origin-menu")
    WebElement leavingFromInput;

    @FindBy(css="#location-field-leg1-origin")
    WebElement listLeavingFromInput;

    @FindBy(xpath="//strong[contains(text(),'LAS - All Airports')]")
    WebElement selectFirtOptionLas;

    @FindBy(css="#location-field-leg1-destination-menu")
    WebElement selectGoingTo;

    @FindBy(css="#location-field-leg1-destination")
    WebElement listGoingTo;

    @FindBy(xpath="//strong[contains(text(),'LAX - Los Angeles Intl.')]")
    WebElement selectFirstOptionLax;

    @FindBy(id = "d1-btn")
    WebElement departingDateTextbox;

    @FindBy(css=".uitk-date-picker-month h2")
    List<WebElement> pickerMonth;

    @FindBy(css = ".uitk-button-paging:nth-child(2)")
    WebElement nextButton;

    @FindBy(css = "button[data-day=\"1\"]")
    List<WebElement> fromDay;

    @FindBy(css = "button[data-day=\"15\"]")
    List<WebElement> toDay;

    @FindBy(css = ".dialog-done")
    WebElement doneButton;

    @FindBy(css = "button[data-testid=\"submit-button\"]")
    WebElement searchButton;

    /**
     * Methods to implement with locators
     */
    public void goToFlightMenu (){
        useElementUntilClickable(flightMenu).click();
    }

    /**
     *
     * @param from
     * @param to
     */
    public void setFlightFilter(String from, String to){
        useElementUntilClickable(leavingFromInput).click();
        useElementUntilClickable(listLeavingFromInput).sendKeys(from);
        useElementUntilClickable(selectFirtOptionLas).click();
        useElementUntilClickable(selectGoingTo).click();
        useElementUntilClickable(listGoingTo).sendKeys(to);
        useElementUntilClickable(selectFirstOptionLax).click();
    }

    public void selectDepartingDate() {
        useElementUntilClickable(departingDateTextbox).click();

        //2 times
        useElementUntilClickable(nextButton).click();
        useElementUntilClickable(nextButton).click();

        // Select fromDay and toDay
        useElementUntilClickable(fromDay.get(0)).click();
        useElementUntilClickable(toDay.get(0)).click();

        //Click done
        useElementUntilClickable(doneButton).click();
    }

    public ResultPage search() {
        useElementUntilClickable(searchButton).click();
        return new ResultPage(getDriver(), getWait());
    }
}