package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.Add_EditUserPage;
import com.libraryAutomation.pages.LoginPage;
import com.libraryAutomation.pages.UsersPage;
import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.Memory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class UsersPage_StepDefinition {
    UsersPage user = new UsersPage();
    Add_EditUserPage add_editUserPage = new Add_EditUserPage();
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
        BrowserUtils.waitForVisibility(user.editUserInformationHeader, 15);
        Assert.assertTrue(user.editUserInformationHeader.isDisplayed());
    }


    @When("user clicks to add new user")
    public void user_clicks_to_add_new_user() {
        user.addUser.click();
    }


    @When("user enters valid info and clicks add user")
    public void user_enters_valid_info_and_clicks_add_user() {
        add_editUserPage.addUser();


    }

    @Then("user will be able to see in user page the added user")
    public void user_will_be_able_to_see_in_user_page_the_added_user() {
        BrowserUtils.sendTheKeys(user.search,Memory.retrieveValue("name"));
        Assert.assertEquals(Memory.retrieveValue("name"), BrowserUtils.waitForVisibility(user.fullName,15).getText());
        Memory.refresh();
    }
}
