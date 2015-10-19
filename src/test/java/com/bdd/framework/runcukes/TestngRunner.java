package com.bdd.framework.runcukes;
 
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
 
@CucumberOptions(features = "resources/Features",
        glue = {"com.bdd.framework.maincontroller","com.bdd.framework.stepdefinitions"},
        format={"pretty","html:target/html/"})

public class TestngRunner extends AbstractTestNGCucumberTests {
}