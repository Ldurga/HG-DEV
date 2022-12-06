package org.locators;

import javax.xml.xpath.XPath;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.BaseClass;

public class FundTransfer extends BaseClass {
	
	public FundTransfer() {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//td[@class=\"cc br bb\"]//*[contains(text(),'F')]")
	private WebElement transferFund;

	@FindBy(xpath="//select[@name='toAccount']")
	private WebElement toAccount;
	
	@FindBy(id="transferAmount")
	private WebElement amountPass;
	
	@FindBy(id="transfer")
	private WebElement transferBtn;
	
	@FindBy(xpath="//span[contains(text(),'98')]")
	private WebElement succesfulMessage;
	
	@FindBy(xpath="(//td[contains(text(),'$9876.00')])[1]")
	private WebElement recentTransfer;
	

	public WebElement getRecentTransfer() {
		return recentTransfer;
	}

	public WebElement getSuccesfulMessage() {
		return succesfulMessage;
	}

	public WebElement getTransferBtn() {
		return transferBtn;
	}

	public WebElement getAmountPass() {
		return amountPass;
	}

	public void setAmountPass(WebElement amountPass) {
		this.amountPass = amountPass;
	}

	public WebElement getToAccount() {
		return toAccount;
	}

	public WebElement getTransferFund() {
		return transferFund;
	}
	
	
	
	
}
