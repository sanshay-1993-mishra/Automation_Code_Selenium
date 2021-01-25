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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.ChooseFlight;
import pageObjects.FlightInfo;
import resources.ExcelFileData;
import resources.base;

public class Flight_Booking extends base {
	public WebDriver driver;
	
	@BeforeTest
	public void intialize() throws IOException
	{
		driver=intializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	//@Test(dataProvider="getData")
	@Test
	public void selectFlight() throws IOException
	{
		//verify if user is able to fill To and From country and able to choose the Flight
		
		ExcelFileData.setExcelFile("C:\\Users\\Lenovo\\Desktop\\Flight_Booking_Test.xls","Sheet1");
		
		for(int i=1;i<=ExcelFileData.getRowCountInSheet();i++)
        {
		LandingPage lp=new LandingPage(driver);
		Select from=new Select(lp.getFrom());
		from.selectByVisibleText(ExcelFileData.getCellData(i, 1));
		Select to=new Select(lp.getTo());
		to.selectByVisibleText(ExcelFileData.getCellData(i, 2));
		lp.getFindFlights().click();
		WebDriverWait d=new WebDriverWait(driver,10);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.container > h3")));
		ChooseFlight cf=new ChooseFlight(driver);
		cf.getFlight().click();
		//verify if user is able to navigate to Travel the World page from choose flight page and verify title
		lp.getTravelTheWorld().click();
		Assert.assertEquals(lp.getTitle().getText(), "Welcome to the Simple Travel Agency!");
        }
		
		}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
