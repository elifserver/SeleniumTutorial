import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utilities.BrowserUtils;

import java.io.IOException;
import java.util.List;

public class WebTables {
WebDriver driver;

    @Before
    public void setUp() throws Exception {
        //<editor-fold desc="CHROME">
//        System.setProperty("webdriver.chrome.driver","/Users/acelik/Desktop/Work/chromedriver");
        System.setProperty("webdriver.chrome.driver","driver/chromedriver");
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

        driver.get("https://www.seleniumeasy.com/test/table-data-download-demo.html");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
    }

    @Test
    public void printTable() throws InterruptedException {
        WebElement table = driver.findElement(By.id("example"));
        String wholeTable = table.getText();
        //verify that Nixon is in the table.
        Assert.assertTrue(wholeTable.contains("Nixxon"),"I am looking NIXON is in the table but could not find");
//        Thread.sleep(6000);
    }

    @Test
    public void getAllHeaders() {
        //how many columns we have ?
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='example']//th"));
        System.out.println("Number of columns " + headers.size());
        //print each column name one by one
        for (WebElement header : headers) {
            System.out.println(header.getText());
        }
    }

    @Test
    public void printTableSize(){
        //number of columns
        List<WebElement>  headers = driver.findElements(By.xpath("//table[@id='example']//th"));
        System.out.println("Number of columns: " + headers.size());

        //number of rows with header
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='example']//tr"));
        System.out.println("allRowsWithHeader = " + allRowsWithHeader.size());
        //number of rows without header(We prefer this)
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
        System.out.println("allRowsWithoutHeader = " + allRowsWithoutHeader.size());
    }

    @Test
    public void getRow(){
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
        for (int i = 1; i <=allRows.size(); i++) {
            String rowXpath = "//table[@id='example']/tbody/tr[" + i + "]";
            System.out.println("rowXpath = " + rowXpath);
            WebElement singleRow = driver.findElement(By.xpath(rowXpath));
            System.out.println(singleRow.getText());
        }
    }
    @Test
    public void getAllCellsInRow(){
        List<WebElement> allCellsInOneRow = driver.findElements(By.xpath("//table[@id='example']/tbody/tr[1]/td"));
        for (WebElement cell : allCellsInOneRow) {
            System.out.println(cell.getText());
        }
    }

    @Test
    public void getSingleCellByIndex(){
        WebElement singleCell = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[3]/td[2]"));
        System.out.println(singleCell.getText());
    }

    @Test
    public void printAllCellByIndex(){
        //number of rows
        int rowNumber = getNumberOfRows();
        //number of columns
        int colNumber = getNumberOfColumns();
        //iterate through each row in the table
        for (int i = 1; i <=rowNumber; i++) {
            //iterate through each cell in the table
            for (int j = 1; j <= colNumber ; j++) {
                //creating dynamic xpath
                String xpath = "//table[@id='example']/tbody/tr["+ i +"]/td["+ j +"]";
                //System.out.println(xpath);
                //getting each cell value and printing it
                WebElement singleCell = driver.findElement(By.xpath(xpath));
                System.out.println(singleCell.getText());
            }
        }
    }

    @Test
    public void getSpecificCellByIndex(){
        int r = 2;
        int c = 3;
        String xpath = "//table[@id='example']/tbody/tr["+ r +"]/td["+ c +"]";
        WebElement singleCell = driver.findElement(By.xpath(xpath));
        System.out.println(singleCell.getText());
    }

    @Test
    public void calculateTotalSalary(){
        int totalSalary = 0,salary=0, avarageSalary=0;
        //number of rows
        int rowNumber = getNumberOfRows();
        //number of columns
        int colNumber = getNumberOfColumns();
        //iterate through each row in the table
        for (int i = 1; i <=rowNumber; i++) {
                //creating dynamic xpath
                String xpath = "//table[@id='example']/tbody/tr["+ i +"]/td["+ 6 +"]";
                //System.out.println(xpath);
                //getting each cell value and printing it
                WebElement singleCell = driver.findElement(By.xpath(xpath));
                salary=Integer.parseInt(singleCell.getText().substring(1).replace(",",""));
                totalSalary=totalSalary+salary;
            }
        avarageSalary=totalSalary/rowNumber;
        System.out.println(totalSalary);
        System.out.println("avarageSalary = " + avarageSalary);
    }

    @Test
    public void calculateAvarageAge() throws IOException {
        int totalAge = 0, age=0, avarageAge=0;
        //number of rows
        int rowNumber = getNumberOfRows();
        //number of columns
//        int colNumber = getNumberOfColumns();
//        //iterate through each row in the table
        for (int i = 1; i <=rowNumber; i++) {
            //creating dynamic xpath
            String xpath = "//table[@id='example']/tbody/tr["+ i +"]/td[4]";
            //System.out.println(xpath);
            //getting each cell value and printing it
            WebElement singleCell = driver.findElement(By.xpath(xpath));
            age=Integer.parseInt(singleCell.getText());
            totalAge=totalAge+age;
        }
        avarageAge=totalAge/rowNumber;
        System.out.println("totalAge = " + totalAge);
        System.out.println("avarageAge = " + avarageAge);
    }

//    @Test
//    public void getCellInRelationToAnotherCellInSameRow(){
//        String firstname = "Tim";
//        String xpath = "//table[@id='example']//td[.='"+firstname +"']/../td[3]";
//        WebElement email = driver.findElement(By.xpath(xpath));
//        System.out.println(email.getText());
//    }
    private int getNumberOfColumns() {
        List<WebElement> allColumns = driver.findElements(By.xpath("//table[@id='example']//th"));
        return allColumns.size();
    }

    private int getNumberOfRows() {
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
        return allRows.size();

    }


    @After
    public void tearDown() throws Exception {
        Thread.sleep(1000);
        driver.quit();
    }
}

