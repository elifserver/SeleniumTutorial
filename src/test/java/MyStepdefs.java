import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    WebDriver driver;

    @Before
    public  void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
    }

    public WebElement waitForPresence(By by){
        WebDriverWait wait=new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    @After
    public  void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


    @Given("user views skyscanner_page")
    public void userViewsSkyscanner_page() {
        driver.navigate().to("https://www.skyscanner.net/flights");

    }

    @When("user clicks ONE_WAY")
    public void userClicksONE_WAY() {
        waitForPresence(By.id("fsc-trip-type-selector-one-way")).click();
    }

    @And("user enters LON on DEPARTURE area")
    public void userEntersLONOnDEPARTUREArea() {
        waitForPresence(By.id("fsc-origin-search")).sendKeys("LON");
    }


    @And("user clicks LONDON_STANDON")
    public void userClicksLONDON_STANDON() {
        WebElement fromList = waitForPresence(By.id("react-autowhatever-fsc-origin-search"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        fromList.findElement(By.xpath("//span[contains(text(),'don Stan')]")).click();
    }

    @And("user enters BAR on ARIVAL area")
    public void userEntersBAROnARIVALArea() {
        waitForPresence(By.id("fsc-destination-search")).sendKeys("Bar");
    }

    @And("user clicks Barcelona")
    public void userClicksBarcelona() {
        WebElement toList = waitForPresence(By.id("react-autowhatever-fsc-destination-search"));
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        toList.findElement(By.xpath("//span[contains(text(),'BCN')]")).click();
    }

    @And("user clicks DatePicker")
    public void userClicksDatePicker() {
        waitForPresence(By.id("depart-fsc-datepicker-button")).click();
    }

    @And("user clicks {string}")
    public void userClicks(String arg0) {
        waitForPresence(By.xpath("//button[@aria-label='Thursday, 30 April 2020']")).click();
    }

    @And("user clicks DIRECT_FLIGHT")
    public void userClicksDIRECT_FLIGHT() {
        waitForPresence(By.xpath("//input[@name='directOnly']")).click();
    }

    @Then("user clicks SEARCH_BUTTON")
    public void userClicksSEARCH_BUTTON() {
        waitForPresence(By.xpath("//button[@aria-label='Search flights']")).click();
    }


    @And("user should see flight options")
    public void userShouldSeeFlightOptions() {

    }

}
