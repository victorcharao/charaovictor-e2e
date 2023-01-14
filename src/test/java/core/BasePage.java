package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static core.DriverFactory.getDriver;


public class BasePage {

    public void navigateTo(String url){
        getDriver().navigate().to(url);
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public WebElement getElement(String cssSelector){
        return getDriver().findElement(By.cssSelector(cssSelector));
    }

    public void write(String cssSelector, String text){
        getElement(cssSelector).sendKeys(text);
    }

    public void click(String cssSelector){
        getElement(cssSelector).click();
    }

    public String getElementText(String cssSelector){
        return getElement(cssSelector).getText();
    }

    public boolean isElementDisplayed(String cssSelector){
        return getElement(cssSelector).isDisplayed();
    }
}