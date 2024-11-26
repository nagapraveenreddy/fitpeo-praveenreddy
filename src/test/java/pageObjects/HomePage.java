package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'Revenue Calculator')]")
    WebElement linkRevenueCalculator;

    public void clickLinkRevenueCalculator(){
        linkRevenueCalculator.click();
    }
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }
}
