package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;
    Actions actions;
    public BasePage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    // JavaScriptExecutor method to execute any script
    public void executeJavaScript(String script, Object... args) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, args);
    }

    // Method to scroll an element into view
    public void scrollIntoView(WebElement element) {
        executeJavaScript("arguments[0].scrollIntoView(true);", element);
    }

    // Generic method to move a slider to a specific value
    public void moveSlider(WebElement slider,WebElement sliderHead ,String targetValue) {
        int minValue = Integer.parseInt(sliderHead.getAttribute("min")) ;
        int maxValue = Integer.parseInt(sliderHead.getAttribute("max")) ;
        int sliderWidth = slider.getSize().width;
        double pixelsPerUnit = (double) sliderWidth / (maxValue - minValue);
        int offset = (int) ((Integer.parseInt(targetValue) - minValue) * pixelsPerUnit);
        actions.dragAndDropBy(slider,offset-149, 0).perform();
        actions.keyDown(Keys.ARROW_LEFT).keyUp(Keys.ARROW_LEFT).perform();
        actions.keyDown(Keys.ARROW_LEFT).keyUp(Keys.ARROW_LEFT).perform();
        actions.keyDown(Keys.ARROW_LEFT).keyUp(Keys.ARROW_LEFT).perform();
    }

    // Utility method to retrieve the value of a field
    public String getElementValue(WebElement element) {
        return element.getAttribute("value");
    }

}
