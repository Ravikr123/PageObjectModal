package com.test.sony.CommonUtil;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.test.sony.Base.TestBase;

public class WebEventListner extends TestBase implements WebDriverEventListener {

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find element by" +by.toString());
		
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Naviating back to previous page");
		
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.print("Navigating Forward to next page ");
		
	}

	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String s, WebDriver driver) {
		System.out.print("Script executed" +s.toString());
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.print("Trying to click on" +element.toString()+ "");
		
	}
	
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.print("Clicked on" +element.toString()+ "");
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.print("trying to click element" +by);
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.print("Before Navigating back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.print("Before navigating forward to next page");
		
	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.print("Before navigating to"+url+ "");
		
	}
	
	public void aftereNavigateTo(String url, WebDriver driver) {
		System.out.print("Navigated to"+url+ "");
	}

	public void beforeScript(String s, WebDriver driver) {
		System.out.print("Prepairing to execute the script");
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured" +error);
		//if any excepion occured take the screenshot
		try{
			TestUtil.TakesScreenshotAtEndOfTest();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	public void afterNavigateTo(String s, WebDriver driver) {
		System.out.println("After navigating to" +s.toString());
		
	}
	
	

}
