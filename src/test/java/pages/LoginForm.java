package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LoginForm extends AbstractPage{
	
	private final String BASE_URL = "http://quizful.net/LoginAction.loginForm";
	private final Logger logger = LogManager.getRootLogger();
	
	@FindBy(xpath="//input[@id='login']")
	private WebElement inputLogin;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement inputPassword;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement inputCheckSaveMe;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement buttonSubmit;
	
	@FindBy(xpath="//a[text()='vsk1983']")
	private WebElement linkUser;
	
	public LoginForm(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("LoginForm opened");
	}
	
	public void login(String login, String password)
	{
		inputLogin.sendKeys(login);
		inputPassword.sendKeys(password);
		inputCheckSaveMe.click();
		buttonSubmit.click();
		logger.info("Login perfomed");
	}
	
	public String getUserName()
	{
		return linkUser.getText();
	}
}
