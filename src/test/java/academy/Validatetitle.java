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

public class Validatetitle extends Base { //get methods of Base by inheritance
	public static Logger log= LogManager.getLogger(Base.class.getName());

	
	@BeforeTest 
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");

	}
	@Test
	public void basepageNavigation() throws IOException {
	
	
	Landingpage ln = new Landingpage(driver);
	//compare the text from browser with actual text .error
	AssertJUnit.assertEquals(ln.getTitle().getText(),"FEATUREDa COURSES");
	log.info("Successfully validated tet message");

	
	
}
	@AfterTest
	public void tearDown() {
		driver.close();
		driver =null;

	}
	
	
		 
		 
		 
		 
	 }
	 



