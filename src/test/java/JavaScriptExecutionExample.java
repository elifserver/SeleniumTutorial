import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class JavaScriptExecutionExample {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        //<editor-fold desc="CHROME">
          System.setProperty("webdriver.chrome.driver","/drivers/chromedriver");
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
    public void findingElements() throws Exception {

        driver.get("http://facebook.com");
        // driver.manage().window().maximize();

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.location = 'http://facebook.com';");

        Long height = ((Long) js.executeScript("return window.innerHeight;"));
        Long width = ((Long) js.executeScript("return window.innerWidth"));
        System.out.println("height = " + height + "\twidth = " + width);


//        WebElement element = (WebElement) js.executeScript("return document.getElementById('email');");
//        element.sendKeys("elif");

        //finding and element using Id
        js.executeScript("document.getElementById('email').value = 'elif';");

        //find an element using querySelector
        js.executeScript("document.querySelector('#loginbutton').click()");

        driver.findElement(By.xpath("//a[contains(@class,'signup_btn _4jy4 _4jy2')]")).click();
    }

    @Test
    public void scrollingDown() throws InterruptedException {
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.findElement(By.id("cookieChoiceDismiss")).click();
        Thread.sleep(1000);
        JavascriptExecutor js = ((JavascriptExecutor) driver);

        //1.1:  scrolls till the end of the document
        // js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        // Thread.sleep(5000);
        //scrolls till the top of the document
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight * -1);");

        //1.2: scrolls till the end of the document
        //js.executeScript("window.scrollBy(0, 3500);");
        // Thread.sleep(2000);
        //scrolls till the top of the document
        //js.executeScript("window.scrollBy(0, -3500);");

        //2. scrolls till a desired height
        //js.executeScript("scroll(0, 500)");
        // Thread.sleep(5000);


        //3. scrolls to an element
        WebElement element = driver.findElement((By.id("profession-1")));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(5000);
    }

    @Test
    public void ClickElementWithJS() {
        driver.get("http://facebook.com");
        JavascriptExecutor js = ((JavascriptExecutor) driver);

        //Way - 1
        // js.executeScript("document.getElementById('loginbutton').click();");

        //Way - 2
        WebElement element = driver.findElement(By.id("loginbutton"));
        js.executeScript("arguments[0].click();", element);
    }

    @Test
    public void ClickElemetTrendyol() throws InterruptedException {

        /**
         * Important: Without WAIT usage, test is not stable.
         * Try it...
         */

        driver.navigate().to("https://www.trendyol.com/");
        WebDriverWait wait = new WebDriverWait(driver,2);

        //WebElement closeModalButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='fancybox-item fancybox-close']")));
        WebElement closeModalButton = driver.findElement(By.xpath("//a[@class='fancybox-item fancybox-close']"));

        //Close the modal window using WebDriver
        //closeModalButton.click();

        //Close the modal window using JSExecuter
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", closeModalButton);

        //driver.findElement(By.xpath("//a[@class='user-actions-join-now']")).click();
    }

    @Test
    public void name() {
        driver.navigate().to("https://www.facebook.com/");

        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("elif server alp");

        WebElement years = driver.findElement(By.id("year"));
        Select yearsSelect = new Select(years);
        yearsSelect.selectByVisibleText("1980");


    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.quit();
    }
}
