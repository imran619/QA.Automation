package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import JSONRead.JSONReader;
import io.qameta.allure.Step;


public class RegisterPage extends BasePage {
	
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
		
		super(driver);
		
	}
	
	@Step ("Fill in the customer details and submit the form step...")
	public void registerNewCustomer() throws Throwable{
		
		 driver.findElement(By.name("firstName")).sendKeys(jsonRead.jsonRead(".\\Data\\data.json", "FIRST_NAME"));
		 driver.findElement(By.name("lastName")).sendKeys(jsonRead.jsonRead(".\\Data\\data.json", "LAST_NAME"));
		 driver.findElement(phone).sendKeys(jsonRead.jsonRead(".\\Data\\data.json", "PHONE"));
		 driver.findElement(email).sendKeys(jsonRead.jsonRead(".\\Data\\data.json", "EMAIL"));
		  
		 driver.findElement(address).sendKeys(jsonRead.jsonRead(".\\Data\\data.json", "ADDRESS"));
		 driver.findElement(city).sendKeys(jsonRead.jsonRead(".\\Data\\data.json", "CITY"));
		 driver.findElement(state).sendKeys(jsonRead.jsonRead(".\\Data\\data.json", "STATE"));
		 driver.findElement(postalCode).sendKeys(jsonRead.jsonRead(".\\Data\\data.json", "POSTAL_CODE"));
		  
		 Select countryDropdown = new Select(driver.findElement(country));
		 countryDropdown.selectByValue(jsonRead.jsonRead(".\\Data\\data.json", "COUNTRY"));
		  
		 driver.findElement(UserName).sendKeys(jsonRead.jsonRead(".\\Data\\data.json", "USER_NAME"));
		 driver.findElement(password).sendKeys(jsonRead.jsonRead(".\\Data\\data.json", "PASSWORD"));
		 driver.findElement(confirmPassword).sendKeys(jsonRead.jsonRead(".\\Data\\data.json", "CONFIRM_PASSWORD"));
		 //driver.findElement(confirmPassword).sendKeys("");
		 driver.findElement(submitButton).click();
	}
}
