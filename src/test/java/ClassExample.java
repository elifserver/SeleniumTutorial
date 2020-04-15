import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Timeout;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import java.util.concurrent.TimeUnit;

public class ClassExample {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        //<editor-fold desc="CHROME">
           System.setProperty("webdriver.chrome.driver","/Users/elifalp/Documents/WS_Selenium/drivers/chromedriver");
        driver = new ChromeDriver();
//        //</editor-fold>

        //<editor-fold desc="FIREFOX">
        //System.setProperty("webdriver.gecko.driver", "/Users/elifalp/Documents/WS_Selenium/drivers/geckodriver");
        //  driver = new FirefoxDriver();
        //</editor-fold>

        //<editor-fold desc="SAFARI">
        //driver = new SafariDriver();
        //</editor-fold>
    }

    @Test
    public void testMethod1() throws Exception {
        String pageTitle;

        driver.get("http://facebook.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("email")).sendKeys("e@e.com");
        driver.findElement((By.className("login_form_login_button uiButton uiButtonConfirm")));
        //driver.findElement(By.xpath("//label[contains(@class,'uiButtonConfirm')]")).click();
        //driver.findElement(By.className("uiButtonConfirm")).click();
        pageTitle = driver.getTitle();
        //Assert.assertTrue(pageTitle.equals("Log in to Facebook | Facebook"));
        //Assert.assertTrue(pageTitle.equals("Facebook – log in or sign up"));

    }



    @After
    public void tearDown() throws Exception {
        Thread.sleep(1000);
        driver.quit();
    }
}
