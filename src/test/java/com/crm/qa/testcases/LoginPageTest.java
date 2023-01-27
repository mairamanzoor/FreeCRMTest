package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage lp;
	HomePage hp;
	
	public LoginPageTest() {//current class constructor
		super();//it is used to call parent class constructor, we are using it to get config.prop file from test base
	}
	@BeforeMethod
	public void SetUp() {
		initialization(); //using browser condition from test base for driver
	    lp=new LoginPage();	//making object of loginPage before executing testcASES
	    hp=new HomePage();
	}
	@Test(priority=1)
	public void LgnPageTitleTest() {
		String title=lp.ValidateLgnTitle();
		Assert.assertEquals(title,"Loogin - Panasonic eStore");	
	}
	@Test(priority=2)
	public void LgnPagelogoTest() {
	boolean logo=	lp.ValidateLogoImg();
	Assert.assertTrue(logo);
	}
	@Test(priority=3)
	public  void LoginTest() throws InterruptedException {
		hp= lp.login(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(5000);	
		Assert.assertTrue(lp.ValidateWelcome());
		System.out.println("Test Pass");
	}

	@AfterMethod
	public void TearDown() throws InterruptedException {
		
		driver.quit();	
	}

}
