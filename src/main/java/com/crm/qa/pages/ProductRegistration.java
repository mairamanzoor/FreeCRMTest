package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ProductRegistration extends TestBase {
	@FindBy(xpath="(//a[@class='contactButton'])[8]")
	WebElement prodregbutton;
	
	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder1_txtModelNumber")
	WebElement model;
	
	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder1_txtPurchaseDate")
	WebElement date;
	
	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder1_txtDealerName")
	WebElement dealer;
	
	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder1_imgSubmit")
	WebElement submitbtn;
	
	@FindBy(linkText ="Product Registration")
	WebElement registerbtn;
	//(//a[@class='reg-link'])[1]
	@FindBy(xpath="//a[contains(text(),'View/Edit')]")
	WebElement viewbtn;
	
	
	public ProductRegistration() {
		PageFactory.initElements(driver, this);
	}

	public void ClickOnRegisterButton() {
		prodregbutton.click();
	}
	public void RegisterProduct(String mdlnumber,String datevalue,String dealername) {
		model.sendKeys(mdlnumber);
		date.sendKeys(datevalue);
		dealer.sendKeys(dealername);
		submitbtn.click();
	}
	public void showRegisteredProductlist() {
		registerbtn.click();
		//viewbtn.click();
	}
	public String SelectMdlNumber(String mdlname) {
		return driver.findElement(By.xpath("//td[contains(text(),'"+mdlname+"')]")).getText();
		
	}
	public void ClickOnviewBtn() {
		viewbtn.click();
	}
	public String ShowSelectedproduct() {
		String value=model.getAttribute("value");//A10625+33...+.3		
		return value;
	}

	
}
