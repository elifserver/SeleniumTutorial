import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SwichWindowExample {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        //<editor-fold desc="CHROME">
        //  System.setProperty("webdriver.chrome.driver","/Users/elifalp/Documents/WS_Selenium/drivers/chromedriver");
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
    public void IFAndSwichWindowExample() throws Exception {
/**
 * without Parent handle definition
 */
        driver.get("https://demoqa.com/iframe-practice-page/");
        driver.manage().window().maximize();
        driver.switchTo().frame("IF1");
        driver.findElement(By.xpath("//a[@class='you-tube']")).click();

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        //driver.findElement(By.xpath("//a[contains(text(),'Sortable')]")).click();
        driver.findElement(By.xpath("//a[@title='Cucumber in Java - Class 8']")).click();
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }

    @Test
    public void IFrameExample() throws Exception {
/**
 * with Parent handle definition
 */
        driver.get("https://demoqa.com/iframe-practice-page/");
        driver.manage().window().maximize();
        String parentHandle = driver.getWindowHandle();
        System.out.println("Parent Handle:: " + parentHandle);

        driver.switchTo().frame("IF1");
        driver.findElement(By.xpath("//a[@class='you-tube']")).click();
        System.out.println("driver handle::" + driver.getWindowHandle());
        Thread.sleep(2000);

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        if (driver.getWindowHandle() != parentHandle) {
            driver.switchTo().window(parentHandle);
            driver.findElement(By.xpath("//a[contains(text(),'Sortable')]")).click();
            Thread.sleep(2000);

        }
        driver.switchTo().window(tabs2.get(1));
        driver.close();
    }

    @Test
    public void SwitchWindow() {
        //https://demoqa.com/automation-practice-switch-windows-2/
    }

    @After
    public void tearDown() throws Exception {
        // Thread.sleep(5000);
        // driver.quit();
    }
}
