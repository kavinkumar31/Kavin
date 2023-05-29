package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
	 * @see used tomaintaine cancel booking page locatore
	 * @author RAMKUMAR
	 * @date 16/feb/23
	 */
	public class CancelBookingPage extends BaseClass {
		public CancelBookingPage() {
			PageFactory.initElements(driver, this);
		}
			
	     @FindBy(xpath="//a[text()='Booked Itinerary']")
			private WebElement clickBookIt;
	    
	     @FindBy(id="order_id_text")
	     private WebElement btnSearchBox;
	     
	     @FindBy(id="search_hotel_id")
	     private WebElement btnGoClick;
	     
	     @FindBy(id="search_result_error")
	     private WebElement bookingCancelSuccessMsg;

	     
	     @FindBy(xpath="(//input[@type='checkbox'])[2]")
	     private WebElement rdoBtnClick;
	     
	     @FindBy(xpath="(//input[@type='button'])[1]")
	     private WebElement btnCancelClick;

	     @FindBy(name="cancelall")
	     private WebElement clickCancelAll;

	     
	  

	public WebElement getClickBookIt() {
			return clickBookIt;
		}
	public WebElement getBtnSearchBox() {
			return btnSearchBox;
		}
	public WebElement getBtnGoClick() {
			return btnGoClick;
		}
	public WebElement getBookingCancelSuccessMsg() {
			return bookingCancelSuccessMsg;
		}
	public WebElement getRdoBtnClick() {
			return rdoBtnClick;
		}
	public WebElement getBtnCancelClick() {
			return btnCancelClick;
		}
	public WebElement getClickCancelAll() {
			return clickCancelAll;
		}
	/**
		 * @see used tocancel booking order id
		 * @param OrderId
		 */
		public void cancelOrderId(String orderId) {
			implicityWait(20);
			elementclick(getClickBookIt());
			elementsendkeys(getBtnSearchBox(), orderId);
			elementclick(getBtnGoClick());
			elementclick(getRdoBtnClick());
			elementclick(getBtnCancelClick());
			clickAlertOk();
		}
	     

}
