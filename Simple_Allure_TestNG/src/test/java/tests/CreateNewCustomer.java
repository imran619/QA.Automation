package tests;

import static org.testng.Assert.assertEquals;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import utils.Listeners.TestListener;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

@Listeners ({TestListener.class})
@Feature("Create new customer test")
public class CreateNewCustomer extends BaseTest {

	@Test (priority = 0, description = "Create a new customer scenario.")
	@Severity (SeverityLevel.CRITICAL)
	@Description ("Test Description : Create a new customer for New Tours website.")
	
	public void createNewCustomer() throws Throwable {
		
		_homePage.clickOnRegisterLink();
		_registerPage.registerNewCustomer();
		
		//saveImageAttach("Image attach");
		
		System.out.println(_confirmationPage.confirmationMessage());
		
		try {
		assertEquals(_confirmationPage.confirmationMessage(), "Note: Your user name is2 " + jsonRead.jsonRead(".\\Data\\data.json", "USER_NAME") + "." );
		}
		catch (AssertionError err){
			throw err;
		}		
	}
	}

	
