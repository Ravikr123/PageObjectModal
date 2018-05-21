package com.test.sony.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.sony.Base.TestBase;
import com.test.sony.Pages.HomePageClass;
import com.test.sony.Pages.LoinPageClass;

public class TC001_LoginPageClassTest extends TestBase {
	
	public static LoinPageClass lpage;
	HomePageClass hpage;
	
	public TC001_LoginPageClassTest(){
		super();	//we need to call super class constructor using super keyword bcz we need to initialize propery file
					// else it will give null pointer exception
	}
	
	@BeforeMethod
	public static void setUP(){
		TestBase.initialisation();
		lpage = new LoinPageClass(driver);
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		//lpage = new LoinPageClass(driver);
		String title = lpage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test(priority=2)
	public void crmLogoImagetest(){
		//lpage = new LoinPageClass(driver);
		boolean flag = lpage.validateCRmImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest(){
		//lpage = new LoinPageClass(driver);
		hpage = lpage.login(prop.getProperty("uname"), prop.getProperty("pwd"));
		
	}
	
	@AfterMethod
	public void closeApp(){
		driver.close();
	}

}
