package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks {

    @After
    public void tearDown(){
      Driver.closeDriver();
    }



}
