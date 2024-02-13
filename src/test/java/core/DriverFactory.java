package core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
            switch (Properties.browser) {
                case FIREFOX -> {
                    driver = new FirefoxDriver();
                    System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                }
                case CHROME -> {
                    driver = new ChromeDriver();
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                }
            }
            driver.manage().window().setSize(new Dimension(1390, 765));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }

        return driver;
    }

    public static void killDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
