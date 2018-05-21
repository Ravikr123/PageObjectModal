package com.test.sony.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.sony.Base.TestBase;
import com.test.sony.CommonUtil.TestUtil;
import com.test.sony.Pages.ContactsPageClass;
import com.test.sony.Pages.HomePageClass;
import com.test.sony.Pages.LoinPageClass;

public class TC003_ContactsPageClassTest  extends TestBase{
	
	public  LoinPageClass lpage;
	public  HomePageClass hpage;
	public ContactsPageClass cpage;
	public TestUtil tutil;
	
	public TC003_ContactsPageClassTest(){
		super();
	}
	
	@BeforeMethod
	public void setUP(){
		TestBase.initialisation();
		lpage= new LoinPageClass(driver);
		hpage= new HomePageClass(driver);
		cpage = new ContactsPageClass(driver);
		tutil = new TestUtil();
		hpage = lpage.login(prop.getProperty("uname"), prop.getProperty("pwd"));
		tutil.switchToFrame();
		cpage = hpage.clickonContactLink();
	}
	
	@Test
	public void verifyContactsLabelTest(){
		Assert.assertTrue(cpage.verifyConatctsLabel(), "Contacts Labe is missing");;
	}
	/*
	@DataProvider
	public void getTestData(){
		
	}
	
	@Test
	public void createnewContactTest(){
		hpage.cliclonNewContactsLink();
		cpage.creaenewContact(tit, fname, lname, cname);
	}
	*/
	
	@AfterMethod
	public void closeApp(){
		driver.close();
	} 

}
