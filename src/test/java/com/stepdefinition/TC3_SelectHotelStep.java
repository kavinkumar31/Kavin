package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
	 * @author RAMKUMAR
	 * @see used to maintaine selecthotel snippets
	 * @date 16/feb/23
	 */
	public class TC3_SelectHotelStep extends BaseClass {
		PageObjectManager pom=new PageObjectManager();

		/**
		 * @see used to continue with select hotel
		 */
		@When("User perform continue with select hotel name")
		public void user_perform_continue_with_select_hotel_name() {
			pom.getSelectHotelPage().selectHotelName();
		   	}
		/**
		 * @see used to verify after continue success message
		 * @param expBookAHotelSuccesMsg
		 */
		@Then("User should verify after continue to navigate Book a hotel with success message {string}")
		public void user_should_verify_after_continue_to_navigate_book_a_hotel_with_success_message(String expBookAHotelSuccesMsg) {
			WebElement continueBookHotelSuccessMsg = pom.getSelectHotelPage().getBookAHotelSuccessMsg();
		String actSelectHotelSuccessMsg = gettext(continueBookHotelSuccessMsg);
		Assert.assertEquals(expBookAHotelSuccesMsg, actSelectHotelSuccessMsg);
			
		   	}
		/**
		 * @see used to continue without select hotel
		 */
		@When("User perform continue without select hotel name")
		public void user_perform_continue_without_select_hotel_name() {
			pom.getSelectHotelPage().clickContinue();
		  	}
		/**
		 * @see used to verify after continue error message
		 * @param expPleaseSelectAHotelErrorMsg
		 */
		@Then("User should verify after continue to navigate Book a hotel with error success message contains {string}")
		public void user_should_verify_after_continue_to_navigate_book_a_hotel_with_error_success_message_contains(String expPleaseSelectAHotelErrorMsg) {
			WebElement selectHotelErrorMsg = pom.getSelectHotelPage().getPleaseSelectAHotelErrorMsg();
			String actSelectHotelErrorMsg = gettext(selectHotelErrorMsg);
			Assert.assertEquals(expPleaseSelectAHotelErrorMsg, actSelectHotelErrorMsg);
		
		   	}





}
