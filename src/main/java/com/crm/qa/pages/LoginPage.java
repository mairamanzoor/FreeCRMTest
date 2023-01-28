package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{//for declaring testbase as parent class
	//PAGE FACTORY
	@FindBy (id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder1_txtUserIDLogin")
	WebElement username;
	
	@FindBy (id="ctl00_lblWelcome")
	WebElement welcomemsg;
	
	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder1_txtPasswordLogin")
	WebElement password; 
	
	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder1_imgLoginSubmit")
	WebElement LgnBtn;
	
	@FindBy (id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder1_lnkCreate")
	WebElement SignUp;
	
	 @FindBy(id="brandlogo")
	    WebElement Logo;
	 
	//initializing the page objects
    public  LoginPage() {
	PageFactory.initElements(driver,this);	
    }
    //ACTIONS
    public String ValidateLgnTitle() {
	return driver.getTitle();
    }
    public boolean ValidateLogoImg() {
	return Logo.isDisplayed();//used for validating image is displayed or not
    }
    public boolean ValidateWelcome() {
    	return welcomemsg.isDisplayed();//used for validating image is displayed or not
        }
    public HomePage login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		LgnBtn.click();
		
		return new HomePage(); //returning homepage here because its a landing page after login
    	
    }
}
