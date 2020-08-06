
/*
 * Author - Anupama Chetan Suryawanshi
 */

package com.ecommerce.qa.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.qa.base.TestBase;

public class MyAccountPage extends TestBase {

	
	@FindBy(xpath="//a[@title='View my customer account']/parent::div[@class='header_user_info']")
	WebElement loggedInUserName;
	
	@FindBy(xpath="//*[text()='My wishlists']")
	WebElement myWishlistLink;
	
	@FindBy(xpath="//*[@type='text' and @id='name']")
	WebElement wishlistName;
	
	@FindBy(id="submitWishlist")
	WebElement submitWishLstButt;
	//Actions
	
	public MyAccountPage() throws FileNotFoundException, IOException {
		PageFactory.initElements(driver,this);
	}
	
	public String VerifyLoggedInUsername() {
		return loggedInUserName.getText();
	}

	public void createWishList(String lname) {
		myWishlistLink.click();
		 wishlistName.sendKeys(lname);
		 submitWishLstButt.click();
		 
	}
	
	public void verifyWishlist(String listName) {
		
			
	}
	
	
	
	
	
	
	
	
}
