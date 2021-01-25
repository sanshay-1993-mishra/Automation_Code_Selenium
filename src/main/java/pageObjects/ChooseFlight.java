package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChooseFlight {

	public WebDriver driver;
	By chooseFlight=By.xpath("//tbody/tr[1]/td/input[@value='Choose This Flight']");
	

	public ChooseFlight(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getFlight()
	{
		return driver.findElement(chooseFlight);
	}

}
