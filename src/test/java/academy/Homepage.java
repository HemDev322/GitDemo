package academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pageObjects.Landingpage;
import pageObjects.Loginpage;
import resources.Base;

public class Homepage extends Base { //get methods of Base by inheritance
	public static Logger log= LogManager.getLogger(Base.class.getName());

	@BeforeTest 
	public void initialize() throws IOException {
		driver = initializeDriver();
	}
	@Test(dataProvider="getData")
	public void basepageNavigation(String Username, String Password, String text) throws IOException {
	
		driver.get(prop.getProperty("url")); //not putting in beforetest cos it needs to hit the url for each data set
     Landingpage ln = new Landingpage(driver);
	if(ln.getPopUpSize()>0) //check if popup exists

	{

	ln.getPopUp().click(); //click on popup

	}
	ln.getLogin().click();
	Loginpage lp = new Loginpage(driver);
	lp.getEmail().sendKeys(Username);
	lp.getPassword().sendKeys(Password);
	//System.out.println(text); using log instead
     log.info(text);
	lp.getLogin().click();
	
	
}
	@AfterTest
	public void tearDown() {
		driver.close();
		driver =null; //remove from memory

	}
	
	 @DataProvider
	 public Object[][] getData() {
		 //rows stands for different types of datatypes the test shoud run
		 //columns stand for how many values per test
		 Object[][] data = new Object[2][3]; //array size 
		 
		 //0th row
		 data[0][0] ="nonrestricteduser@qw.com";
		 data[0][1]	="12345";
		 data[0][2] ="Non Restricted user";
		 
		 //1st row
		 data[1][0] ="restricteduser@qw.com";
		 data[1][1]	="34567";
		 data[1][2] ="Restricted user";
		 
		 return data;
		 
		 
		 
		 
	 }
	


}
