package com.facebook.TestCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Qa.TestBaseDemo.TestBase;
import com.facebook.pages.LoginPage;

public class LoginPageTest extends TestBase{
	//private static final String ActualTitle = null;
	LoginPage o;
	String title;
	String ExpectedTitle="Facebook";
	public LoginPageTest()
	{
		super();
	}
	@BeforeSuite
	public void SetUp()
	{
		initialisation();
		o=new LoginPage();
	}
	@Test
	public void VerifyTitle()
	{
		//SoftAssert softassertions=new SoftAssert();
		title=o.verifyTitle();
		System.out.println(title);
		//softassertions.assertEquals(ActualTitle, ExpectedTitle);
	}
	@Test
	public void Login()
	{
		o.VerifyLogin();
	}
	@AfterSuite
	public void Close_Browser()
	{
		driver.close();
	}
}
