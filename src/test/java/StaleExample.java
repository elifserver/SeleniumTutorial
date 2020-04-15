import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StaleExample {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        //<editor-fold desc="CHROME">
//           System.setProperty("webdriver.chrome.driver","/Users/elifalp/Documents/WS_Selenium/drivers/chromedriver");
//        driver = new ChromeDriver();
//        //</editor-fold>

        //<editor-fold desc="FIREFOX">
        System.setProperty("webdriver.gecko.driver", "/Users/elifalp/Documents/WS_Selenium/drivers/geckodriver");
          driver = new FirefoxDriver();
        //</editor-fold>

        //<editor-fold desc="SAFARI">
        //System.setProperty("webdriver.chrome.driver","/Users/elifalp/Documents/WS_Selenium/drivers/chromedriver");
        //driver = new SafariDriver();
        //</editor-fold>
    }

    @Test
    public void staleExample1() throws Exception {
        String text;

        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("window.scrollBy(0,1000)");

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@name='q']\n")).sendKeys("Techlistic"+ Keys.ENTER);
        List<WebElement> results = driver.findElements(By.xpath("//div[@class='rc']//div[@class='r']//h3[@class='LC20lb DKV0Md']"));
        results.get(0).click();
        //We are not on Google results page anymore. Because of the click, driver landed to another page.
        for (int i = 0; i < results.size(); i++
             ) {
            text = results.get(i).getText();
            System.out.println("result text for index = " + i + " ---> " + text);
        }

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.quit();
    }
}
