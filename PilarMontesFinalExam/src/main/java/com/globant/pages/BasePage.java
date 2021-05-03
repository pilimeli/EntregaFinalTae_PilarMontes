package com.globant.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;


public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * @param driver
     */
    public BasePage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        initDriver(driver, wait);
    }

    public void initDriver(WebDriver pDriver, WebDriverWait webDriverWait) {
        driver = pDriver;
        wait = webDriverWait;
    }

    /**
     * Get wait
     * @return
     */
    public WebDriverWait getWait() {
        return wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement useElementUntilClickable(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public int countElements(List<WebElement> elements) {
        getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements.size();
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }

}


