package com.ecommerce.qa.testcases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecommerce.qa.base.TestBase;
import com.ecommerce.qa.pages.LoginPage;
import com.ecommerce.qa.pages.MyAccountPage;
import com.ecommerce.qa.util.TestUtil;

public class MyAccountPageTestCases extends TestBase {

	MyAccountPage accPage; 
	LoginPage loginpage;
	
	public MyAccountPageTestCases() throws FileNotFoundException, IOException {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		
		try {
			loginpage=new LoginPage();
			accPage=loginpage.signIn(prop.getProperty("email"), prop.getProperty("password"));
								
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	@Test(priority=1)
	public void startExecution1() {
		System.out.println("Execution Started My AccountPage");
	}
		@Test(priority=2)
		public void verifyLoggedInUserTest() throws IOException{
		  String Username="Anupama Patil";
		  
		//Capture screenshot for a individual test case failure
		  
		  try {
		  
			  String Username1=accPage.VerifyLoggedInUsername();
			  Assert.assertEquals(Username1, Username,"Logged in username not matched");
			  
		  }catch(Exception e){
			  			  		  
			  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			  String currentDir = System.getProperty("user.dir");
			  FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		  }
		  
		}
		
		//--------------- Data Driven Approach
		
		@DataProvider
		public Object[] getWishListData() {
			Object data[]=TestUtil.getTestData("Wishlist");
			return data;
		}
		
		@Test(priority=3,dataProvider="getWishListData")
		public void validateCreatewWishlistTest(String WishlistTitle) {
			accPage.createWishList(WishlistTitle);			
		}
				
	
}
