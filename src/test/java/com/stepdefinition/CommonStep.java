package com.stepdefinition;

import io.cucumber.java.en.Then;

/**
	 * @author RAMKUMAR
	 * @see used to maintain common step snippets
	 * @date 16/feb/23
	 */
	public class CommonStep {
		//PageObjectManager pom=new PageObjectManager();

		
		/**
		 * @see used to verify after login success message
		 * @param string
		 */
		@Then("User should verify after login sucess message {string}")
		public void user_should_verify_after_login_sucess_message(String expLoginSuccessMsg) {
//			WebElement loginSuccessMsg = pom.getLoginPage().getTxtLoginUserNameSuccessMsg();
//		      String actLoginSuccessMsg = gettext(loginSuccessMsg);
//		      boolean a = actLoginSuccessMsg.contains(expLoginSuccessMsg);
//		    //  Assert.assertTrue("verify", a);
//		    //  Assert.assertEquals("verify", expLoginSuccessMsg, actLoginSuccessMsg);
//			Assert.assertEquals("verify", expLoginSuccessMsg, actLoginSuccessMsg);
		   	}
		


}
