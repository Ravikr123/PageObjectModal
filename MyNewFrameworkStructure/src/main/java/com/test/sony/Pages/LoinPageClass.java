package com.test.sony.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.sony.Base.TestBase;

public class LoinPageClass extends TestBase  {
	
	HomePageClass hpage;
	
	@FindBy(name="username")
	WebElement un;
	
	@FindBy(name="password")
	WebElement passwd;
	
	@FindBy(xpath="//input[@type='submit'][@value='Login']")
	WebElement loginbtn;
	
	@FindBy(xpath="//img[@class='img-responsive'][@src='https://d19rqa8v8yb76c.cloudfront.net/img/freecrm.jpg']")
	WebElement crmLogo;
	
	
	public LoinPageClass(WebDriver driver){
		//imitializing my page objects
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		String title = driver.getTitle();
		return title;
	}
	
	public boolean validateCRmImage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePageClass login(String user , String pass){
		un.sendKeys(user);
		passwd.sendKeys(pass);
		loginbtn.click();
		return new HomePageClass(driver);
	}

}
