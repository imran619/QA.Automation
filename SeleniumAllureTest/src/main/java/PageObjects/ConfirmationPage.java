package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
	
	WebDriver driver;
	
	By message = By.xpath("//p[3]/font/b");
	
	public ConfirmationPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public String confirmationMessage() {
		
		return driver.findElement(message).getText().toString();
	}

}
