package com.pages;

import java.awt.AWTException;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
	 * @see used to maintain the loginpage locatore
	 * @author RAMKUMAR
	 *@date 16/feb/23
	 */
	public class LoginPage extends BaseClass {
	    public LoginPage() {
	    	
	    	PageFactory.initElements(driver, this);
		}
	    @ FindBy(id="username")
		private WebElement txtUserName;
		
		@ FindBy(id="password")
		private WebElement txtPassworad;
		
		@ FindBy(id="login")
		private WebElement btnLogin;
		
		@FindBy(id="username_show")
		private WebElement txtLoginUserNameSuccessMsg;
		
		@FindBy(xpath="//b[text()='Invalid Login details or Your Password might have expired. ']")
		private WebElement txtErrorLogin;

			public WebElement getTxtUserName() {
			return txtUserName;
		}
		public WebElement getTxtPassworad() {
			return txtPassworad;
		}
		public WebElement getBtnLogin() {
			return btnLogin;
		}
		public WebElement getTxtLoginUserNameSuccessMsg() {
			return txtLoginUserNameSuccessMsg;
		}
		public WebElement getTxtErrorLogin() {
			return txtErrorLogin;
		}
			/**
		 * @see used to code for login valid and invalied credentials
		 * @param username
		 * @param Password
		 */
		
		public void login(String userName,String password) {
			
			elementsendkeys(getTxtUserName(), userName);
			elementsendkeys(getTxtPassworad(), password);
			elementclick(getBtnLogin());
			
		}
		/**
		 * @see used to with enterkey
		 * @param username
		 * @param Password
		 * @throws AWTException
		 */
		public void loginWithEnter(String userName,String password) throws AWTException {
			elementsendkeys(getTxtUserName(), userName);
			elementsendkeys(getTxtPassworad(), password);
			keyPress(KeyEvent.VK_TAB);
			keyRelease(KeyEvent.VK_TAB);
			keyPress(KeyEvent.VK_TAB);
			keyRelease(KeyEvent.VK_TAB);
			keyPress(KeyEvent.VK_ENTER);
			keyRelease(KeyEvent.VK_ENTER);
			
		}
		
		
		}

