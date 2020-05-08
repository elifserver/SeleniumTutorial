import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CSSExample {
    String text;
    WebDriver driver = new ChromeDriver();

    @Test
    public void CSSTest()  {
        driver.get("https://www.facebook.com/login/");
        text = driver.findElement(By.cssSelector("#loginbutton")).getText();
        System.out.println(text);
    }

    @Test
    public void name() {
        driver.get("https://www.travelup.com/en-gb");
        text = driver.findElement(By.cssSelector("h1[class$='navbar-brand']")).getAttribute("");
        System.out.println(text);
    }
}