package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class CreateNewUser {
	
	public WebDriver driver;
	String appUrl = "http://demo.guru99.com/test/newtours/";
	String userName = "jon123";
	
  @Test
  public void CreateNewUser() {
	  driver.findElement(By.xpath("//td[@class='mouseOut']/a[@href='register.php']")).click();
	  driver.findElement(By.name("firstName")).sendKeys("Jon");
	  driver.findElement(By.name("lastName")).sendKeys("Snow");
	  driver.findElement(By.name("phone")).sendKeys("4455663322");
	  driver.findElement(By.name("userName")).sendKeys("snow123@gmail.com");
	  
	  driver.findElement(By.name("address1")).sendKeys("main street");
	  driver.findElement(By.name("city")).sendKeys("Colombo 01");
	  driver.findElement(By.name("state")).sendKeys("Western");
	  driver.findElement(By.name("postalCode")).sendKeys("11250");
	  
	  Select countryDropdown = new Select(driver.findElement(By.name("country")));
	  countryDropdown.selectByValue("ANGOLA");
	  
	  driver.findElement(By.name("email")).sendKeys(userName);
	  driver.findElement(By.name("password")).sendKeys("123456");
	  driver.findElement(By.name("confirmPassword")).sendKeys("123456");
	  driver.findElement(By.name("submit")).click();
	  
	  String message = driver.findElement(By.xpath("//p[3]/font/b")).getText().toString();
	  
	  assertEquals(message, "Note: Your user name is " + userName + "." );
	  System.out.println("Test Passed");
	  System.out.println(message);
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "E://Selenium Projects/libs/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get(appUrl);
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
	  driver.quit();
  }

}
