package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BasePage {
    private WebDriver driver;
    private WebDriverWait webdriverwait;



    /**
     * @param pDriver
     */
    public BasePage(WebDriver pDriver, String url) {
        PageFactory.initElements(pDriver, this);
        driver = pDriver;
        driver.get(url);
    }


    /**
     * Realiza wait
     *
     * @return
     */
    public WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        this.webdriverwait = wait;
        return webdriverwait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Buscar elemento visible por selector
     *
     * @param element
     */
    public void findElementUntilVisibility(String element) {
        getWait().until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(element))));
    }

    public void findElementUntilVisibility(By element) {
        getWait().until(ExpectedConditions.visibilityOf(driver.findElement(element)));
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }

    public WebElement useElementUntilClickable(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public int countElements(List<WebElement> elements) {
        getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements.size();
    }

    public void waitForFrameLoaded(WebElement element) {
        getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }


    /**
     * salir
     */
    public void dispose() {
        if (driver != null) {
            driver.close();
        }
    }
}


