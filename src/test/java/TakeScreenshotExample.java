import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class TakeScreenshotExample {
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
    public void ScreenShotWithFile() throws Exception {
        String pageTitle;

        driver.get("http://facebook.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("email")).sendKeys("e@e.com");
        driver.findElement((By.className("uiButtonConfirm"))).click();

       // TakesScreenshot srcShot = ((TakesScreenshot) driver);

        File fileSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

//       String directory = System.getProperty("user.dir") +  "/screenShots/";
//        File fileDest = new File(directory + "testResult.png");  //Copy file at destination

        File fileDest = new File("./ScreenSHOOOTS/" + "resultImage.png");

        FileUtils.copyFile(fileSrc, fileDest);

    }



    @After
    public void tearDown() throws Exception {
        Thread.sleep(1000);
        driver.quit();
    }
}
