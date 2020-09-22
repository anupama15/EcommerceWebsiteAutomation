/*
 * 
 * Author - Anupama 
 * 
 */



package com.ecommerce.qa.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecommerce.qa.base.TestBase;
import com.ecommerce.qa.pages.LoginPage;
import com.ecommerce.qa.pages.MyAccountPage;

public class LoginPageTestCases extends TestBase {

	LoginPage loginPage;
	MyAccountPage myAcc;
	
	public LoginPageTestCases() throws FileNotFoundException, IOException {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		
		try {
			loginPage=new LoginPage();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test(priority=0)
	public void verifyLogoOfApplicationTest() {
		System.out.println("Verify Logo method");
		Boolean flag1=loginPage.verifyLogo();
		
		Assert.assertTrue(flag1);
	
	}
	
	@Test(priority=0)
	public void startExecution() {
		System.out.println("Execution Started Login page");
	}
	
	@Test(priority=1)
	public void loginTest() throws FileNotFoundException, IOException {
		myAcc=loginPage.signIn(prop.getProperty("email"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
}
