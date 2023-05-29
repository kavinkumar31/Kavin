package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
	 * @see used to maintain the bookhotel page locators
	 * @author RAMKUMAR
	 * @date 16/feb/23
	 */
	public class BookHotelPage extends BaseClass {
		public BookHotelPage() {
			PageFactory.initElements(driver, this);
			
			}
		@FindBy(id="first_name")
		private WebElement txtFirstName;
		
		@FindBy(id="last_name")
		private WebElement txtLastName;
		
		@FindBy(id="address")
		private WebElement txtAddress;
		
		@FindBy(id="cc_num")
		private WebElement txtCcNum;
		
		@FindBy(id="cc_type")
		private WebElement txtCcType;
		
		@FindBy(id="cc_exp_month")
		private WebElement txtMonth;
		
		@FindBy(id="cc_exp_year")
		private WebElement txtYear;
		
		@FindBy(id="cc_cvv")
		private WebElement txtCvv;
		
		@FindBy(id="book_now")
		private WebElement txtBookNow;
		
		@FindBy(xpath="//td[text()='Booking Confirmation ']")
		private WebElement bookingConfirmationSuccessMsg;
		
		@FindBy(id="first_name_span")
		private WebElement txtFirstNameErrorMsg;
		
		@FindBy(id="last_name_span")
		private WebElement txtLastNameErrorMsg;
		
		@FindBy(id="address_span")
		private WebElement txtEnterAddressErrorMsg;
		
		@FindBy(id="cc_num_span")
		private WebElement txtCreditCardNumberErrorMsg;
		
		@FindBy(id="cc_type_span")
		private WebElement creditCardTypeErrorMsg;
		
		@FindBy(id="cc_expiry_span")
		private WebElement creditCardExpiryMonthErrorMsg;
		
		@FindBy(id="cc_cvv_span")
		private WebElement cvvNumberErrorMsg;
		
		
		public WebElement getBookingConfirmationSuccessMsg() {
			return bookingConfirmationSuccessMsg;
		}
		public WebElement getTxtFirstNameErrorMsg() {
			return txtFirstNameErrorMsg;
		}
		public WebElement getTxtLastNameErrorMsg() {
			return txtLastNameErrorMsg;
		}
		public WebElement getTxtEnterAddressErrorMsg() {
			return txtEnterAddressErrorMsg;
		}
		public WebElement getTxtCreditCardNumberErrorMsg() {
			return txtCreditCardNumberErrorMsg;
		}
		public WebElement getCreditCardTypeErrorMsg() {
			return creditCardTypeErrorMsg;
		}
		public WebElement getCreditCardExpiryMonthErrorMsg() {
			return creditCardExpiryMonthErrorMsg;
		}
		public WebElement getCvvNumberErrorMsg() {
			return cvvNumberErrorMsg;
		}
		public WebElement getTxtFirstNmae() {
			return txtFirstName;
		}
		public WebElement getTxtLastName() {
			return txtLastName;
		}
		public WebElement getTxtAddress() {
			return txtAddress;
		}
		public WebElement getTxtCcNum() {
			return txtCcNum;
		}
		public WebElement getTxtCcType() {
			return txtCcType;
		}
		public WebElement getTxtMonth() {
			return txtMonth;
		}
		public WebElement getTxtYear() {
			return txtYear;
		}
		public WebElement getTxtCvv() {
			return txtCvv;
		}
		public WebElement getTxtBookNow() {
			return txtBookNow;
		}
		/**
		 * @see used to perform the book hotel with valid fields
		 * @param firstName
		 * @param lastName
		 * @param address
		 * @param ccNum
		 * @param ccType
		 * @param month
		 * @param expYear
		 * @param cvv
		 */
		public void BookHotel1(String firstName,String lastName,String address,String ccNum,String ccType,String month,String expYear,String cvv) {
		elementsendkeys(getTxtFirstNmae(), firstName);
		elementsendkeys(getTxtLastName(), lastName);
		elementsendkeys(getTxtAddress(),address);
		elementsendkeys(getTxtCcNum(), ccNum);
		elementsendkeys(getTxtCcType(), ccType);
		elementsendkeys(getTxtMonth(), month);
		elementsendkeys(getTxtYear(), expYear);
		elementsendkeys(getTxtCvv(), cvv);
		elementclick(getTxtBookNow());
		
	}
		/**
		 * @see used to perform any fields booknow button
		 */
		public void BookHotel() {
		elementclick(txtBookNow);
		}	
			
			
		}


