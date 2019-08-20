package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {

	public WebDriver driver;
	By signin = By.xpath("//span[contains(text(),'Login')]");
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navbar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	By popup=By.xpath("//*[@id=\"homepage\"]/div[5]/div[2]/div/div/div/span/div/div[6]/div/div/button"); //get popup element


	
	public Landingpage(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement getLogin() {
		return driver.findElement(signin);
		
	}
	public int getPopUpSize() //get size of popup

	{

	return driver.findElements(popup).size();

	}

	public WebElement getPopUp() //get popup clickable element and return it

	{

	return driver.findElement(popup);
	
	
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getNavbar() {
		return driver.findElement(navbar);
	}
	
	
}
