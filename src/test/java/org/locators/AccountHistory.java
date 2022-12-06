package org.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.BaseClass;

public class AccountHistory extends BaseClass{
	
	public AccountHistory() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//td[@colspan='2']//tr/..//td[contains(text(),'va')]")
	private WebElement availableBalance;

	public WebElement getAvailableBalance() {
		return availableBalance;
	}
	
	
}
