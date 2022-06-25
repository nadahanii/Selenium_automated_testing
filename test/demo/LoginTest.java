package demo;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
//import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest {

    String path = "D:\\FCAI\\FourthLevel\\2\\SW Testing\\Assignments\\2\\selenium_task\\selenium_task\\";

    public String getCellData(int row, int col) throws Exception {
        XSSFSheet ExcelWSheet;
        XSSFWorkbook ExcelWBook;

        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(path + "Login.xlsx");

            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet("Sheet1");
            String cellData = ExcelWSheet.getRow(row).getCell(col).getStringCellValue();
            ExcelWBook.close();
            return cellData;
        } catch (IOException e) {
            return "Error in opening the file";
        }
    }

    @Test
    public void FirefoxInvalidTest() throws Exception {

        String username = getCellData(1, 0);
        String password = getCellData(1, 1);

        // Set Firefox Web Driver
        System.setProperty("webdriver.gecko.driver", path + "geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Launch website
        driver.navigate().to("https://www.acadox.com/");
        // Maximize the browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        // Enter the username and password
        driver.findElement(By.id("tbUsername")).sendKeys(username);
        driver.findElement(By.id("tbPassword")).sendKeys(password);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Click on Sign in button
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div[6]/form/div[10]/input[2]")).click();

        try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(false, driver.findElement(By.xpath("/html/body/div[5]")).isDisplayed());
        } catch (NoSuchElementException e) {
            assertTrue(true);
        }
        Thread.sleep(4000);

        // Close the web driver
        driver.close();
    }

    @Test
    public void FirefoxValidTest() throws Exception {

        String username = getCellData(2, 0);
        String password = getCellData(2, 1);

        // Set Firefox Web Driver
        System.setProperty("webdriver.gecko.driver", path + "geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Launch website
        driver.navigate().to("https://www.acadox.com/");
        // Maximize the browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        // Enter the username and password
        driver.findElement(By.id("tbUsername")).sendKeys(username);
        driver.findElement(By.id("tbPassword")).sendKeys(password);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Click on Sign in button
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div[6]/form/div[10]/input[2]")).click();

        // Check whether a certain element appears which confirms that the login was successful
        assertEquals(true, driver.findElement(By.xpath("/html/body/div[5]")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/a[4]")).click();
        Thread.sleep(4000);
        driver.close();
    }

    @Test
    public void ChromeInvalidTest() throws Exception {

        String username = getCellData(1, 0);
        String password = getCellData(1, 1);

        // Set Google Chrome Web Driver
        System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Launch website
        driver.navigate().to("https://www.acadox.com/");
        // Maximize the browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        // Enter the username and password
        driver.findElement(By.id("tbUsername")).sendKeys(username);
        driver.findElement(By.id("tbPassword")).sendKeys(password);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Click on Sign in button
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div[6]/form/div[10]/input[2]")).click();

        try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(false, driver.findElement(By.xpath("/html/body/div[5]")).isDisplayed());
        } catch (NoSuchElementException e) {
            assertTrue(true);
        }
        Thread.sleep(4000);
        driver.close();
    }

    @Test
    public void ChromeValidTest() throws Exception {

        String username = getCellData(2, 0);
        String password = getCellData(2, 1);

        // Set Google Chrome Web Driver
        System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Launch website
        driver.navigate().to("https://www.acadox.com/");
        // Maximize the browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        // Enter the username and password
        driver.findElement(By.id("tbUsername")).sendKeys(username);
        driver.findElement(By.name("tbPassword")).sendKeys(password);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Click on Sign in button
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div[6]/form/div[10]/input[2]")).click();

        // Check whether a certain element appears which confirms that the login was successful
        assertEquals(true, driver.findElement(By.xpath("/html/body/div[5]")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/a[4]")).click();
        Thread.sleep(4000);
        driver.close();
    }

    @Test
    public void EdgeInvalidTest() throws Exception {

        String username = getCellData(1, 0);
        String password = getCellData(1, 1);

        // Set Edge Web Driver
        System.setProperty("webdriver.edge.driver", path + "msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Launch website
        driver.navigate().to("https://www.acadox.com/");
        // Maximize the browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        // Enter the username and password
        driver.findElement(By.id("tbUsername")).sendKeys(username);
        driver.findElement(By.id("tbPassword")).sendKeys(password);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Click on Sign in button
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div[6]/form/div[10]/input[2]")).click();

        try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(false, driver.findElement(By.xpath("/html/body/div[5]")).isDisplayed());
        } catch (NoSuchElementException e) {
            assertTrue(true);
        }
        Thread.sleep(4000);
        driver.close();
    }

    @Test
    public void EdgeValidTest() throws Exception {

        String username = getCellData(2, 0);
        String password = getCellData(2, 1);

        // Set Edge Web Driver
        System.setProperty("webdriver.edge.driver", path + "msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Launch website
        driver.navigate().to("https://www.acadox.com/");
        // Maximize the browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        // Enter the username and password
        driver.findElement(By.id("tbUsername")).sendKeys(username);
        driver.findElement(By.id("tbPassword")).sendKeys(password);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // Click on Sign in button
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div[6]/form/div[10]/input[2]")).click();

        // Check whether a certain element appears which confirms that the login was successful
        assertEquals(true, driver.findElement(By.xpath("/html/body/div[5]")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/a[4]")).click();
        Thread.sleep(4000);
        driver.close();
    }
}
