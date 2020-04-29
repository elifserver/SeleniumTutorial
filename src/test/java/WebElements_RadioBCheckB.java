
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebElements_RadioBCheckB {
WebDriver driver;

    @Before
    public void setUp() throws Exception {
        //<editor-fold desc="CHROME">
          // System.setProperty("webdriver.chrome.driver","/Users/elifalp/Documents/WS_Selenium/drivers/chromedriver");
         driver = new ChromeDriver();
//        //</editor-fold>

        //<editor-fold desc="FIREFOX">
        //System.setProperty("webdriver.gecko.driver", "/Users/elifalp/Documents/WS_Selenium/drivers/geckodriver");
        //  WebDriver driver = new FirefoxDriver();
        //</editor-fold>

        //<editor-fold desc="SAFARI">
        //System.setProperty("webdriver.chrome.driver","/Users/elifalp/Documents/WS_Selenium/drivers/chromedriver");
       // WebDriver driver = new SafariDriver();
        //</editor-fold>

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
    }

    @Test
    public void radioButtonSelection() throws Exception {
        driver.findElement(By.id("cookieChoiceDismiss")).click();
        //List<WebElement> experienceChoices = driver.findElements(By.xpath("//input[@type='radio'][@name='exp']"));
        List<WebElement> experienceChoices = driver.findElements(By.xpath("//input[@type='radio'][@name='exp']"));
        for (WebElement expChoice:experienceChoices
             ) {
            expChoice.click();
            Thread.sleep(900);
        }

        int size = experienceChoices.size();
        for(int i = 0; i < size; i++){
            experienceChoices.get(i).click();
            Thread.sleep(900);
        }
    }

    @Test
    public void selectASpecificRadioButton() throws InterruptedException {
        List<WebElement> genderButtons = driver.findElements(By.xpath("//input[@name='sex']"));
        for (WebElement radioButton : genderButtons) {
            if(radioButton.getAttribute("value").contains("Female") ) radioButton.click();
            Thread.sleep(500);
            System.out.println(radioButton.isSelected() ? "Gender = Female" : "Gender = Male");
        }
    }

    @Test
    public void checkBoxSelection() throws InterruptedException {

        List<WebElement> toolsList = driver.findElements(By.xpath("//input[@type='checkbox'][@name='tool']"));

        for(int i =0; i < toolsList.size() - 1; i++)  //Attention: I am not going till the end of the toolsList
        {
            toolsList.get(i).click();
            Thread.sleep(1000);
        }


        for (WebElement tool:toolsList
             ) {
            if(!tool.isSelected()) {
                tool.click();
                Thread.sleep(500);
            }
        }


    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(1000);
        driver.quit();
    }
}

