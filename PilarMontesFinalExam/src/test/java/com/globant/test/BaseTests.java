package com.globant.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.globant.utils.DriverManager;

public class BaseTests {
    public static WebDriver driver;
    protected WebDriverWait wait;

    public void initDriver(String browser) {
        driver = new DriverManager(browser).getDriver();
        wait = new WebDriverWait(driver, 40);
        driver.manage().window().maximize();
    }
}
