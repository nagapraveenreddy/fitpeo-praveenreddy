package testBase;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    public static Logger logger;

    @BeforeClass()
    public void setup() throws IOException {
        logger = LogManager.getLogger(this.getClass());

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.fitpeo.com/");
        driver.manage().window().maximize();
    }

    @AfterClass()
    public void tearDown(){
        driver.quit();
    }



}
