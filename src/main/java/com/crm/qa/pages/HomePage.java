package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Welcome maira')]")
	@CacheLookup
	WebElement username;
	
	@FindBy(linkText="On Sale Items")
	WebElement dealslink;
	
	@FindBy(id = "ctl00_lnkGlobalContactUs")
	WebElement contactlink;
	
	@FindBy(id = "open1")
	WebElement productlink;
	
	//initializing the page objects
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	//ACTIONS
	public String VerifyHomaepageTitle() {
		return driver.getTitle();
	}
	public boolean VerifyUsername() {	
		return username.isDisplayed();
	}
	public DealsPage VerifyDealsList() {
		dealslink.click();
		return new DealsPage();
	}
	public ContactsPage VerifyContactPage() {
		contactlink.click();
		return new ContactsPage();
	}
	public StorePage VerifyStorePage() {
		productlink.click();
		return new StorePage();
	}
	

}
