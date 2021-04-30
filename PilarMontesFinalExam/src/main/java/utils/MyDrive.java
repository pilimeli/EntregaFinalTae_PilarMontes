package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyDrive {

    public class MyDriver {
        private WebDriver driver;

        public MyDriver(String browser){
            switch (browser){
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "C:/sdk/Drivers/chromedriver.exe");
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

}
