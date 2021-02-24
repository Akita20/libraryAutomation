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
        BrowserUtils.sleep(3);
        String name = BrowserUtils.sendTheKeys(BrowserUtils.fluentWait(user.search, 20), Memory.retrieveValue("name"));
        Assert.assertEquals("The name does not match the editing wasn't successful",name, BrowserUtils.waitUntilCertainTextAppears(user.fullName,Memory.retrieveValue("name")).getText());

    }

    @Then("user clicks to cancel, the form is cancelled")
    public void userClicksToCancelTheFormIsCancelled() {
        add_editUserPage.buttonCancelClick();
    }

    @When("user clicks to edit button for desired {string}")
    public void userClicksToEditButtonForDesired(String name) {
        user.selectUserToEdit(name);
    }

    @When("user clicks to edit button randomly from the list")
    public void userClicksToEditButtonRandomlyFromTheList() {
        user.selectingRandomEdit();
    }
}
