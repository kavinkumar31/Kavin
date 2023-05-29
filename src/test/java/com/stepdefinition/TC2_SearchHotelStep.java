package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
	 * @author RAMKUMAR
	 * @see used to maintain search hotel snippets
	 * @date 16/feb/23
	 */
	public class TC2_SearchHotelStep extends BaseClass {
		PageObjectManager pom=new PageObjectManager();

		/**
		 * @see used to search hotel with valid details
		 * @param location
		 * @param hotels
		 * @param roomType
		 * @param noOfRooms
		 * @param chechInDate
		 * @param checkOutDate
		 * @param adultsPerRoom
		 * @param childernPerRoom
		 */
		@When("User select search hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
		public void user_select_search_hotel_and(String location,String hotels,String roomType,String noOfRooms,String checkInDate,String checkOutDate,String adultsPerRoom,String childernPerRoom) {
		  pom.getSearchHotelPage().searchHotels(location, hotels, roomType, noOfRooms, checkInDate, checkOutDate, adultsPerRoom, childernPerRoom);
		}
		/**
		 * @see used to verify after search hotel succes message
		 * @param expselectHotelSuccesMsg
		 */
		@Then("User should verify after search to navigate select hotel sucess message {string}")
		public void user_should_verify_after_search_to_navigate_select_hotel_sucess_message(String expselectHotelSuccesMsg) {
			WebElement txtSelectHotelSuccessMsg = pom.getSearchHotelPage().getTxtSelectHotelSuccessMsg();
			String actSuccessMsg = gettext(txtSelectHotelSuccessMsg);
			//boolean contains = actSuccessMsg.contains(expselectHotelSuccesMsg);
			Assert.assertEquals(expselectHotelSuccesMsg, actSuccessMsg);
		   
		}
	    /**
	     * @see used to search only mandatory fields
	     * @param location
	     * @param noOfRooms
	     * @param checkInDate
	     * @param checkOutDate
	     * @param adultsPerRoom
	     */
		@When("User select all manatory fields {string},{string},{string},{string} and {string}")
		public void user_select_all_manatory_fields_and(String location,String noOfrooms,String checkInDate,String checkOutDate,String adultPerRoom) {
			pom.getSearchHotelPage().searchHotels(location, noOfrooms, checkInDate, checkOutDate, adultPerRoom);
			
		 
		}
		/**
		 * @see used to search invalid checkin and checkout date
		 * @param location
		 * @param hotels
		 * @param roomType
		 * @param noOfRooms
		 * @param checkInDate
		 * @param checkOutDate
		 * @param adultsPerRoom
		 * @param childernPerRoom
		 */
		@When("User select search invalied checkin and checkout date {string},{string},{string},{string},{string},{string},{string} and {string}")
		public void user_select_search_invalied_checkin_and_checkout_date_and(String location,String hotel,String roomType,String noOfrooms,String checkInDate,String checkOutDate,String adultPerRoom,String childPerRoom) {
		pom.getSearchHotelPage().searchHotels(location, hotel, roomType, noOfrooms, checkInDate, checkOutDate, adultPerRoom, childPerRoom);
		   	}
		
		/**
		 * @see used to verify after search hotel error message
		 * @param expInvalidDateErrorMsg
		 * @param ExpInvalidErrorMsg
		 */
		@Then("User should verify after search hotel error message contains {string} and {string}")
		public void user_should_verify_after_search_hotel_error_message_contains_and(String expInvalidDateErrorMsg, String ExpInvalidErrorMsg) {
			WebElement actInDateErrorMsg = pom.getSearchHotelPage().getTxtInDateInvalidSuccessMsg();
			String actErrorMsg = gettext(actInDateErrorMsg);
			Assert.assertEquals(expInvalidDateErrorMsg, actErrorMsg);
			
			WebElement actOutDateErrorMsg = pom.getSearchHotelPage().getTxtOutDateInvalidSuccessMsg();
			String actErrorOutMsg = gettext(actOutDateErrorMsg);
			Assert.assertEquals(ExpInvalidErrorMsg, actErrorOutMsg);
			
		   	}
	      /**
	       * @see used to search without enter any fields
	       */
	    @When("User click search button without enter any fields")
		public void user_click_search_button_without_enter_any_fields() {
	    	pom.getSearchHotelPage().searchHotel();
		   
		}
	    /**
	     * @see used to verify after search with error message
	     * @param expectedPleaseSelectAlocationErrorMsg
	     */
		@Then("User should verify after search with error message contains {string}")
		public void user_should_verify_after_search_with_error_message_contains(String expectedPleaseSelectAlocationErrorMsg) {
			WebElement locationErrorMsg = pom.getSearchHotelPage().getTxtLocationErrorMsg();
			String actLocationErrorMsg = gettext(locationErrorMsg);
			//String actLocationErrorMsg = getattributevalue(locationErrorMsg);
			Assert.assertEquals(expectedPleaseSelectAlocationErrorMsg, actLocationErrorMsg);
		   
		


		}}




