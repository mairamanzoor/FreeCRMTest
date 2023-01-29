package com.crm.qa.testcases;

import org.apache.log4j.Logger;
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
	Logger log = Logger.getLogger(LoginPageTest.class);
	//What is log? : capturing info/activities at the time of program execution. 
		// types of logs:
			//1. info
			//2. warn
			//3. debug
			//4. fatal
			
		//how to generate the logs? : use Apache log4j API (log4j jar)
		//How it works? : it reads log 4j configuration from log4j.properties file
		//where to create: create inside resources folder
	
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
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** LgnPageTitleTest *****************************************");
		String title=lp.ValidateLgnTitle();
		Assert.assertEquals(title,"Login - Panasonic eStore");	
	}
	@Test(priority=2)
	public void LgnPagelogoTest() {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** LgnPagelogoTest *****************************************");
	boolean logo=	lp.ValidateLogoImg();
	Assert.assertTrue(logo);
	log.info("****************************** ending test case *****************************************");
	log.info("****************************** LgnPagelogoTest *****************************************");
	}
	@Test(priority=3)
	public  void LoginTest() throws InterruptedException {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** LoginTest *****************************************");
		hp= lp.login(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(5000);	
		Assert.assertTrue(lp.ValidateWelcome());
		System.out.println("Test Pass");
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** LoginTest *****************************************");
	}

	@AfterMethod
	public void TearDown() throws InterruptedException {
		
		driver.quit();	
		log.info("****************************** Browser is closed *****************************************");
	}

}
