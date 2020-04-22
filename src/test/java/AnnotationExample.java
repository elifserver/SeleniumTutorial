import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;


public class AnnotationExample {
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
    public void test1() {
        driver.navigate().to("https://login.yahoo.com/");
      // WebElement element = driver.findElement(By.name("countryCodeInt"));
        //System.out.println("TEST 1:::: Element has found ");

        List<WebElement> listElements = driver.findElements(By.name("countryCodeInt"));
        System.out.println(listElements.size() == 0 ? "Webelement is not present on DOM" : "Webelement is  PRESENT on DOM");

        List<WebElement> listElements1 = driver.findElements(By.name("countryCodeIntl"));
        System.out.println(listElements1.size() == 0 ? "Webelement is not present on DOM" : "Webelement is  PRESENT on DOM");


        if (listElements.size() == 0)
        {
            System.out.println("Webelement is not present on DOM (With IF)");
        }
        else
        {
            System.out.println("Webelement is present on DOM (With IF)");
        }


        if (listElements1.size() == 0)
        {
            System.out.println("Webelement is not present on DOM (With IF)");
        }
        else
        {
            System.out.println("Webelement is present on DOM (With IF)");
        }
    }

//    @Test
//    public void test2() {
//        System.out.println("Invalid cridentials");
//        //Assert.assertTrue(false);
//    }


    @Test
    public void RadioButton() throws InterruptedException {
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");


        driver.manage().window().maximize();
        Thread.sleep(500);
        driver.findElement(By.id("cookieChoiceDismiss")).click();
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0, 1000);");
        //driver.findElement(By.id("sex-1")).click();
        List<WebElement> elementList = driver.findElements(By.xpath("//input[@name='sex']"));
        for (WebElement element:elementList
             ) {
            //System.out.println(element.getAttribute("value"));
            if (element.getAttribute("value").contains("Female")){
                element.click();
                Thread.sleep(2000);
            }
            if(element.isSelected())
            {
                System.out.println("Gender supposed to be female-->" + element.getAttribute("value"));
            }
        }



    }


    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.quit();

    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("After class working....");
    }
}
