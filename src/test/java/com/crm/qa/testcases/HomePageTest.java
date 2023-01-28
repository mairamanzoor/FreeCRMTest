package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.StorePage;

public class HomePageTest extends TestBase {
	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	DealsPage dp;
	StorePage sp;
	
	public HomePageTest() {//current class constructor
		super();//it is used to call parent class constructor in testbase, we are using it to get config.prop file from test base
	}
	//test cases should be separated -- independent with each other
		//before each test case -- launch the browser and login
		//@test -- execute test case
		//after each test case -- close the browser
	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialization(); //using browser condition from test base
	    lp=new LoginPage();	//making object of loginPage before executing testcASES 
	    cp=new ContactsPage();
	    dp=new DealsPage();
	    sp=new StorePage();	    
	    
	    hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));
	    Thread.sleep(5000);
	}
	@Test(priority=1)
	public void VerifyTitlePageTest() throws InterruptedException {
		Thread.sleep(4000);
		String title=hp.VerifyHomaepageTitle();
		Assert.assertEquals(title,"Paanasonic eStore","HomePage Title Not Match");//Message will be printed only if only the assert is failed
	}
	@Test(priority=2)
	public void VerifyCorrectUserNameTest(){	
		Assert.assertTrue(hp.VerifyUsername());
	}
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		cp = hp.VerifyContactPage();
		
	}
	@Test(priority=4)
	public void verifyDealsLinkTest() {
		dp=hp.VerifyDealsList();
	}
	@Test(priority=5)
	public void verifyStoreLinkTest(){
		sp=hp.VerifyStorePage();
	
	}

	@AfterMethod
	public void TearDown() {
		
		driver.quit();	
	}
	
}
