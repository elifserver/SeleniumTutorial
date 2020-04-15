import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LinkTextExample {

    @Test
    public void XPathTest() throws Exception {
        System.setProperty("webdriver.gecko.driver", "/Users/elifalp/Documents/WS_Selenium/drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://facebook.com");
        driver.findElement(By.linkText("Help")).click();
        Thread.sleep(100);
        driver.findElement(By.partialLinkText("Help")).click();


    }
}
