import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.List;

public class WebElementBasics {
    WebDriver driver;
    Boolean enabled;

    @Before
    public void setUp() throws Exception {
        //<editor-fold desc="CHROME">
//        System.setProperty("webdriver.chrome.driver", "/Users/elifalp/Documents/WS_Selenium/drivers/chromedriver");
//        driver = new ChromeDriver();
////        //</editor-fold>

        //<editor-fold desc="FIREFOX">
        //System.setProperty("webdriver.gecko.driver", "/Users/elifalp/Documents/WS_Selenium/drivers/geckodriver");
        driver = new FirefoxDriver();
//        //</editor-fold>

        //<editor-fold desc="SAFARI">
        //System.setProperty("webdriver.chrome.driver","/Users/elifalp/Documents/WS_Selenium/drivers/chromedriver");
        //driver = new SafariDriver();
        //</editor-fold>
    }

    @Test
    public void testFacebook_EnabledExample() throws Exception {
        driver.get("http://facebook.com");
        driver.manage().window().maximize();
        enabled = driver.findElement(By.xpath("//option[contains(text(),'Select your pronoun')]")).isEnabled();
        System.out.println("Is Pronoun selection header enabled or disabled = " + enabled);

        enabled = driver.findElement(By.xpath("//option[contains(text(),'Select your pronoun')]//following-sibling::option[1]")).isEnabled();
        System.out.println("Is Pronoun selection - first option after header enabled or disabled = " + enabled);
    }

    @Test
    public void testYahoo_EnabledDisplayedExample() throws Exception {
        driver.get("https://login.yahoo.com/");
        driver.manage().window().maximize();

        enabled = driver.findElement(By.name("countryCodeIntl")).isEnabled();
        System.out.println("International Country Code = " + (enabled == false ? "disabled" : "enabled"));

        Boolean displayed = driver.findElement(By.name("countryCodeIntl")).isDisplayed();
        System.out.println("International Country Code = " + (displayed == false ? "not visible" : "visible"));
    }

    @Test
    public void testYahoo_PresenceExample() throws Exception {
        driver.get("https://login.yahoo.com/");
        driver.manage().window().maximize();
/**
 * Locator name misspelled - Webelements
 */
        List<WebElement> elementList1 = driver.findElements(By.name("countryCodeIntl"));
        List<WebElement> elementList2 = driver.findElements(By.name("countryCodeInt")); //  element name misspelled
        System.out.println(elementList1.size() == 0 ? "not present" : "present");
        System.out.println(elementList2.size() == 0 ? "not present" : "present");

        /**
         * Locator name misspelled - Webelements
         */
        WebElement element1 = driver.findElement(By.id("login-username"));
        System.out.println(element1.isDisplayed() ? "present" : "not present");

     // WebElement element1 = driver.findElement(By.id("login-usernam"));  //id misspelled
     //System.out.println(element1.isDisplayed() ? "present" : "not present");
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

    @Test
    public void ClearInputBox() throws Exception {
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//input[@name='firstname']"));
        element.sendKeys("Elif");
        Thread.sleep(1000);
        element.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(1000);
//       element.sendKeys(Keys.COMMAND, "a");
//       element.sendKeys(Keys.DELETE);
        element.sendKeys(Keys.COMMAND,"a",Keys.BACK_SPACE);
        Thread.sleep(1000);
        element.sendKeys("Server");

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.quit();
    }

}
