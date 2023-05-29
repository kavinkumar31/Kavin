package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.manager.PageObjectManager;

/**
	 * @see used to maintaine booking confirm page locatore
	 * @author RAMKUMAR @date16/feb/23
	 */
	public class BookingConfirmPage extends BaseClass {

		PageObjectManager pom = new PageObjectManager();

		public BookingConfirmPage() {
			PageFactory.initElements(driver, this);
		}

		@FindBy(id = "order_no")
		private WebElement orderNum;

		public WebElement getOrderNo() {
			return orderNum;
		}

		/**
		 * @see used to get order id
		 * @return
		 */
		public String getOrderId() {
			implicityWait(20);
			String orderId = getattributevalue(getOrderNo(), "value");
			return orderId;

		}

	}

