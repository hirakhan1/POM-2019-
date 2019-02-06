package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Qa.TestBaseDemo.TestBase;

public class LoginPage extends TestBase{
	@FindBy(id="email")
	WebElement userEmail;
	
	@FindBy(id="pass")
	WebElement userPass;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement loginButton;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	public void VerifyLogin()
	{
		userEmail.sendKeys(prop.getProperty("username"));
		userPass.sendKeys(prop.getProperty("password"));	
		loginButton.click();
	}	
}
