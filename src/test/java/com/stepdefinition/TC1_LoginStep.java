package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
	 * @author RAMKUMAR
	 * @see used to maintain login snippets
	 * @date 16/feb/23
	 */
	public class TC1_LoginStep extends BaseClass {
		PageObjectManager pom=new PageObjectManager();

		/**
		 * @see used to lanuch url
		 */
		@Given("User is on the adachin page")
		public void user_is_on_the_adachin_page() throws FileNotFoundException, IOException {
			
		    	}
		/**
		 * @see used to perform login valid credentials
		 * @param username
		 * @param Password
		 */
		@When("User perform login {string},{string}")
		public void user_perform_login(String userName, String password) {
			pom.getLoginPage().login(userName, password);

			
		   
		}
		/**
		 * @see used to perform login with enter key
		 * @param username
		 * @param Password
		 * @throws AWTException 
		 */
		@When("User perform login {string},{string} with Enter Key")
		public void user_perform_login_with_enter_key(String userName, String password) throws AWTException {
			pom.getLoginPage().loginWithEnter(userName, password);
			
		   	}
		/**
		 * @see used to login with invalid credentails and verify error message
		 * @param expLoginErrorMessage
		 */
	    @Then("User should verify after login with Invalid Credential error message contains {string}")
		public void user_should_verify_after_login_with_invalid_credential_error_message_contains(String expLoginErrorMessage) {
	    	WebElement txtErrorMsg = pom.getLoginPage().getTxtErrorLogin();
	    	String actLoginSuccessMsg = gettext(txtErrorMsg);
	    	boolean b = actLoginSuccessMsg.contains(expLoginErrorMessage);
	    	Assert.assertTrue("verify after login with Invalid credential error msg contains", b);
	   // Assert.assertEquals("verify", expLoginErrorMessage, actLoginSuccessMsg);
	    	
	    	
		   }
		}


