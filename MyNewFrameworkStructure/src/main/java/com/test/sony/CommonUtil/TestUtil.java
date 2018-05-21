package com.test.sony.CommonUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.test.sony.Base.TestBase;

public class TestUtil extends TestBase{
	/*
	public static String Test_Data_Path = "D://eclipse workspace//MyNewFrameworkStructure//src//main//java//com//test//sony//TestDataExcelSheet//MyProject_Testdata.xlsx";
	public static Workbook wbook;
	public static Sheet sh;
	*/
	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	/*
	public static Object[][] getTestData(String sheetname){
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(Test_Data_Path);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try{
			wbook = WorkbookFactory.create(fis);
		}catch(InvalidFormatException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		sh = (Sheet) wbook.getSheet(sheetname);
		Object[][] data = new Object[sh.
	}
	*/
	
	public static void TakesScreenshotAtEndOfTest() throws IOException{
		File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentdir = System.getProperty("user-dir");
		FileUtils.copyFile(scrfile, new File(currentdir + "/ScreenShot/" + System.currentTimeMillis() +".png"));
	}

}
