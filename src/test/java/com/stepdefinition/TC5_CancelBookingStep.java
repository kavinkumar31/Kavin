package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC5_CancelBookingStep  extends BaseClass{
	
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see used to cancel the order id
	 */
	@When("User cancel the Order Id")
	public void user_cancel_the_order_id() {
		implicityWait(20);
		String orderId = pom.getBookingConfirmPage().getOrderId();
		pom.getCancelBookingPage().cancelOrderId(orderId);

	}

	/**
	 * @see used to verify after cancel order id success massage
	 * @param expBookingConfirmSuccesMsg
	 */
	@Then("User should verify after cancel Order Id success message {string}")
	public void user_should_verify_after_cancel_order_id_success_message(String expBookingConfirmSuccesMsg) {
		WebElement expCancelBookingSuccessMsg = pom.getCancelBookingPage().getBookingCancelSuccessMsg();
		String actCancelBookingSuccessMsg = gettext(expCancelBookingSuccessMsg);
		boolean b = actCancelBookingSuccessMsg.contains(expBookingConfirmSuccesMsg);
		// Assert.assertEquals("verify", expBookingConfirmSuccesMsg,
		// actCancelBookingSuccessMg);
		Assert.assertTrue("verify", b);
	}

	/**
	 * @see used to cancel the existing order id
	 * @param orderId
	 */
	@When("User cancel the existing {string}")
	public void user_cancel_the_existing(String OrderId) {
		pom.getCancelBookingPage().cancelOrderId(OrderId);

	}

}


