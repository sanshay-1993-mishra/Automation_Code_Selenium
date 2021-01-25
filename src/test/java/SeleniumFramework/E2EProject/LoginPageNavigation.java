package SeleniumFramework.E2EProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.base;

public class LoginPageNavigation extends base{

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
public void homePageNavigation() throws IOException
{   //verify if user is able to navigate to home login page and verify title
	LandingPage lp=new LandingPage(driver);
	lp.getHome().click();
	Assert.assertEquals(lp.getLoginPage().getText(), "Login");
	
}

 @AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
