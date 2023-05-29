package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
	 * @see used to maintenice select hotel page locatore 
	 * @author RAMKUMAR
	 * @date 16/feb/23
	 */
	public class SelectHotelPage extends BaseClass {
		public SelectHotelPage() {
			PageFactory.initElements(driver, this);
			}
		@FindBy(id="radiobutton_0")
		private WebElement rdoButton;
		
		@FindBy(id="continue")
		private WebElement btnContinue;
		
		@FindBy(xpath="//td[text()='Book A Hotel ']")
		private WebElement bookAHotelSuccessMsg;
		
		@FindBy(xpath="//label[text()='Please Select a Hotel']")
		private WebElement pleaseSelectAHotelErrorMsg;

		public WebElement getBookAHotelSuccessMsg() {
			return bookAHotelSuccessMsg;
		}

		public WebElement getPleaseSelectAHotelErrorMsg() {
			return pleaseSelectAHotelErrorMsg;
		}

		public WebElement getRdoButton() {
			return rdoButton;
		}

		public WebElement getRdoContinue() {
			return btnContinue;
		}
		/**
		 *@see used to continue with select name 
		 */
		public void selectHotelName() {
			elementclick(getRdoButton());
			elementclick(getRdoContinue());

		
		}

		/**
		 * @see used to continue without continue button
		 */
		public void clickContinue() {
			
		elementclick(getRdoContinue());

			
		}
		
		
		
			
}
