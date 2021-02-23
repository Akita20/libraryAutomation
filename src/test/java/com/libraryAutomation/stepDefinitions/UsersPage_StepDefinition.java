package com.libraryAutomation.stepDefinitions;

import com.github.javafaker.Faker;
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
        BrowserUtils.waitForVisibility(user.editUserInformationHeader, 15);
        Assert.assertTrue(user.editUserInformationHeader.isDisplayed());
    }


    @When("user clicks to add new user")
    public void user_clicks_to_add_new_user() {
        user.addUser.click();
    }


    @When("user enters valid info and clicks add user")
    public void user_enters_valid_info_and_clicks_add_user() {
        Faker faker = new Faker();
        BrowserUtils.waitForVisibility(user.inputFullName, 15);
        String name =BrowserUtils.sendTheKeys(user.inputFullName,faker.name().fullName());

        user.inputPassword.sendKeys(faker.file().fileName());
        user.inputEmail.sendKeys();

    }

    @Then("user will be able to see in user page the added user")
    public void user_will_be_able_to_see_in_user_page_the_added_user() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
