package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	@FindBy(xpath="//h1[contains(text(),'Contact us')]")
	WebElement verifyContacttext;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean ValidateContactPage() {
		return verifyContacttext.isDisplayed();
	}
	public String VerifyContactpageTitle() {
		return driver.getTitle();
	}
	public String VerifyContactpageURL() {
		return driver.getCurrentUrl();
	}
	
	
}
