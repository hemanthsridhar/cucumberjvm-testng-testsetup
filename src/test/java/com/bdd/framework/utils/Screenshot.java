package com.bdd.framework.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.bdd.framework.maincontroller.MainController;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
/*
 * @author Hemanth.Sridhar
 */
public class Screenshot extends MainController {
	final static String sourcefile = "C:/Users/USER/workspace/Hemanth_Framework/resources/screenshot"
	 		+ "screenshot.jpg";
public static void captureScreenShot(WebDriver driver, String screenshotName){
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(src, new File("./Screenshots/"+screenshotName+".png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
