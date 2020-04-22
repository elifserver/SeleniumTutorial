import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DatePickerExample {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        //<editor-fold desc="CHROME">
        //System.setProperty("webdriver.chrome.driver","/Users/elifalp/Documents/WS_Selenium/drivers/chromedriver");
        driver = new ChromeDriver();
//        //</editor-fold>

        //<editor-fold desc="FIREFOX">
        // System.setProperty("webdriver.gecko.driver", "/Users/elifalp/Documents/WS_Selenium/drivers/geckodriver");
        //driver = new FirefoxDriver();
        //</editor-fold>

        //<editor-fold desc="SAFARI">
        //System.setProperty("webdriver.chrome.driver","/Users/elifalp/Documents/WS_Selenium/drivers/chromedriver");
        //driver = new SafariDriver();
        //</editor-fold>
    }


    @Test
    public void calendarExample_Travelup() throws Exception {
//Calendar is handled with DIV tags
        String dateForSearch = "16";
        driver.get("https://www.travelup.com/en-gb");
        driver.manage().window().maximize();
        driver.findElement(By.id("txtFlightReturnDate")).click();
        WebElement dateToClickOnCalendar = driver.findElement(By.xpath("//div[contains(@class,'activecalendar')]//div[@class='content-holder'][contains(text(),'" + dateForSearch + "')]"));



        WebElement calendarDateHolder = driver.findElement(By.xpath("//div[contains(@class,'activecalendar')]//div[@class='content-holder']" +
                "[contains(text(),'" + dateForSearch + "')]//parent::div"));

        Boolean IsCalendarDateActive = (calendarDateHolder.getAttribute("class") == "disabled cell-date" ? Boolean.TRUE : Boolean.FALSE);


        System.out.println("Date data we see on the screen" + dateToClickOnCalendar.getText());
        String returnDate = calendarDateHolder.getAttribute("data-date");

        System.out.println("returnDate :::" + returnDate);
        System.out.println("Is the test date active ---------->" + IsCalendarDateActive);

        //Disabled is not an attribute on DOM. It is only a value for class attribute. So the code below will not be working....
        System.out.println("Is the test date active - (checked with practical way):: -------->" + calendarDateHolder.isEnabled());
    }

    @Test
    public void calendarExample_Expedia() throws Exception {
        //Calendar is handled with TABLE and buttons in the table
        //we have 2 datepicker. That's why we need to mention which months we want to choose
        //Tag used for Month name showing is a sibling of the <tbody> tag where we have all the buttons we need
        DateFormat dateFormat = new SimpleDateFormat("MMM yyyy");
        Date dat = new Date();
        System.out.println(dateFormat.format(dat));

        driver.get("https://www.expedia.co.uk/");
        driver.manage().window().maximize();
        WebElement d = driver.findElement(By.id("hotel-checkin-hp-hotel"));
        d.click();

        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='datepicker-cal-weeks']/caption[contains(text()," +
                "'Apr 2020')]//following-sibling::tbody/tr/td/button"));
        for (WebElement date : dates
        ) {
            System.out.println(date.isEnabled() ? date.getText() + "--> ENABLED" : date.getText() + "--> disabled");
        }
    }

    @After
    public void tearDown() throws Exception {

        Thread.sleep(5000);

        driver.quit();
    }
}
