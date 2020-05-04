package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Outlook_Onboarding {
   // WebDriver driver;
//
//    @Before
//    public  void setup() {
        //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
//        Base.driver = new ChromeDriver();
//    }
//
//    public WebElement waitForPresence(By by){
//        WebDriverWait wait=new WebDriverWait(Base.driver,10);
//        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
//    }

WebDriver driver = new ChromeDriver();
WebDriverWait wait = new WebDriverWait(driver,5);

    @Given("I navigate to Outlook page")
    public void iNavigateToOutlookPage() {
        driver.navigate().to("https://outlook.live.com/owa/");
    }


    @And("I click the Create account link for starting my process")
    public void iClickTheCreateAccountLinkForStartingMyProcess() {
        WebElement createAccountLink = driver.findElement(By.xpath("//section[@class='precis above-fold']//a"));
        createAccountLink.click();
    }


    @When("I type {string} account name")
    public void iTypeAccountName(String accountNameInput) {
        WebElement memberName = driver.findElement(By.id("MemberName"));
        memberName.sendKeys(accountNameInput);
    }

    @And("I try to proceed")
    public void iTryToProceed() {
        WebElement nextButton = driver.findElement(By.id("iSignupAction"));
        nextButton.click();
    }

    @Then("I should get error message - {string}")
    public void iShouldGetErrorMessage(String expectedErrorText) throws InterruptedException {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("MemberNameError")));
           String errorTextOnPage = error.getText();
           Assert.assertTrue("Not expected error text. Check your error",errorTextOnPage.compareTo(expectedErrorText) == 0);
    }

    @Then("I should be landed on the password screen")
    public void iShouldBeLandedOnThePasswordScreen() {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PasswordTitle")));
        String expectedTitle = "Create a password";
        String title = driver.getTitle();
        //System.out.println(title);
        Assert.assertTrue("We didn't land on the expected screen",expectedTitle.compareTo(title) == 0 );
    }
}
