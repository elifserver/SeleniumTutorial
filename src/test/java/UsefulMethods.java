import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UsefulMethods {
    WebDriver driver;
    Boolean enabled;

    @Before
    public void setUp() throws Exception {
        //<editor-fold desc="CHROME">
//        System.setProperty("webdriver.chrome.driver", "/Users/elifalp/Documents/WS_Selenium/drivers/chromedriver");
//        driver = new ChromeDriver();
////        //</editor-fold>

        //<editor-fold desc="FIREFOX">
        System.setProperty("webdriver.gecko.driver", "/Users/elifalp/Documents/WS_Selenium/drivers/geckodriver");
        driver = new FirefoxDriver();
        //</editor-fold>

        //<editor-fold desc="SAFARI">
        //System.setProperty("webdriver.chrome.driver","/Users/elifalp/Documents/WS_Selenium/drivers/chromedriver");
        //driver = new SafariDriver();
        //</editor-fold>
    }



    @Test
    public void WebElementsAndSelectedExample() throws Exception {
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("cookieChoiceDismiss")).click();

        //Input box
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Elif");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Server");

        //Radio button
        WebElement genderRadioMale=  driver.findElement(By.id("sex-0"));
        WebElement genderRadioFemale=  driver.findElement(By.id("sex-1"));
        genderRadioFemale.click();
        System.out.println(genderRadioFemale.isSelected()? "Gender = Female" : "Gender = Male");
        genderRadioMale.click();
        System.out.println(genderRadioFemale.isSelected()? "Gender = Female" : "Gender = Male");
        System.out.println("Is female selected?" + genderRadioFemale.isSelected());

        driver.findElement(By.id("exp-3")).click();

        //Input box
        driver.findElement(By.id("datepicker")).sendKeys("01-01-1980");

        //checkbox
        driver.findElement((By.id("profession-1"))).click();
        driver.findElement((By.id("profession-0"))).click();
        driver.findElement(By.id("tool-2")).click();

        //Dropdown
        Select continentOptions = new Select(driver.findElement(By.id("continents")));
        continentOptions.selectByVisibleText("Europe");

        //multiSelect
        Select seleniumCommendsOptions = new Select(driver.findElement(By.id("selenium_commands")));
        seleniumCommendsOptions.selectByVisibleText("Navigation Commands");
        driver.findElement(By.id("submit")).click();
    }


    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.quit();
    }

}
