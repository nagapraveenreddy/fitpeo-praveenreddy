package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RevenueCalculatorPage extends BasePage{

    //Calling Constructor
    public RevenueCalculatorPage(WebDriver driver){
        super(driver);
    }

    //Locators
    @FindBy(xpath = "//div[@class='MuiBox-root css-79elbk']")
    public WebElement sliderSection;
    @FindBy(xpath = "//span[contains(@class,'MuiSlider-root')]")
    public WebElement slider;
    @FindBy(xpath = "//input[@type='range']")
    public WebElement sliderHead;
    @FindBy(xpath = "//input[contains(@class,'MuiInputBase-input')]")
    public WebElement textField;
    @FindBy(xpath = "(//div[contains(@class,'MuiGrid-root')])[1]//div[1]//div[3]//p[2]")
    public WebElement totalRecurringReimbursement;


    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    public WebElement checkBox_CPT99091;
    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement checkBox_CPT99453;
    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    public WebElement checkBox_CPT99454;
    @FindBy(xpath = "(//input[@type='checkbox'])[8]")
    public WebElement checkBox_CPT99474;
    @FindBy(css="div[class='MuiBox-root css-m1khva'] p[class='MuiTypography-root MuiTypography-body1 inter css-12bch19']")
    public WebElement recurringValueElement;


    //------------------Action Methods-----------------------------------

    //Method to Adjust Slider
    public void moveSliderTo(String targetValue){
        moveSlider(slider,sliderHead,targetValue);
    }
    public void updateTextFieldTo(String targetValue){
        textField.click();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        actions.sendKeys(Keys.BACK_SPACE).perform();
        textField.sendKeys(targetValue);
    }
    public String getTextFieldValue(){
        return textField.getAttribute("value");
    }
    public String getSliderValue(){
        return sliderHead.getAttribute("value");
    }
    public String getTotalRecurringReimbursement(){
        return totalRecurringReimbursement.getText();
    }
    //Methods to select checkboxes
    public void selectCheckBox_CPT99091(){
        checkBox_CPT99091.click();
    }
    public void selectCheckBox_CPT99453(){
        checkBox_CPT99453.click();
    }
    public void selectCheckBox_CPT99454(){
        checkBox_CPT99454.click();
    }
    public void selectCheckBox_CPT99474(){
        checkBox_CPT99474.click();
    }

}
