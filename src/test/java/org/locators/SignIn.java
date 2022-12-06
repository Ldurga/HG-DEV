package org.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.BaseClass;

public class SignIn extends BaseClass {
	
		public SignIn() {
			PageFactory.initElements(driver, this);
		}
	
		@FindBy(xpath="//font[text()='Sign In']")
		private WebElement signInButton;
		
		@FindBy(xpath="//input[@id='uid']")
		private WebElement txtUsername;
		
		@FindBy(xpath="//input[@id='passw']")
		private WebElement txtPassword;
		
		@FindBy(xpath="//input[@value='Login']")
		private WebElement loginBtn;

		public WebElement getLoginBtn() {
			return loginBtn;
		}

		public WebElement getSignInButton() {
			return signInButton;
		}

		public WebElement getTxtUsername() {
			return txtUsername;
		}

		public WebElement getTxtPassword() {
			return txtPassword;
		}
		
		
		
		
		
		
		
}
