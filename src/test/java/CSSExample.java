import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CSSExample {
    @Test
    public void CSSTest() throws Exception {
        String text;

        System.setProperty("webdriver.gecko.driver", "/Users/elifalp/Documents/WS_Selenium/drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();


        driver.get("https://www.facebook.com/login/");
        text = driver.findElement(By.cssSelector("#loginbutton")).getText();
        System.out.println(text);

        driver.get("https://www.travelup.com/en-gb");
        text = driver.findElement(By.cssSelector("h1[class$='navbar-brand']")).getAttribute("");
        System.out.println(text);
    }
}