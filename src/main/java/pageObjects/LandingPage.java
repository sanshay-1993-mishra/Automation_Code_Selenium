package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	
	By title=By.cssSelector("div > h1");
	By toPort=By.xpath("//select[@name='toPort']");
	By fromPort=By.xpath("//select[@name='fromPort']");
	By findFlights=By.xpath("//input[@value='Find Flights']");
	By home=By.xpath("//a[@href='home']");
	By travelTheWorld=By.xpath("//a[contains(text(),'Travel The World')]");
	By loginPage=By.xpath("//div[contains(text(),'Login')]");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
     
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getHome()
	{
		return driver.findElement(home);
	}
	public WebElement getLoginPage()
	{
		return driver.findElement(loginPage);
	}
	public WebElement getTravelTheWorld()
	{
		return driver.findElement(travelTheWorld);
	}
	
	public WebElement getFrom()
	{
		return driver.findElement(fromPort);
	}
	
	
	public WebElement getTo()
	{
		return driver.findElement(toPort);
	}
	
	public WebElement getFindFlights()
	{
		return driver.findElement(findFlights);
	}

}
