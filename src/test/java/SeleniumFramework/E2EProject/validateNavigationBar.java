package SeleniumFramework.E2EProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.ChooseFlight;
import pageObjects.LandingPage;
import resources.base;

public class validateNavigationBar extends base {
	
	public WebDriver driver;

	@BeforeTest
	public void intialize() throws IOException
	{
		driver=intializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
 @Test
 public void basePageNavigation() throws IOException
	{   //verify if user is able to navigate to URL and verify title
		LandingPage lp=new LandingPage(driver);
		Assert.assertEquals(lp.getTitle().getText(), "Welcome to the Simple Travel Agency!");
		
}



 @AfterTest
	public void tearDown()
	{
		driver.close();
	}
}