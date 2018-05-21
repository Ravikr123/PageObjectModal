package com.test.sony.Pages;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.sony.Base.TestBase;

public class HomePageClass extends TestBase {
	
	ContactsPageClass cpage;
	
	@FindBy(xpath="//td[contains(text(), 'Naveen K')]")
	WebElement userLabel;
	
	@FindBy(xpath="//ul[contains(@class, 'mlddm')]/li[4]/a[1]")
	WebElement contactslink;
	
	@FindBy(xpath="//ul[contains(@class, 'mlddm')]/li[4]/ul[1]/li[1]/a[1]")
	WebElement newContactlink;
	
	@FindBy(xpath="//a[contains(@title, 'Deals')]")
	WebElement Deallink;
	
	public HomePageClass(WebDriver driver){
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePagetitle(){
		String title = driver.getTitle();
		return title;
	}
	
	public String verifyhomePageUser(){
		String label = userLabel.getText();
		return label;
	}
	
	public ContactsPageClass clickonContactLink(){
		contactslink.click();
		return new ContactsPageClass(driver);
	}
	
	public void cliclonNewContactsLink(){
		Actions act = new Actions(driver) ;
		act.moveToElement(contactslink).build().perform();
		act.moveToElement(newContactlink).click().build().perform();
	}

}
