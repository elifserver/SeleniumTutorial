import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitExample {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        //<editor-fold desc="CHROME">
//           System.setProperty("webdriver.chrome.driver","/Users/elifalp/Documents/WS_Selenium/drivers/chromedriver");
//        driver = new ChromeDriver();
//        //</editor-fold>

        //<editor-fold desc="FIREFOX">
       // System.setProperty("webdriver.gecko.driver", "/Users/elifalp/Documents/WS_Selenium/drivers/geckodriver");
        driver = new FirefoxDriver();
        //</editor-fold>

        //<editor-fold desc="SAFARI">
        //System.setProperty("webdriver.chrome.driver","/Users/elifalp/Documents/WS_Selenium/drivers/chromedriver");
        //driver = new SafariDriver();
        //</editor-fold>
    }

    @Test
    public void implicitWaitExample() throws Exception {
        String text;

        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("window.scrollBy(0,1000)");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@name='q']\n")).sendKeys("Techlistic" + Keys.ENTER);

        List<WebElement> results = driver.findElements(By.xpath("//h3[@class='LC20lb DKV0Md']"));

        for (int i = 0; i < results.size(); i++
        ) {
            text = results.get(i).getText();
            System.out.println("result text for index = " + i + " ---> " + text);
        }
        results.get(0).click();
    }

    @Test
    public void explicitWaitExample() throws Exception {
        String text;

        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.xpath("//input[@name='q']\n")).sendKeys("Techlistic" + Keys.ENTER);

        //WAITsiz durumda :: Unable to locate element
        text = driver.findElement(By.xpath("//div[@id='result-stats']")).getText();

        //text = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='result-stats']"))).getText();
        System.out.println(text);
    }

    @After
    public void tearDown() throws Exception {

        Thread.sleep(5000);

        driver.quit();
    }
}
