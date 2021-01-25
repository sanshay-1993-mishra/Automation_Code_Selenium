package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightInfo {

	public WebDriver driver;
	By title1=By.cssSelector("body > div.container > h2");
	By name=By.cssSelector("#inputName");
	By address=By.cssSelector("#address");
	By city=By.cssSelector("#city");
	By state=By.cssSelector("#state");
	By zipCode=By.cssSelector("#zipCode");
	By cardType=By.cssSelector("#cardType");
	By creditCardNumber=By.cssSelector("#creditCardNumber");
	By month=By.cssSelector("#creditCardMonth");
	By year=By.cssSelector("#creditCardYear");
	By nameOnCard=By.cssSelector("#nameOnCard");
	By purchaseFlight=By.xpath("//input[@value='Purchase Flight']");
	By bookingID=By.xpath("//tr[1]//td[2]");

	public FlightInfo(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getTitle1()
	{
		return driver.findElement(title1);
	}
	public WebElement getName()
	{
		return driver.findElement(name);
	}
	public WebElement getAddress()
	{
		return driver.findElement(address);
	}
	public WebElement getCity()
	{
		return driver.findElement(city);
	}
	public WebElement getState()
	{
		return driver.findElement(state);
	}
	public WebElement getZipCode()
	{
		return driver.findElement(zipCode);
	}
	public WebElement getCardType()
	{
		return driver.findElement(cardType);
	}
	public WebElement getCreditCardNumber()
	{
		return driver.findElement(creditCardNumber);
	}
	public WebElement getMonth()
	{
		return driver.findElement(month);
	}
	public WebElement getYear()
	{
		return driver.findElement(year);
	}
	public WebElement getNeOnCard()
	{
		return driver.findElement(nameOnCard);
	}
	public WebElement getPurchaseFlight()
	{
		return driver.findElement(purchaseFlight);
	}
	public WebElement getBookingID()
	{
		return driver.findElement(bookingID);
	}
	
}
