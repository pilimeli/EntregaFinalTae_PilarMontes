package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ResultPage extends BasePage {
    @FindBy(css = "button[data-test-id=\"select-link\"]")
    List<WebElement> searchResult;

    @FindBy(css = "div[data-test-id=\"journey-duration\"]")
    List<WebElement> flightDurationResults;

    public ResultPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public int countFlightResults() {
        return countElements(searchResult);
    }

    public int countFlightDurationResults() {
        return countElements(flightDurationResults);
    }
}
