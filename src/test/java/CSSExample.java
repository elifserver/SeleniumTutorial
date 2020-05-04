import org.junit.Test;
import org.openqa.selenium.By;
import steps.Base;

public class CSSExample extends Base {
    String text;
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