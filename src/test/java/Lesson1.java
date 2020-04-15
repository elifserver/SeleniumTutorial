import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;

public class Lesson1 {
    @Test
    public void name() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/elifalp/Documents/WS_Selenium/drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();

        // WebDriver driver = new SafariDriver();


//        System.setProperty("webdriver.chrome.driver","/Users/elifalp/Documents/WS_Selenium/drivers/chromedriver");
//        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.findElement(By.id("cookieChoiceDismiss")).click();
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        driver.findElement(By.name("firstname")).sendKeys("Elif");
        driver.findElement(By.name("lastname")).sendKeys("Server");
        driver.findElement((By.id("sex-1"))).click();
        driver.findElement(By.id("exp-6")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("exp-5")).click();
        driver.findElement(By.id("datepicker")).sendKeys("01-01-1990");
        driver.findElement(By.id("profession-0")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("profession-1")).click();


        Thread.sleep(5000);
        driver.quit();

    }


}
