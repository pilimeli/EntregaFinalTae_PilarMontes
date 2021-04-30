package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;


public class EjercicioPage extends BasePage {

    /**
     *
     * @param pDriver  Open Browser
     */

    public EjercicioPage(WebDriver pDriver) {
        super(pDriver, "https://www.travelocity.com/");
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

    @FindBy(css = ".uitk-button-paging:nth-child(2)")
    WebElement nextButton;

    @FindBy(css = "button[data-day=\"1\"]")
    List<WebElement> dayNumberOne;

    @FindBy(css = "button[data-day=\"15\"]")
    List<WebElement> toDay;

    @FindBy(css = ".dialog-done")
    WebElement doneButton;



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

    /**
     * Select de date
     */
    public void selectDepartingDate() {
        useElementUntilClickable(departingDateTextbox).click();

        /**
         * Clic 2 times
         */
        useElementUntilClickable(nextButton).click();
        useElementUntilClickable(nextButton).click();

        /** Select first day of month until 15
         *
         */
        useElementUntilClickable(dayNumberOne.get(0)).click();
        useElementUntilClickable(toDay.get(0)).click();

        /**
         * clic Done
         */
        useElementUntilClickable(doneButton).click();


    }




}




