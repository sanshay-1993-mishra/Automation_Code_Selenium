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
import pageObjects.FlightInfo;
import pageObjects.LandingPage;
import resources.ExcelFileData;
import resources.base;

public class User_Info extends base {

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
	public void userDetails() throws IOException
	{
		
		ExcelFileData.setExcelFile("C:\\Users\\Lenovo\\Desktop\\Flight_Booking_Test.xls","Sheet1");
		for(int i=1;i<=ExcelFileData.getRowCountInSheet();i++)
        {
			//verify if user is able to fill To and From country and able to choose the Flight
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
		
		
		FlightInfo fi=new FlightInfo(driver);
		Assert.assertEquals(fi.getTitle1().getText(), "Your flight from TLV to SFO has been reserved.");
		fi.getName().sendKeys(ExcelFileData.getCellData(i, 3));
		fi.getAddress().sendKeys(ExcelFileData.getCellData(i, 4));
		fi.getCity().sendKeys(ExcelFileData.getCellData(i, 5));
		fi.getState().sendKeys(ExcelFileData.getCellData(i, 6));
		fi.getZipCode().sendKeys(ExcelFileData.getCellData(i, 7));
        
		Select ct=new Select(fi.getCardType());
		ct.selectByVisibleText(ExcelFileData.getCellData(i, 8));
		fi.getCreditCardNumber().sendKeys(ExcelFileData.getCellData(i, 9));
		fi.getMonth().click();
		fi.getMonth().clear();
		fi.getMonth().sendKeys(ExcelFileData.getCellData(i, 10));
		fi.getYear().click();
		fi.getYear().clear();
		fi.getYear().sendKeys(ExcelFileData.getCellData(i, 11));
		fi.getNeOnCard().sendKeys(ExcelFileData.getCellData(i, 12));
		fi.getPurchaseFlight().click();
		String BookingID=fi.getBookingID().getText();
		System.out.println("Flight Booking ID is: "+BookingID);
        }
		}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
