package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactPageTest extends TestBase {
	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	
	public ContactPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization(); //using browser condition from test base
	    lp=new LoginPage();	//making object of loginPage before executing testcASES 
	    cp=new ContactsPage();    
	    
	    hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));
	    hp.VerifyContactPage();//clicking on contact page
	}
	
	@Test
	public void ValidateContactPageText() {
		Assert.assertTrue(cp.ValidateContactPage());
	}
	@Test
	public void ValidateContactPageUrlTest() {
		String urlexpected="https://shopping.panasonic.ca/contact.aspx?lang=en";
		Assert.assertEquals(urlexpected,cp.VerifyContactpageURL());
	}
	@Test
	public void ValidateContactPageTitleTest() {
		Assert.assertEquals(cp.VerifyContactpageTitle(), "Contact us Contact Us - Panasonic Canada - Panasonic eStore");
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();	
	}
}
