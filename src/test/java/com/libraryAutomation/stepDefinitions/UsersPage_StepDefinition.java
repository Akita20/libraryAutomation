package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.LoginPage;
import com.libraryAutomation.pages.UsersPage;
import com.libraryAutomation.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UsersPage_StepDefinition {
    UsersPage user = new UsersPage();
    LoginPage loginPage = new LoginPage();

    @Given("the librarian  is on users page")
    public void the_librarian_is_on_users_page() {
        loginPage.loginAsLibrary();
        user.navigatingThroughNavigationBar("users");

    }


    @When("the librarian clicks on edit user page")
    public void the_librarian_clicks_on_edit_user_page() {
        user.firstEditButton.click();
    }

    @Then("librarian can see edit page")
    public void librarian_can_see_edit_page() {
        BrowserUtils.waitForVisibility(user.editUserInformationHeader,15);
        Assert.assertTrue(user.editUserInformationHeader.isDisplayed());
    }
}
