import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    protected static WebDriver driver;
    @Before
    public  void setup() {
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
//        driver = new ChromeDriver();
        System.setProperty("webdriver.opera.driver", "drivers/operadriver");
        driver=new OperaDriver();
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
}
