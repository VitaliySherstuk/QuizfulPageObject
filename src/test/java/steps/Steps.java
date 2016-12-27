package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import driver.DriverSingleton;
import pages.LoginForm;
import pages.MainPage;

public class Steps {

	private WebDriver driver;
	
	public void initBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "c:\\Selenium\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
	}
	public Steps(WebDriver driver)
	{
		this.driver = driver;
	}
	public void closeDriver()
	{
		driver.quit();
	}
	public void enterHomePage()
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
	}
	public boolean isGeneralHeader(String header)
	{
		MainPage mainPage = new MainPage(driver);
		return (mainPage.getHeader().toLowerCase().equals(header));
	}
	public void clickSignIn()
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnButtonSign();
	}
	public boolean isPageAuthorisation(String title)
	{
		MainPage mainPage = new MainPage(driver);
		return (mainPage.getTitleFormAuthorisation().toLowerCase().equals(title));
	}
	public void loginQuiful(String username, String password)
	{
		LoginForm loginForm = new LoginForm(driver);
		loginForm.openPage();
		loginForm.login(username, password);
	}
	
	public boolean isLoggedIn(String username)
	{
		LoginForm loginPage = new LoginForm(driver);
		return (loginPage.getUserName().trim().toLowerCase().equals(username));
	}
	

}
