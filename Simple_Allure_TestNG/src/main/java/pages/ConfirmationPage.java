package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

public class ConfirmationPage extends BasePage {
	
	By message = By.xpath("//p[3]/font/b");
	
	public ConfirmationPage(WebDriver driver) {
		
		super(driver);
	}
	
	@Step ("Get the Confirmation message step...")
	public String confirmationMessage() {
		
		return driver.findElement(message).getText().toString();
	}

}
