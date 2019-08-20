package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Base {
	// say you have 1500 test cases so we put driver invocation in one single class

	public static WebDriver driver; // write driver globally instead of creating in each if statement and static 
	public Properties prop; // 


	public WebDriver initializeDriver() throws IOException {
		
		prop= new Properties();

		FileInputStream fis = new FileInputStream("/Users/dev_Account/Project/src/main/java/resources/Data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) { //give equals when comparing value from property and not ==
			System.setProperty("webdriver.chrome.driver",
					"/Users/dev_Account/Developer/AutomationTesting_Selenium/chromedriver");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"/Users/dev_Account/Developer/AutomationTesting_Selenium/geckodriver");
			driver = new FirefoxDriver();

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // give the implicit time here so if manager
																			// says to change wait time you can do it
																			// for 1000s of test cases here in oje shot

		return driver; //return driver to any testcase which needs it
	}
	
	public void getScreenshots(String result) throws IOException {
		File src=	 ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //cast driver as takesscreenshotdriver and outputas file
	FileUtils.copyFile(src,new File("/Users/dev_Account/Developer/AutomationTesting_Selenium/"+result+"screenshot.png")); //get the file to your local machine

	}

}
