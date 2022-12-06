package org.testfile;

import java.util.concurrent.TimeUnit;

import javax.security.auth.login.AccountNotFoundException;

import org.datacollector.AllTestData;
import org.locators.AccountHistory;
import org.locators.AccountSummary;
import org.locators.ContactDetails;
import org.locators.FundTransfer;
import org.locators.SignIn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.utilities.BaseClass;

public class TestAltoro extends BaseClass {

	public SignIn signIn;
	public AccountSummary account;
	public AccountHistory accountHistory;
	public FundTransfer transfer;
	public ContactDetails contactDetails;

	@BeforeClass
	private void browserLaunch() {
		launchChromeBrowser();
		windowMaximze();
		applyWaits();
		loadUrl("http://testfire.net/index.jsp");

	}

	@Test(dataProvider = "invalid", dataProviderClass = AllTestData.class, priority = 1)
	private void siginInvalidData(String username, String password) {
		applyWaits();
		signIn = new SignIn();
		elementClick(signIn.getSignInButton());
		enterText(signIn.getTxtUsername(), username);
		enterText(signIn.getTxtPassword(), password);
		elementClick(signIn.getLoginBtn());
	}

	@Test(dataProvider = "valid", dataProviderClass = AllTestData.class, priority = 2)
	private void siginValidData(String username, String password) {
		applyWaits();
		signIn = new SignIn();
		elementClick(signIn.getSignInButton());
		enterText(signIn.getTxtUsername(), username);
		verifyActualExpected(signIn.getTxtUsername(), username);
		enterText(signIn.getTxtPassword(), password);
		verifyActualExpected(signIn.getTxtPassword(), password);
		elementClick(signIn.getLoginBtn());

		account = new AccountSummary();
		account.getViewAccountSummary().click();

		selectValue(account.getViewAccountDetails(), "800001");
		elementClick(account.getGoBtn());

		accountHistory = new AccountHistory();

		verifyElementPresenceInPage(accountHistory.getAvailableBalance());

		transfer = new FundTransfer();
		elementClick(transfer.getTransferFund());

		selectValue(transfer.getToAccount(), "800001");

		enterText(transfer.getAmountPass(), "9876");

		elementClick(transfer.getTransferBtn());

		verifyElementPresenceInPage(transfer.getSuccesfulMessage());

		driver.findElement(By.xpath("//a[contains(text(),'View R')]")).click();

		verifyElementPresenceInPage(transfer.getRecentTransfer());
		contactDetails = new ContactDetails();

		elementClick(contactDetails.getContactUs());
		elementClick(contactDetails.getOnlineForm());

		enterText(contactDetails.getEmailId(), "abc@gmail.com");

		enterText(contactDetails.getSubject(), "Regrading Transfer");
		enterText(contactDetails.getMessage(), "How do I get Transfered receipt through my mail");

		elementClick(contactDetails.getSubmitButton());

		verifyElementPresenceInPage(contactDetails.getThankyouMessge());

		elementClick(contactDetails.getSignOffBtn());
		verifyElementPresenceInPage(contactDetails.getSignInBtn());

	}

}
