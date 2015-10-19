package com.bdd.framework.stepdefinitions;

import java.io.IOException;

import com.bdd.framework.maincontroller.MainController;
import com.bdd.framework.pageobjects.googleHomePageObjects;
import com.bdd.framework.utils.SearchData;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

 
public class StepDefinitions extends MainController {

	googleHomePageObjects gpo = new googleHomePageObjects(driver);
 
	
    @Given("^I am on the Selenium homepage$")
    public void I_am_on_the_Selenium_homepage() throws IOException, InterruptedException {
      gpo.searchForTextAndClick();
    }
 
    @When("^I click Download tab$")
    public void downloadtab() throws IOException{
    	System.out.println("download");
    }
   
 
    @Then("^I should see Java download link on Download page$")
    public void javaPage() throws IOException{
    	System.out.println("java");
    }
    
}