package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage{
	
	private final String BASE_URL = "http://quizful.net"; 
	private final Logger logger = LogManager.getRootLogger();
	@FindBy(xpath="//ul[@id='user-panel']//a[text()='войти']")
	private WebElement buttonSignIn;
	
	@FindBy(xpath="//h1[@id='page-title']")
	private WebElement generalHeader;
	
	@FindBy(xpath="//div[@id='login-form']//div[@class='title']//b")
	private WebElement titleFormAuthorisation;
	
	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Home page opened");
	}
	
	public void clickOnButtonSign()
	{
		buttonSignIn.click();
		logger.info("Authorisation page opened");
		
	}
	public String getHeader()
	{
		return generalHeader.getText();
	}
	public String getTitleFormAuthorisation()
	{
		return titleFormAuthorisation.getText();
	}

}
