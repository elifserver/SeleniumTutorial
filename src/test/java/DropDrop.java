import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;

import java.io.File;

import java.io.IOException;
import java.util.List;


public class DropDrop {
    WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Before class working....");
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();

    }

    @Test
    public void AutoDropDown() throws InterruptedException, IOException {
        String partialText = "IST";
        String textToFind = "Istanbul Ataturk Airport\nIST";

        driver.navigate().to("https://www.travelup.com/en-gb");
        driver.findElement(By.id("txtFlightDestinationAirport")).sendKeys("IST");

        WebElement ulElement = driver.findElement(By.id("ui-id-2"));
        Thread.sleep(2000);
        String innerHTML = ulElement.getAttribute("innerHTML");// IMPORTANT
        //System.out.println(innerHTML);

        List<WebElement> liList = ulElement.findElements(By.tagName("li")); //IMPORTANT

        for (WebElement e:liList
             ) {
            //System.out.println(e.getText() + "\n");
            if(e.getText().contains(textToFind))
            {
                e.click();
            }
        }

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)driver);
//Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
        File DestFile=new File("./ScreenShots/" + "TestImage.png");
//Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }


    @Test
    public void Calendar1() throws InterruptedException {
        //Try with javascript
        driver.navigate().to("https://www.travelup.com/en-gb");
        //Thread.sleep(2000);
        driver.findElement(By.id("txtFlightReturnDate")).click();
        List<WebElement> listDates = driver.findElements(By.xpath("//div[contains(@class,'activecalendar')]//div[contains(@class,'cell-date')]/child::div"));
        for (WebElement e:listDates
             ) {
            System.out.println(e.getText());
            if(e.getText().contains("24")){ e.click();}
        }

        List<WebElement> listDates2 = driver.findElements(By.xpath("//div[contains(@class,'activecalendar')]//div[contains(@class,'cell-date')]"));
        for (WebElement e:listDates2
        ) {

            if(!e.getAttribute("class").contains("disabled"))
            {
                System.out.println(e.getAttribute("data-date") + "-----> Enabled");
            }
        }

        WebElement e = driver.findElement(By.id("activeBtn"));

    }



    @After
    public void tearDown() throws Exception {
        Thread.sleep(10000);
        driver.quit();

    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("After class working....");
    }
}
