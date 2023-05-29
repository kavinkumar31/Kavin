package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
	 * @see used to search page in locator
	 * @author RAMKUMAR
	 *@date 16/feb/23
	 */
	public class SearchHotelPage extends BaseClass {

		public SearchHotelPage() {
			PageFactory.initElements(driver, this);
		}
			
		@FindBy(id="location")	
			private WebElement Location;

		@ FindBy(id="hotels")
		private WebElement hotel;

		@ FindBy(id="room_type")
		private WebElement roomType;

		@FindBy(id="room_nos")
		private WebElement noOfrooms;

		@ FindBy(id="datepick_in")
		private WebElement checkInDate;

		@ FindBy(id="datepick_out")
		private WebElement checkOutDate;

		@ FindBy(id="adult_room")
		private WebElement adultPerRoom;

		@FindBy(id="child_room")
		private WebElement childPerRoom;

		@FindBy(id="Submit")
		private WebElement submit;
		
		@FindBy(id="checkin_span")
		private WebElement txtInDateInvalidSuccessMsg;
		
		@FindBy(id="checkout_span")
		private WebElement txtOutDateInvalidSuccessMsg;
		
		@FindBy(xpath="//td[text()='Select Hotel ']")
		private WebElement txtSelectHotelSuccessMsg;
		
		@FindBy(id="location_span")
		private WebElement txtLocationErrorMsg;

		 public WebElement getTxtInDateInvalidSuccessMsg() {
			return txtInDateInvalidSuccessMsg;
		}

		public WebElement getTxtOutDateInvalidSuccessMsg() {
			return txtOutDateInvalidSuccessMsg;
		}

		public WebElement getTxtSelectHotelSuccessMsg() {
			return txtSelectHotelSuccessMsg;
		}

		public WebElement getTxtLocationErrorMsg() {
			return txtLocationErrorMsg;
		}

		public WebElement getDdlocation() {
			return Location;
		}

		public WebElement getDdHotel() {
			return hotel;
		}

		public WebElement getDdroomType() {
			return roomType;
		}

		public WebElement getDdroomNo() {
			return adultPerRoom;
		}

		public WebElement getInDate() {
			return checkInDate;
		}

		public WebElement getOutDate() {
			return checkOutDate;
		}

		public WebElement getDdtroom() {
			return noOfrooms;
		}

		public WebElement getDdchildRoom() {
			return childPerRoom;
		}

		public WebElement getBtnSerach() {
			return submit;
		}
	/**
	 * @see used to Search Hotel by Selecting all fields with manatory fields
	 * @param location
	 * @param hotel
	 * @param roomType
	 * @param noOfrooms
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultPerRoom
	 * @param childPerRoom
	 */
		public void searchHotels(String location,String hotel,String roomType,String noOfrooms,String checkInDate,String checkOutDate,String adultPerRoom,String childPerRoom) {
			
			dropDownByText(getDdlocation(), location);
			dropDownByText(getDdHotel(), hotel);
			dropDownByText(getDdroomType(), roomType);
			dropDownByText(getDdroomNo(), noOfrooms);
			clearTextBox(getInDate());
			elementsendkeys(getInDate(), checkInDate);
			clearTextBox(getOutDate());
			elementsendkeys(getOutDate(), checkOutDate);
	        dropDownByText(getDdtroom(), adultPerRoom);
	        dropDownByText(getDdchildRoom(), childPerRoom);
	        elementclick(getBtnSerach());
			 
			  }
		/**
		 * @see used to Search Hotel by checking and checkout invalid date details
		 * @param location
		 * @param noOfrooms
		 * @param checkInDate
		 * @param checkOutDate
		 * @param adultPerRoom
		 */
		
		 public void searchHotels(String location,String noOfrooms,String checkInDate,String checkOutDate,String adultPerRoom) {
			
			
			 dropDownByText(getDdlocation(), location);
			 dropDownByText(getDdroomNo(), noOfrooms);
			 clearTextBox(getInDate());
			 elementsendkeys(getInDate(), checkInDate);
			 clearTextBox(getOutDate());
			 elementsendkeys(getOutDate(), checkOutDate);
		      dropDownByText(getDdtroom(), adultPerRoom);
		      elementclick(getBtnSerach());
		        
			 	
		 }
		 /**
		  * @see used to without click any field details
		  */
		 public void searchHotel() {
				elementclick(getBtnSerach());
				
			}
			
		 
		
		}

