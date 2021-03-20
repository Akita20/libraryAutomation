package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.LandingPageLibrarian_DashboardPage;
import com.libraryAutomation.pages.LoginPage;
import com.libraryAutomation.pages.UsersPageLibrarianDashboardPage;
import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.ConfigurationReader;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GroupCatogory_Definition extends UsersPageLibrarianDashboardPage {

   LoginPage loginPage= new LoginPage();
   UsersPageLibrarianDashboardPage usersPage= new UsersPageLibrarianDashboardPage();
   LandingPageLibrarian_DashboardPage landingPageLibrarianDashboardPage = new LandingPageLibrarian_DashboardPage();
   Select select;
   WebDriverWait wait= new WebDriverWait(Driver.getDriver(),5);

    @Given("the user  on the librarian homepage")
    public void theUserOnTheLibrarianHomepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
     loginPage.loginAsLibrary();
        BrowserUtils.waitForVisibility(landingPageLibrarianDashboardPage.dashboardPageLink,3);
    }


    @When("the user click users moudle")
    public void the_user_click_users_moudle() {

      landingPageLibrarianDashboardPage.usersPageLink.click();
    }
    @When("the user click User Group dropdown")
    public void the_user_click_user_group_dopdown() {
       // select= new Select(usersPage.userGroup);

    }

    @Then("the user should see the following options:")
    public void the_user_should_see_the_following_options(List<String> options) {

        //Basically we are comparing  list of strings and webElements
        //expected: List<String> expectedList
        //actual : BrowserUtils.getElementsText(monthDropdown.getOptions()) --> Returns List <String>
        select = new Select(usersPage.usersGroupDropdown);
        List<WebElement> webElements= select.getOptions();
        List<String> actualText= BrowserUtils.convertWebElementToString_andGetText(webElements);

        Assert.assertEquals(options,actualText);



    }



}
