package com.bdd.framework.pageobjects;
import java.io.IOException;
import com.bdd.framework.utils.ExcelLibrary;
import com.bdd.framework.utils.SearchData;
import com.bdd.framework.utils.Waiting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * @author Hemanth.Sridhar
 */
public class googleHomePageObjects{
	
   SearchData data = new SearchData();
   
	public googleHomePageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="q")
	private WebElement searchbox;
	@FindBy(name="btnG")
	private WebElement btnClick;
	
	public void searchForTextAndClick() throws IOException, InterruptedException{
		ExcelLibrary excel = new ExcelLibrary("resources/Test Data/test2.xls");
		searchbox.sendKeys(excel.xlsReadCell("SearchingTerms", 2));
		Waiting.explicitWaitElementToBeClickable(btnClick, 10);
		btnClick.isEnabled();
	}
}
