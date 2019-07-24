package selauto;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import ExtentReport.ExtentReport;
import JSONRead.*;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver;
	
	ExtentReport extentReport = new ExtentReport();
	JSONReader jsonRead = new JSONReader();
	Logger log = Logger.getLogger("devpinoyLogger");
	
  @Test
  public void createCustomer() throws Throwable, IOException, ParseException {
	  
	  extentReport.setUpReport();	  
	  extentReport.startTestCase("User Creation");
	  
	  driver.findElement(By.xpath("//td[@class='mouseOut']/a[@href='register.php']")).click();
	  driver.findElement(By.name("firstName")).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "FIRST_NAME"));
	  driver.findElement(By.name("lastName")).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "LAST_NAME"));
	  driver.findElement(By.name("phone")).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "PHONE"));
	  driver.findElement(By.name("userName")).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "EMAIL"));
	  
	  driver.findElement(By.name("address1")).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "ADDRESS"));
	  driver.findElement(By.name("city")).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "CITY"));
	  driver.findElement(By.name("state")).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "STATE"));
	  driver.findElement(By.name("postalCode")).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "POSTAL_CODE"));
	  
	  Select countryDropdown = new Select(driver.findElement(By.name("country")));
	  countryDropdown.selectByValue(jsonRead.jsonRead(".\\Data\\sel.json", "COUNTRY"));
	  
	  driver.findElement(By.name("email")).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "USER_NAME"));
	  driver.findElement(By.name("password")).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "PASSWORD"));
	  driver.findElement(By.name("confirmPassword")).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "CONFIRM_PASSWORD"));
	  driver.findElement(By.name("submit")).click();
	  
	  String message = driver.findElement(By.xpath("//p[3]/font/b")).getText().toString();
	  
	  log.debug("User Created");
	  extentReport.logEvents("User Created Successfully with user name " + jsonRead.jsonRead(".\\Data\\sel.json", "USER_NAME") );
	  
	  assertEquals(message, "Note: Your user name is " + jsonRead.jsonRead(".\\Data\\sel.json", "USER_NAME") + "." );
	  
	  System.out.println("Test Passed");
	  System.out.println(message);
  }
  @BeforeTest
  public void beforeTest() throws FileNotFoundException, IOException, ParseException {
	  System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
      
      driver.get(jsonRead.jsonRead(".\\Data\\sel.json", "URL"));
      log.debug("Navigating to Login Page");
      extentReport.setUpReport();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
	  extentReport.createFinalReport();
	  log.debug("Creating final report");
	  driver.quit();
	  
  }

}
