package com.test.sony.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.test.sony.CommonUtil.WebEventListner;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;	//in TestBase we need to create obj of EventFiringWebDriver class and Event Listner
	public static WebEventListner eventlistener;
	
	public TestBase(){
		//initialize the property file
		try{
			prop = new Properties();
			//FileInputStream fip = new FileInputStream(System.getProperty("user-dir") +"/src/main/java/com/test/sony/Config/config.properties");
			FileInputStream fip = new FileInputStream("D:/eclipse workspace/MyNewFrameworkStructure/src/main/java/com/test/sony/Config/config.properties");
			prop.load(fip);
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static void initialisation(){
		String brwosername = prop.getProperty("browser");
		
		if(brwosername.equalsIgnoreCase("Chrome")){
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		//now create obj of EventListnerHandler to register it with EventFiringEvent
		eventlistener = new WebEventListner();
		e_driver.register(eventlistener);	//we need to register our eventListener class obj with EventFiringWebDriver obj
		driver = e_driver; 	//assign the EventListener driver to driver
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}
	
}
	
