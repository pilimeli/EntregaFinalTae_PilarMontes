package com.globant.pages;

import com.globant.utils.DateUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ResultPage extends BasePage {
    public final static String URL = "https://www.travelocity.com/";

    /**
     * Selectors second page
     */

    @FindBy(css = "button[data-test-id=\"select-link\"]")
    List<WebElement> searchResult;

    @FindBy(css = "option[data-test-id=\"sortDropdown-option\"]\n")
    private List<WebElement> lastElementList;

    @FindBy(css = "div[data-test-id=\"journey-duration\"]")
    List<WebElement> flightDurationResults;

    @FindBy(id = "listings-sort")
    private WebElement dropListDuration;

    @FindBy(css = "ul[data-test-id='listings'] li[data-test-id='offer-listing'] div[data-test-id='journey-duration']")
    private List<WebElement> durationFlight;

    @FindBy (css= "button[data-test-id='select-link']")
    List<WebElement> firstFlight;

    @FindBy(css="button[data-test-id='select-button']")
    private WebElement continueFlight;

    @FindBy(css="a[data-test-id=\"forcedChoiceNoThanks\"]")
    private WebElement noThanks;


    /**
     * Call secondpage
     * @param driver
     * @param wait
     */
    public ResultPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * Flights count and comparation
     * @return
     */
    public int countFlightResults() {
        return countElements(searchResult);
    }

    public int countFlightDurationResults() {
        return countElements(flightDurationResults);
    }

    /**
     * Sort dropdowm
     * @param item
     * @return
     */
    public boolean isSortContain(String item) {
        for (WebElement elements : lastElementList) {
            if (elements.getText().contains(item)) {
                return true;
            }
        }
        return false;

    }
    /**
    Sort By Duration
     */
    public void orderByDuration() {
        Select orderBy = new Select(dropListDuration);
        orderBy.selectByVisibleText("Duration (Shortest)");
        sleep(5000);

    }

    /**
     * Method to do the Duration Results
     * @return
     */
    public boolean isResultSorted() {
        List<Duration> originalDuration = new ArrayList<>();
        List<Duration> sortedDuration = new ArrayList<>();

        for (WebElement original : flightDurationResults) {
            Duration cleanDuration = DateUtils.getDuration(original.getText());

            originalDuration.add(cleanDuration);
            sortedDuration.add(cleanDuration);
        }
        Collections.sort(sortedDuration);

        for (int i=0; i < flightDurationResults.size(); i++) {
            if (!originalDuration.get(i).equals(sortedDuration.get(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     *Select First Flight LAS
     */
    public void selectFirstFlight(){
        sleep(5000);
        firstFlight.get(0).click();
    }

    /**
     * Clic On continue
     */

    public void clickOnContinue(){
        sleep(5000);
        continueFlight.click();
    }
    /**
     * Select third result Fligh LAX
     */
    public void selectThirdFlight(){
        sleep(5000);
        firstFlight.get(2).click();
    }
    public void noThanksbutton(){
        noThanks.click();
    }


}
