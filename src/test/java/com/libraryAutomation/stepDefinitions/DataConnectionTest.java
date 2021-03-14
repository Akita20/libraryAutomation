package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.LandingPageLibrarian_DashboardPage;
import com.libraryAutomation.pages.LoginPage;
import com.libraryAutomation.pages.UsersPageLibrarianDashboardPage;
import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.ConfigurationReader;
import com.libraryAutomation.utilities.Driver;
import com.libraryAutomation.utilities.dB_utility.DataBase_Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.libraryAutomation.pages.LandingPageLibrarian_DashboardPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;

public class DataConnectionTest {
    LandingPageLibrarian_DashboardPage landingPage=new LandingPageLibrarian_DashboardPage();
    @Then("I verify by calling data")
    public void i_verify_by_calling_data() {
        String url      = ConfigurationReader.getProperty("library1.database.url");
        String username = ConfigurationReader.getProperty("library1.database.username");
        String password = ConfigurationReader.getProperty("library1.database.password");

        DataBase_Utility.createConnection(url, username, password);
        DataBase_Utility.runQuery("SELECT count(*) FROM books")  ;

        String userCountDB_Str =  DataBase_Utility.getFirstRowFirstColumn();
        System.out.println(userCountDB_Str);

        String userCountText=landingPage.userCount.getText();
        assertEquals(userCountDB_Str, userCountText);

    }








}
