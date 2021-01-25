package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver intializeDriver() throws IOException{
		
		 prop= new Properties();
		FileInputStream fis =new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
        prop.load(fis);	
     String browserName=prop.getProperty("browser");
     
     if(browserName.equals("chrome"))
     {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver.exe");
        driver= new ChromeDriver();
	
	}
     if(browserName.equals("IE"))
     {
    	 System.out.println("haha");
     }
	
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     return driver;
}

	
	
}