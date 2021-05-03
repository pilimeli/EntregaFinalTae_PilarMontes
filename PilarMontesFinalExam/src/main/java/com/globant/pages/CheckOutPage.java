package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckOutPage extends BasePage {
    public final static String URL = "https://www.travelocity.com/";

    /** call browser
     * @param driver
     * @param wait
     */

    public CheckOutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }



    @FindBy(xpath ="//h3[contains(text(),'Trip total')]")
    private WebElement priceTotalFlight ;

    @FindBy(xpath="//h2[contains(text(),'Las Vegas to Los Angeles')]")
    private WebElement losAngelesToLasVegas;

    @FindBy(xpath ="//h2[contains(text(),'Los Angeles to Las Vegas')]")
    private WebElement lasVegasToLosAngeles ;

    @FindBy(css="button[data-test-id='goto-checkout-button']")
    private WebElement checkoutBtn ;

    public String totalPriceFlight(){
        useElementUntilClickable(priceTotalFlight);
        return priceTotalFlight.getText();
    }


    public String informationFlightDeparture(){
        return losAngelesToLasVegas.getText();
    }

    public String informationFlightReturn(){
         return lasVegasToLosAngeles.getText();
    }

    public void clickOnCheckout(){
        checkoutBtn.click();
    }

}





