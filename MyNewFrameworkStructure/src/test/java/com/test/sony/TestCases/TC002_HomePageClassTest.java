package com.test.sony.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.sony.Base.TestBase;
import com.test.sony.CommonUtil.TestUtil;
import com.test.sony.Pages.ContactsPageClass;
import com.test.sony.Pages.HomePageClass;
import com.test.sony.Pages.LoinPageClass;

public class TC002_HomePageClassTest extends TestBase {
	
	public  LoinPageClass lpage;
	public  HomePageClass hpage;
	public TestUtil tutil;
	ContactsPageClass cpage;
	
	public TC002_HomePageClassTest(){
		super();
	}
	
	@BeforeMethod
	public  void setUP(){
		TestBase.initialisation();
		lpage = new LoinPageClass(driver);  //initializing login page class
		hpage = new HomePageClass(driver);  //initializing homepage class
		tutil = new TestUtil();            //initializing TUTil class
		cpage = new ContactsPageClass(driver);
		hpage = lpage.login(prop.getProperty("uname"), prop.getProperty("pwd"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String mytitle = hpage.verifyHomePagetitle();
		Assert.assertEquals(mytitle, "CRMPRO", "Page title is not correct");
	}
	
	@Test(priority=2)
	public void verifyhomePageUserTest(){
		tutil.switchToFrame();
		String username = hpage.verifyhomePageUser();
		Assert.assertEquals(username, "Naveen K", "Invalid username");
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		tutil = new TestUtil();
		tutil.switchToFrame();
		cpage = hpage.clickonContactLink();
	}
	
	
	@AfterMethod
	public void closeApp(){
		driver.close();
	}
	
	

}
