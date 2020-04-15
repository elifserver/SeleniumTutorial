import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import javax.swing.*;

public class NavigationExample {
WebDriver driver;

    @Before
    public void setUp() throws Exception {
        //<editor-fold desc="CHROME">
           System.setProperty("webdriver.chrome.driver","/Users/elifalp/Documents/WS_Selenium/drivers/chromedriver");
          driver = new ChromeDriver();
//        //</editor-fold>

        //<editor-fold desc="FIREFOX">
        //System.setProperty("webdriver.gecko.driver", "/Users/elifalp/Documents/WS_Selenium/drivers/geckodriver");
        //  WebDriver driver = new FirefoxDriver();
        //</editor-fold>

        //<editor-fold desc="SAFARI">
        //System.setProperty("webdriver.chrome.driver","/Users/elifalp/Documents/WS_Selenium/drivers/chromedriver");
       // WebDriver driver = new SafariDriver();
        //</editor-fold>

        driver.get("http://facebook.com");
        driver.manage().window().maximize();
    }

    @Test
    public void testMethod1() throws Exception {
        String pageTitle;
        String currentUrl;
        String urlToNavigate = "https://www.facebook.com/login/";

        pageTitle = driver.getTitle();
        currentUrl = driver.getCurrentUrl();
        System.out.println("Title of the page: " + pageTitle);
        System.out.println("URL of the page: " + currentUrl);
        Thread.sleep(5000);

        driver.navigate().to(urlToNavigate);
        pageTitle = driver.getTitle();
        currentUrl = driver.getCurrentUrl();
        System.out.println("Title of the page: " + pageTitle);
        System.out.println("URL navigated:" + currentUrl);
        Thread.sleep(5000);

        driver.navigate().back();
        pageTitle = driver.getTitle();
        currentUrl = driver.getCurrentUrl();
        System.out.println("Title of the page after BACK navigation: " + pageTitle);
        System.out.println("URL navigated:" + currentUrl);
        Thread.sleep(5000);

        driver.navigate().forward();
        pageTitle = driver.getTitle();
        currentUrl = driver.getCurrentUrl();
        System.out.println("Title of the page after FORWARD navigation: " + pageTitle);
        System.out.println("URL navigated:" + currentUrl);
        driver.findElement(By.id("email")).sendKeys("e@e.com");
        Thread.sleep(5000);

        System.out.println("Refresh Page......");
        //First way
        driver.navigate().refresh();
        //Second way
        driver.get(currentUrl);
        //Third way
        driver.navigate().to(currentUrl);

        String pageSource = driver.getPageSource();
        System.out.println("Page Source \n" + pageSource);

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.quit();
    }
}

