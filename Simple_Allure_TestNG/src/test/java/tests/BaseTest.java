package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import JSONRead.JSONReader;
import pages.*;

public class BaseTest {
    public WebDriver driver;
    public HomePage _homePage;
    public RegisterPage _registerPage;
    public ConfirmationPage _confirmationPage;
    JSONReader jsonRead = new JSONReader();

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void classLevelSetup() throws Throwable {
    	  System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
	      
	      driver.get(jsonRead.jsonRead(".\\Data\\data.json", "URL"));
    }

    @BeforeMethod
    public void methodLevelSetup() {
    	_homePage = new HomePage(driver);
    	_registerPage = new RegisterPage(driver);
    	_confirmationPage = new ConfirmationPage(driver);
    }

    @AfterClass
    public void teardown() {
    	driver.close();
        driver.quit();
    }
}