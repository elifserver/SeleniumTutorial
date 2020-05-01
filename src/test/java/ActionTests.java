import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class ActionTests {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        //<editor-fold desc="CHROME">
//        System.setProperty("webdriver.chrome.driver","/Users/acelik/Desktop/Work/chromedriver");
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
//        //</editor-fold>

//        <editor-fold desc="FIREFOX">
//        System.setProperty("webdriver.gecko.driver", "/Users/elifalp/Documents/WS_Selenium/drivers/geckodriver");
//          WebDriver driver = new FirefoxDriver();
//        </editor-fold>
//
//        <editor-fold desc="SAFARI">
//        System.setProperty("webdriver.chrome.driver","/Users/elifalp/Documents/WS_Selenium/drivers/chromedriver");
//         WebDriver driver = new SafariDriver();
//        </editor-fold>
//
//        driver.get("https://www.seleniumeasy.com/test/table-data-download-demo.html");
//        driver.manage().window().maximize();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,800)");
    }

    @Test
    public void SliderMove() throws InterruptedException {
        this.driver.get("https://demoqa.com/slider/");
        driver.manage().window().maximize();
        WebElement slider = driver.findElement(By.id("slider"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(150, 0).release().perform();
        Thread.sleep(10000);
    }

    @Test
    public void HoverOverToolTip() throws InterruptedException {
        driver.get("https://demoqa.com/tooltip/");
        driver.manage().window().maximize();
        WebElement inputBox = driver.findElement(By.id("age"));
        Actions actions = new Actions(driver);
        actions.moveToElement(inputBox).perform();
        Thread.sleep(1000);
        WebElement text = driver.findElement(By.xpath("//input[@id='age']"));
        Thread.sleep(10000);
        Assert.assertTrue(text.isDisplayed());
    }

    @Test
    public void HoverOver() throws InterruptedException {
        driver.get("https://demoqa.com/menu/");
        //how to create actions object/ passing driver as a constructor
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        // we drag this element(source)
        WebElement first = driver.findElement(By.id("ui-id-9"));
        //we drop here (target)
        WebElement second = driver.findElement(By.id("ui-id-10"));
        //pause() --> waiting just like thread.sleep, accepts milliseconds
        Thread.sleep(1000);
        WebElement third = driver.findElement(By.id("ui-id-11"));
        //pause() --> waiting just like thread.sleep, accepts milliseconds
        Thread.sleep(1000);
        //if you are chaining actions we add build() method before perform
        Thread.sleep(1000);
        actions.moveToElement(first).pause(2000).moveToElement(second).pause(2000).moveToElement(third).click().build().perform();
        Thread.sleep(5000);
    }


    @Test
    public void CurrysNavigation() throws InterruptedException {
        driver.get("https://www.currys.co.uk/gbuk/index.html");
        //how to create actions object/ passing driver as a constructor
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //clicking accept cookies
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        // we drag this element(source)
        WebElement computing = driver.findElement(By.xpath("//a[@class='chevron'][contains(text(),'Computing')]"));
        //we drop here (target)
        WebElement laptop = driver.findElement(By.xpath("//a[@class='chevron'][contains(text(),'Laptops')]"));
        //pause() --> waiting just like thread.sleep, accepts milliseconds
        Thread.sleep(1000);
        //if you are chaining actions we add build() method before perform
        actions.moveToElement(computing).moveToElement(laptop).pause(2000).click().build().perform();
        Thread.sleep(5000);
    }

    @Test
    public void DragAndDrop() throws InterruptedException, IOException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        //how to create actions object/ passing driver as a constructor
        Actions actions = new Actions(driver);
        // we drag this element(source)
        WebElement source = driver.findElement(By.id("draggable"));
        //we drop here (target)
        WebElement target = driver.findElement(By.id("droptarget"));
        actions.dragAndDrop(source, target).perform();
        Thread.sleep(10000);
    }

    @Test
    public void DragAndDropChaining() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        //how to create actions object/ passing driver as a constructor
        Actions actions = new Actions(driver);
        // we drag this element(source)
        WebElement source = driver.findElement(By.id("draggable"));
        //we drop here (target)
        WebElement target = driver.findElement(By.id("droptarget"));
        //pause() --> waiting just like thread.sleep, accepts milliseconds
        Thread.sleep(1000);
        //clicking accept cookies
        driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();
        //we have to provide source and target to this method, it will drag and drop

        //if you are chaining actions we add build() method before perform
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().build().perform();
    }

    @Test
    public void DragAndDropOneBox() throws InterruptedException {
        driver.get("https://demoqa.com/droppable/");
        //how to create actions object/ passing driver as a constructor
        Actions actions = new Actions(driver);
        WebElement box1 = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Thread.sleep(5000);
        actions.dragAndDrop(box1, target).perform();
        Thread.sleep(10000);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(1000);
        driver.quit();
    }
}
