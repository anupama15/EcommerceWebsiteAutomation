package com.ecommerce.qa.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Facory- OR(Object Repositories)
	
	@FindBy(id="header_logo")
	WebElement logoimg;
	
	@FindBy(className="login")
	WebElement signInLink;
	
	@FindBy(xpath="//input[@id='emailll']")
	WebElement Username;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement loginButt;
	
	
	//Actions
	
   public LoginPage() throws IOException {
	   PageFactory.initElements(driver,this);
	   
   }
	
   public boolean verifyLogo() {
		return logoimg.isDisplayed();
	}
   
   public MyAccountPage signIn(String email, String pwd) throws FileNotFoundException, IOException {
	   signInLink.click();
	   Username.sendKeys(email);
	   password.sendKeys(pwd);
	   loginButt.click();  
	   
	   return new MyAccountPage();
	   
   }
} 
