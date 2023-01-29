package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	public static Logger log = Logger.getLogger(TestBase.class);
	public static WebDriver driver;
	public static Properties prop;//global variable can be used inside all classes
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public TestBase() {//FOR GETTING CONFIG.PROPERTIES FILE
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\QA\\Selenium_Workplace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		// FOR GETTING BROWSER
		  log.info("****************************** Starting test cases execution  *****************************************");
		
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\QA\\Seleniumjars\\geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		else if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\QA\\Seleniumjars\\chromedriver.exe");
			 driver=new ChromeDriver();
		}else {
			driver=new EdgeDriver();
		}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));//login page url which is defined in config file
	    log.info("entering application URL");
				log.warn("Hey this just a warning message");
				log.fatal("hey this is just fatal error message");
				log.debug("this is debug message");
		 
	}

}
