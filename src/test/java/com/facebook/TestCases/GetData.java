package com.facebook.TestCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetData {

	//String path;
	String uname,pass;
	public void display() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium Software\\chrome\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
			
		Xls_Reader ob=new Xls_Reader("D:\\Selenium Software\\Data.xls");
		int count=ob.getRowCount("login");
        System.out.println("Number of rows :"+count);
        
        String url=driver.getCurrentUrl();
        System.out.println("Url of page is - "+url); 
        String sheeturl=ob.getCellData("login", "Expected Result", 2);
		System.out.println("Expected URL - "+sheeturl);
		if(url.equals(sheeturl))
			{
				ob.setCellData("login", "Status", 2, "Pass");
				System.out.println("You are on correct page");
			}
			else
			{
				ob.setCellData("login", "Status", 2, "Fail");
				System.out.println("You are on incorrect page");
			}  

        String title=driver.getTitle();
		System.out.println("Actual title -"+title);
		String expected=ob.getCellData("login", "Expected Result", 3);
		System.out.println("Expected Title - "+expected);
		if(title.equals(expected))
		{
			ob.setCellData("login", "Status", 3, "Pass");
			System.out.println("Title is correct ");
		}
		else
		{
			ob.setCellData("login", "Status", 3, "Fail");
			System.out.println("Incorrect title ");
		}
		
		FileInputStream fs=new FileInputStream("D:\\Selenium Software\\Data.xls");
		HSSFWorkbook wb=new HSSFWorkbook(fs);
		HSSFSheet sheet=wb.getSheet("login");
		int size=sheet.getLastRowNum();
		for(int i=3;i<=size;i++){
		HSSFRow row=sheet.getRow(i);
		System.out.println("Username - "+row.getCell(4).toString());
		uname=row.getCell(4).toString();
		System.out.println("Password - "+row.getCell(5).toString());
		pass=row.getCell(5).toString();

		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(pass);
		driver.findElement(By.id("loginbutton")).click();
			
		String fb_url=driver.getCurrentUrl();
		System.out.println("fb url - "+fb_url);
		String credentialsURL=ob.getCellData("login", "Expected Result",( i+1));
		System.out.println("Expected url  - "+credentialsURL);
		if(fb_url.equals(credentialsURL))
		{
			ob.setCellData("login", "Status", (i+1), "Pass");
			System.out.println("you are on correct page");
		}
		else
		{
			ob.setCellData("login", "Status", (i+1), "Fail");
			System.out.println("you are on incorrect page");
		}
		driver.navigate().back();
		}	
	wb.close();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		GetData o=new GetData();
		o.display();
	}

}
