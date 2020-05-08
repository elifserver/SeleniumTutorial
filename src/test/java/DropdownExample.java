import com.relevantcodes.extentreports.ExtentReports;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DropdownExample {
    WebDriver driver;
    ExtentReports report;
    @Before
    public void setUp() throws Exception {
        //<editor-fold desc="CHROME">
           //System.setProperty("webdriver.chrome.driver","/Users/elifalp/Documents/WS_Selenium/drivers/chromedriver");
        driver = new ChromeDriver();
//        //</editor-fold>

        //<editor-fold desc="FIREFOX">
       // System.setProperty("webdriver.gecko.driver", "/Users/elifalp/Documents/WS_Selenium/drivers/geckodriver");
        //driver = new FirefoxDriver();
        //</editor-fold>

        //<editor-fold desc="SAFARI">
        //System.setProperty("webdriver.chrome.driver","/Users/elifalp/Documents/WS_Selenium/drivers/chromedriver");
        //driver = new SafariDriver();
        //</editor-fold>
        report = new ExtentReports("//Users/elifalp/Desktop/report.html");
    }

    @Test
    public void DropdownAutoComplete() throws InterruptedException {
        String textToFind = "Istanbul Ataturk Airport\nIST";
        String partialText = "IST";

        driver.navigate().to("https://www.travelup.com/en-gb");
        WebElement element = driver.findElement(By.id("txtFlightDestinationAirport"));
        element.sendKeys(partialText);

        WebElement ulElement = driver.findElement(By.id("ui-id-2"));
        Thread.sleep(2000);
        String innerHTML = ulElement.getAttribute("innerHTML"); //IMPORTANT:::InnerHTML
        System.out.println(innerHTML);

        List<WebElement> liElementList = ulElement.findElements(By.tagName("li")); //IMPORTANT elementin icinde aramaca
        for (WebElement e:liElementList
             ) {
            if(e.getText().contains(textToFind))
            {
                e.click();
            }
            System.out.println(e.getText() + "\n");
        }
    }



    @After
    public void tearDown() throws Exception {

        Thread.sleep(5000);

        driver.quit();
        report.flush();
    }
}
