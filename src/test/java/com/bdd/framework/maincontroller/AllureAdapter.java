package com.bdd.framework.maincontroller;


import java.io.IOException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;




import com.bdd.framework.maincontroller.MainController;
import com.bdd.framework.utils.Screenshot;

import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.config.AllureModelUtils;
import ru.yandex.qatools.allure.events.*;

/**
 *
 */
public class AllureAdapter extends MainController {

    @Before
    public void callForEverTestCase() throws IOException {
    	beforeEveryMethod();
        
    }

    @After
    public void takeScreenshotIfFailed(Scenario scenario) throws IOException {
      
       if(scenario.getStatus().equals("failed"))
       {
        if(scenario.isFailed()) {
        	Screenshot.captureScreenShot(driver, scenario.getName());
            //TODO
        } 
    }
    }
}

