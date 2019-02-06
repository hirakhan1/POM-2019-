package com.Qa.TestBaseDemo;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() 
	{
		try 
		{
			FileInputStream ip = new FileInputStream("D:\\java\\com.fbk\\src\\main\\java\\com\\facebook\\configuration\\config.properties");
			prop = new Properties();
			prop.load(ip);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public static void initialisation() 
	{
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) 
		{
	       System.setProperty(prop.getProperty("systemproperty_1"), prop.getProperty("systemproperty_2"));
	       driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}