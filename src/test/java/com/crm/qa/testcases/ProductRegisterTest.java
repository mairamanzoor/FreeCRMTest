package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ProductRegistration;
import com.crm.qa.util.TestUtil;

public class ProductRegisterTest extends TestBase {
	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	ProductRegistration pr;
	TestUtil tu;
	
	String sheetName = "Productdata"; //sheetname from excel file
	
	public ProductRegisterTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		initialization();
		
		lp=new LoginPage();
		hp=new HomePage();
		cp=new ContactsPage();
		pr=new ProductRegistration();
		tu=new TestUtil();
		
		
		
		hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));
		hp.VerifyContactPage();
		pr.ClickOnRegisterButton();
		lp.login(prop.getProperty("username"),prop.getProperty("password"));	
	}

	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = tu.getTestData(sheetName);
		return data;
	}
	@Test(priority=1,dataProvider="getTestData")
	public void RegisterProductTest(String modelnumber, String purchasedate, String dealername) {
		pr.RegisterProduct(modelnumber, purchasedate, dealername);//getting values from excel sheet by dataprovider
	}
	@Test(priority=2)
	public void VerifyRegisteredProduct() {
		pr.showRegisteredProductlist();
		Assert.assertEquals(pr.SelectMdlNumber("A10625"), "A10625");
		pr.ClickOnviewBtn();
		pr.ShowSelectedproduct();
		Assert.assertEquals(pr.ShowSelectedproduct(),"A10625");
	}
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}

}
