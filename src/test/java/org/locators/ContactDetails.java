package org.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.BaseClass;

public class ContactDetails extends BaseClass{
	public ContactDetails() {
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath="//a[contains(text(),'Contact Us')]")
	private WebElement contactUs;
	

	@FindBy(xpath="//a[contains(text(),'online form')]")
	private WebElement onlineForm;
	
	@FindBy(name="email_addr")
	private WebElement emailId;
	
	@FindBy(name="subject")
	private WebElement subject;
	
	@FindBy(xpath="//textarea[@align='top']")
	private WebElement message;
	
	@FindBy(name="submit")
	private WebElement submitButton;
	
	@FindBy(xpath="//h1[text()='Thank You']")
	private WebElement thankyouMessge;
	
	@FindBy(xpath="//font[contains(text(),'Sign Off')]")
	private WebElement signOffBtn;
	
	@FindBy(xpath="//font[contains(text(),'Sign')]")
	private WebElement signInBtn;
	
	public WebElement getSignInBtn() {
		return signInBtn;
	}



	public WebElement getSignOffBtn() {
		return signOffBtn;
	}



	public WebElement getThankyouMessge() {
		return thankyouMessge;
	}



	public WebElement getSubmitButton() {
		return submitButton;
	}



	public WebElement getMessage() {
		return message;
	}



	public WebElement getSubject() {
		return subject;
	}



	public WebElement getOnlineForm() {
		return onlineForm;
	}



	public WebElement getEmailId() {
		return emailId;
	}



	public WebElement getContactUs() {
		return contactUs;
	}
}




