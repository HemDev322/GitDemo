package academy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import java.io.IOException;

import pageObjects.Landingpage;
import resources.Base;

public class ValidateNavbar extends Base { //get methods of Base by inheritance
	public static Logger log= LogManager.getLogger(Base.class.getName());

	
	@BeforeTest 
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	
	
	@Test
	public void basepageNavigation() throws IOException {
	
	
	Landingpage ln = new Landingpage(driver);
	AssertJUnit.assertTrue(ln.getNavbar().isDisplayed());
	log.info("Navigation bar is present");

	
	
}
	@AfterTest
	public void tearDown() {
		driver.close();
		driver =null;
	}
	
	
		 
		 
		 
		 
	 }
	 



