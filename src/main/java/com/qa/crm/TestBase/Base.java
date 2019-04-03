package com.qa.crm.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.crm.TestUtils.Utility;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	
	public Base()
	{
		try {
		FileInputStream	fis = new FileInputStream("D:\\Selenium\\Workspace\\FreeCRMMaven\\src\\main\\java\\com\\qa\\crm\\config\\configuration.properties");
		prop = new Properties();
		prop.load(fis);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static void initialization()
	{
		if(prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\Software\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utility.pageloadtimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.implicitywait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	
}
