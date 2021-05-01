package com.globant.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	private WebDriver driver;

	public DriverManager(String browser){
		switch (browser){
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "C:/SDK/Drivers/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			default:
				break;
		}
	}
	public WebDriver getDriver() {
		return this.driver;
	}
}