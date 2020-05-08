package steps;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.classes.CreateAccountPage;
import page.classes.CreatePasswordPage;
import page.classes.WelcomePage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Outlook_Onboarding {
   public static WebDriver driver = new ChromeDriver();
   public static WebDriverWait wait =  new WebDriverWait(driver, 15);



//    @Before
//    public  void setup() {
//      driver.manage().window().maximize();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        Thread.sleep(5000);
//        driver.quit();
//    }


    @Given("I navigate to Outlook page")
    public void iNavigateToOutlookPage() {
        driver.manage().window().maximize();
        driver.navigate().to("https://outlook.live.com/owa/");
    }


    @And("I click the Create account link for starting my process")
    public void iClickTheCreateAccountLinkForStartingMyProcess() {
//        WebElement createAccountLink = driver.findElement(By.xpath("//section[@class='precis above-fold']//a"));
//        createAccountLink.click();
        WelcomePage.clickOnAccountButton(driver);
    }


    @When("I type {string} account name")
    public void iTypeAccountName(String accountNameInput) {
//        WebElement memberName = driver.findElement(By.id("MemberName"));
//        memberName.sendKeys(accountNameInput);
        CreateAccountPage.sendText(driver,accountNameInput);
    }

    @And("I try to proceed")
    public void iTryToProceed() {
        WebElement nextButton = driver.findElement(By.id("iSignupAction"));
        nextButton.click();
    }

    @Then("I should get error message - {string}")
    public void iShouldGetErrorMessage(String expectedErrorText) throws InterruptedException {
       // WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("MemberNameError")));
       // String errorTextOnPage = error.getText();
        WebElement error = CreateAccountPage.errorMessage(wait);
        String errorTextOnPage = CreateAccountPage.getErrorText(wait);

           Assert.assertTrue("Not expected error text. Check your error",errorTextOnPage.compareTo(expectedErrorText) == 0);
    }

    @Then("I should be landed on the password screen")
    public void iShouldBeLandedOnThePasswordScreen() {
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PasswordTitle")));
       // CreatePasswordPage.waitForPresence();
        String expectedTitle = "Create a password";
        String title = driver.getTitle();
        //System.out.println(title);

        WebElement passwordBox = driver.findElement(By.id("PasswordInput"));
        WebElement selectionCheck = driver.findElement(By.id("PasswordInput"));
        passwordBox.sendKeys("eee");
        System.out.println(passwordBox.getText());
        selectionCheck.click();
        System.out.println(passwordBox.getText());
       // Assert.assertTrue("We didn't land on the expected screen",expectedTitle.compareTo(title) == 0 );

       // Select selectEmail = new Select(driver.findElement(By.id("LiveDomainBoxList")));


    }


    @And("I start to create an account with account name: {string}")
    public void iStartToCreateAnAccountWithAccountName(String accountName) {
        iClickTheCreateAccountLinkForStartingMyProcess();
        iTypeAccountName(accountName);
        driver.findElement(By.id("LiveDomainBoxList")).click();
        driver.findElement(By.id("pageControlHost")).click();
       //iTryToProceed();
    }

    @And("I landed on the password screen")
    public void iLandedOnThePasswordScreen() throws InterruptedException {
        iShouldBeLandedOnThePasswordScreen();
    }

    @When("I click on the {string} link")
    public void iClickOnTheLink(String link) {
        String linkLocator = null;

        switch (link) {
            case "Microsoft Services Agreement":
                linkLocator = "//div[@id='ftrText']/a[contains(text(),'Services Agreement')]";
                break;
            case "privacy and cookies":
                linkLocator = "//div[@id='ftrText']/a[contains(text(),'privacy and cookies')]";
                break;
            default:
                break;
        }
        WebElement linkToClick = driver.findElement(By.xpath(linkLocator));
        linkToClick.click();
    }

    @Then("I should see the {string} tab")
    public void iShouldSeeTheTab(String pageName) {
        String expectedTitle = "";
        switch (pageName) {
            case "Microsoft Services Agreement":
                expectedTitle = "Microsoft Services Agreement";
                break;
            case "privacy and cookies":
                expectedTitle = "Microsoft Privacy Statement – Microsoft privacy";
                break;
            default:
                break;
        }

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        String parentWindowHandle = driver.getWindowHandle();
        driver.switchTo().window(tabs.get(1));
        String title = driver.getTitle();

        Assert.assertTrue("title and expected title does not match or you are on the wrong page",
                title.compareTo(expectedTitle) == 0);
        System.out.println(driver.getWindowHandle() + "\n" + parentWindowHandle);
        System.out.println(driver.getTitle());
    }

}
