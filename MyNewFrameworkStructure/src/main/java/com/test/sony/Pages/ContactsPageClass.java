package com.test.sony.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.sony.Base.TestBase;

public class ContactsPageClass extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//select[@name='title' and @class= 'select']")
	WebElement title;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@type='text' and @name = 'client_lookup']")
	WebElement companyname;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save' and @class='button']")
	WebElement submitbutton;
	
	public ContactsPageClass(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyConatctsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	public void creaenewContact(String tit, String fname, String lname,String cname){
		Select s1 = new Select(title);
		s1.selectByVisibleText(tit);
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		companyname.sendKeys(cname);
		submitbutton.click();
	}

}
