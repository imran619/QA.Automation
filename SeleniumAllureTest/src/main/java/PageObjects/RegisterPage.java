package PageObjects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import JSONRead.JSONReader;


public class RegisterPage {
	
	WebDriver driver;
	
	JSONReader jsonRead = new JSONReader();
	
	By firstName = By.name("firstName");
	By lasttName = By.name("lastName");
	By phone = By.name("phone");
	By email = By.name("userName");
	
	By address = By.name("address1");
	By city = By.name("city");
	By state = By.name("state");
	By postalCode = By.name("postalCode");
	
	By country = By.name("country");
	By UserName = By.name("email");
	By password = By.name("password");
	By confirmPassword = By.name("confirmPassword");
	By submitButton = By.name("submit");
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void registerNewCustomer() throws Throwable{
		
		 driver.findElement(By.name("firstName")).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "FIRST_NAME"));
		 driver.findElement(By.name("lastName")).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "LAST_NAME"));
		 driver.findElement(phone).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "PHONE"));
		 driver.findElement(email).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "EMAIL"));
		  
		 driver.findElement(address).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "ADDRESS"));
		 driver.findElement(city).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "CITY"));
		 driver.findElement(state).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "STATE"));
		 driver.findElement(postalCode).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "POSTAL_CODE"));
		  
		 Select countryDropdown = new Select(driver.findElement(country));
		 countryDropdown.selectByValue(jsonRead.jsonRead(".\\Data\\sel.json", "COUNTRY"));
		  
		 driver.findElement(UserName).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "USER_NAME"));
		 driver.findElement(password).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "PASSWORD"));
		 driver.findElement(confirmPassword).sendKeys(jsonRead.jsonRead(".\\Data\\sel.json", "CONFIRM_PASSWORD"));
		 driver.findElement(submitButton).click();
	}
}
