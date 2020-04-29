import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumRecovery {
    private WebDriver driver;

    public WebElement waitForPresence(By by){
        WebDriverWait wait=new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    @Test
    public void skyScannerForm() {
        driver.navigate().to("https://www.skyscanner.net/flights");

        //one way
        waitForPresence(By.id("fsc-trip-type-selector-one-way")).click();

        //London
        waitForPresence(By.id("fsc-origin-search")).sendKeys("LON");
        WebElement fromList = waitForPresence(By.id("react-autowhatever-fsc-origin-search"));
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        fromList.findElement(By.xpath("//span[contains(text(),'don Stan')]")).click();

        //Barcelona
        waitForPresence(By.id("fsc-destination-search")).sendKeys("Bar");
        WebElement toList = waitForPresence(By.id("react-autowhatever-fsc-destination-search"));
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        toList.findElement(By.xpath("//span[contains(text(),'BCN')]")).click();

        //30.0.2020
        waitForPresence(By.id("depart-fsc-datepicker-button")).click();
        waitForPresence(By.xpath("//button[@aria-label='Thursday, 30 April 2020']")).click();

        //direct flight
        waitForPresence(By.xpath("//input[@name='directOnly']")).click();
        waitForPresence(By.xpath("//button[@aria-label='Search flights']")).click();
    }


    @Before
    public void setupChrome() {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver=new ChromeDriver();
    }

//    @Before
    public void setupOpera() {
        System.setProperty("webdriver.opera.driver","drivers/operadriver");
        driver=new OperaDriver();
    }



    @Test
    public void findElement() {
        driver.navigate().to("https://www.travelup.com/en-gb");
        driver.findElement(By.linkText("Flights"));
        driver.findElement(By.xpath("//div[@class='tile third']//h4[contains(text(),'Get prices')]"));
    }

    @Test
    public void findElements() {
        driver.navigate().to("https://www.skyscanner.net/flights");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='tile third']//h4"));
        for (WebElement e: elements
             ) {
            System.out.println("e.getText() = " + e.getText());
        }
    }


    @After
    public void quit() {
        driver.quit();
    }
}
