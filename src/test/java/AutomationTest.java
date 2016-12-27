import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driver.DriverSingleton;
import steps.Steps;

public class AutomationTest {

	private Steps steps;
	private final String USERNAME = "vsk1983";
	private final String PASSWORD = "1234";
	private final String HEADER = "главная";
	
	private WebDriver driver;
	
	@BeforeClass
	public void setUp()
	{
		driver = DriverSingleton.getDriver();
		steps = new Steps(driver);
		
	}
	@Test
	public void aTestHomePage()
	{
		steps.enterHomePage();
		Assert.assertTrue(steps.isGeneralHeader(HEADER));
	}
	@Test
	public void bTestSignIn()
	{
		steps.clickSignIn();
		Assert.assertTrue(steps.isPageAuthorisation("вход в систему"));
	}
	@Test
	public void cTestCanLoginQuizful()
	{
		steps.loginQuiful(USERNAME, PASSWORD);
		Assert.assertTrue(steps.isLoggedIn(USERNAME));
		
	}

	
	@AfterClass
	public void stopBrowser()
	{
		steps.closeDriver();
	}
}
