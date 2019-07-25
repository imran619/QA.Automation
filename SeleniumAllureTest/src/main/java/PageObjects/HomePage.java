package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class HomePage {
	
	WebDriver driver;
	
	By registerLink = By.xpath("//td[@class='mouseOut']/a[@href='register.php']");
	
	public HomePage (WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void clickOnRegisterLink() {
		
		driver.findElement(registerLink).click();
	}

}
