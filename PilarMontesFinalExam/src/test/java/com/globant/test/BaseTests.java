package com.globant.test;

import org.openqa.selenium.WebDriver;
import utils.MyDrive;

public class BaseTests extends MyDrive {

    protected MyDriver myDriver;
    protected WebDriver driver;

    /**
     * Levantar el Browser
     *
     * @param browser
     */
    public void initDriver(String browser) {
        myDriver = new MyDriver(browser);
        driver = myDriver.getDriver();
        driver.manage().window().maximize();
    }
}
