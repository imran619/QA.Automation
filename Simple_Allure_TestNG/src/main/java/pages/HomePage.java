package pages;

import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
	
	By registerLink = By.xpath("//td[@class='mouseOut']/a[@href='register.php']");
	
	public HomePage (WebDriver driver) {
		
		super(driver);
	}
	
	@Step ("Navigate to Register customer page stpe...")
	public void clickOnRegisterLink() {
		
		driver.findElement(registerLink).click();
	}

}
