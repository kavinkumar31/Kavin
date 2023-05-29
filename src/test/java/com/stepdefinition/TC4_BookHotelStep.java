package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
	 * @author RAMKUMAR
	 * @see used to maintain bookinghotel snippets
	 * @date 16/feb/23
	 */
	public class TC4_BookHotelStep extends BaseClass {
		PageObjectManager pom=new PageObjectManager();

		/**
		 * @see used to enter booking with valid details
		 * @param firstName
		 * @param lastName
		 * @param billingAddress
		 * @param dataTable
		 */
		@When("user book hotel {string},{string} and {string}")
		public void user_book_hotel_and(String firstName, String lastName, String billingAddress, io.cucumber.datatable.DataTable dataTable) {
		  
		  List<Map<String, String>> asMaps = dataTable.asMaps();
		  Map<String, String> s1 = asMaps.get(1);
		  String ccNum = s1.get("creditCardNo");
		  String ccType = s1.get("creditCardType");
		  String month = s1.get("month");
		  String expYear = s1.get("year");
		  String cvv = s1.get("cvvNumber");
		  
		  pom.getBookHotelPage().BookHotel1(firstName, lastName, billingAddress, ccNum, ccType, month, expYear, cvv);
		  
		   	}
		/**
		 * @see used to verify after enter booking success message
		 * @param expBookingConfirmationSuccesMsg
		 */
		@Then("User should verify after enter booking details success message {string} and save the Order Id")
		public void user_should_verify_after_enter_booking_details_success_message_and_save_the_order_id(String expBookingConfirmationSuccesMsg) {
		   WebElement actBookingConfirSucessMsg = pom.getBookHotelPage().getBookingConfirmationSuccessMsg();
		   implicityWait(20);
		   
		   String sucessMsg = gettext(actBookingConfirSucessMsg);
		   
		   WebElement actBookingConfirmationSuccessErorrMsg1 = pom.getBookHotelPage().getBookingConfirmationSuccessMsg();
		   String successMsg = gettext(actBookingConfirmationSuccessErorrMsg1);
		   Assert.assertEquals(expBookingConfirmationSuccesMsg, sucessMsg);
		}
		/**
		 * @see used to click book now button without enter booking details
		 */
		@When("User click book now button without enter booking details")
		public void user_click_book_now_button_without_enter_booking_details() {
			pom.getBookHotelPage().BookHotel();
		   
		}
		/**
		 * @see used to verify after click book now button error message
		 * @param expFirstNameErrorMsg
		 * @param expLastNameErrorMsg
		 * @param expAddressErrorMsg
		 * @param expCcNumberErrorMsg
		 * @param expCcTypeErrorMsg
		 * @param expCcExpiryMonthErrorMsg
		 * @param expCcCvvNumberErrorMsg
		 */
		@Then("User should verify after click book now button error message contains {string},{string},{string},{string},{string},{string} and {string}")
		public void user_should_verify_after_click_book_now_button_error_message_contains_and(String expFirstNameErrorMsg, String expLastNameErrorMsg, String expEnterAddressErrorMsg, String expCcNumberErrorMsg, String expCcTypeErrorMsg, String expCcExpiryMonthErrorMsg, String expCcCvvNumberErrorMsg) {
			WebElement txtFirstNameErrorMsg = pom.getBookHotelPage().getTxtFirstNameErrorMsg();
			String actFirstNameErrorMsg = gettext(txtFirstNameErrorMsg);
			//Assert.assertEquals(expFirstNameErrorMsg, actFirstNameErrorMsg);
			Assert.assertEquals("verify after error msg", expFirstNameErrorMsg, actFirstNameErrorMsg);
			
			WebElement txtLastNameErrorMsg = pom.getBookHotelPage().getTxtLastNameErrorMsg();
			String actLastNameErrorMsg = gettext(txtLastNameErrorMsg);
			//Assert.assertEquals(txtLastNameErrorMsg, actLastNameErrorMsg);
			Assert.assertEquals("verify after error msg", expLastNameErrorMsg, actLastNameErrorMsg);
			
			WebElement txtEnterAddressErrorMsg = pom.getBookHotelPage().getTxtEnterAddressErrorMsg();
			String actEnterAddressErrorMsg = gettext(txtEnterAddressErrorMsg);
			//Assert.assertEquals(txtEnterAddressErrorMsg, actAddressErrorMsg);
			Assert.assertEquals("verify after error msg", expEnterAddressErrorMsg, actEnterAddressErrorMsg);
			
			WebElement txtCreditCardNumberErrorMsg = pom.getBookHotelPage().getTxtCreditCardNumberErrorMsg();
			String actCreidCardNumberErrorMsg = gettext(txtCreditCardNumberErrorMsg);
			//Assert.assertEquals(txtCreditCardNumberErrorMsg, actCreidCardNumberErrorMsg);
			Assert.assertEquals("verify after error msg", expCcNumberErrorMsg, actCreidCardNumberErrorMsg);
			
			WebElement creditCardTypeErrorMsg = pom.getBookHotelPage().getCreditCardTypeErrorMsg();
			String actccTypeErrorMsg = gettext(creditCardTypeErrorMsg);
			//Assert.assertEquals(creditCardTypeErrorMsg, actccTypeErrorMsg);
			Assert.assertEquals("verify after error msg", expCcTypeErrorMsg, actccTypeErrorMsg);
			
			WebElement creditCardExpiryMonthErrorMsg = pom.getBookHotelPage().getCreditCardExpiryMonthErrorMsg();
			String actccMonthErrorMsg = gettext(creditCardExpiryMonthErrorMsg);
			//Assert.assertEquals(creditCardExpiryMonthErrorMsg, actccMonthErrorMsg);
			Assert.assertEquals("verify after error msg", expCcExpiryMonthErrorMsg, actccMonthErrorMsg);
			
			WebElement cvvNumberErrorMsg = pom.getBookHotelPage().getCvvNumberErrorMsg();
			String actcvvNumberErrorMsg = gettext(cvvNumberErrorMsg);
			//Assert.assertEquals(cvvNumberErrorMsg, actcvvNumberErrorMsg);
			Assert.assertEquals("verify after error msg", expCcCvvNumberErrorMsg, actcvvNumberErrorMsg);
			
			}
	}


