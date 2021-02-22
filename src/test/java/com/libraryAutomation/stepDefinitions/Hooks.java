package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.utilities.ConfigurationReader;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @After
    public void tearDown(){
        Driver.closeDriver();
    }
@Before
    public  void setUpScenario(){

    String url= ConfigurationReader.getProperty("url");
    Driver.getDriver().get(url);
}
//
}
