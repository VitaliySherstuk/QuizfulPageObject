package driver;

import java.util.concurrent.TimeUnit;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

	 	private static WebDriver driver;
	   private static final Logger logger = LogManager.getRootLogger();
	   

	    private DriverSingleton(){};


	    public static WebDriver getDriver(){
	        if (null == driver){
	        	System.setProperty("webdriver.gecko.driver", "c:\\Selenium\\Drivers\\geckodriver.exe");
	            driver = new FirefoxDriver();
	            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	            driver.manage().window().maximize();
	          logger.info("Browser started");
	        }

	        return driver;
	    }

	    public static void closeDriver(){
	        driver.quit();
	        driver = null;
	    }
}
