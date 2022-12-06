package org.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.BaseClass;

public class AccountSummary extends BaseClass {
	
	public AccountSummary() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[text()='I WANT TO ...']/..//a[@id='MenuHyperLink1']")
	private WebElement viewAccountSummary;
			
	@FindBy(xpath="//table[@border='0']//child::select")
	private WebElement viewAccountDetails;
	
	@FindBy(xpath="//input[@value='   GO   ']")
	private WebElement goBtn;

	public WebElement getViewAccountSummary() {
		return viewAccountSummary;
	}

	public WebElement getViewAccountDetails() {
		return viewAccountDetails;
	}

	public WebElement getGoBtn() {
		return goBtn;
	}

	
	
	

}
