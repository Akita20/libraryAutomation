
package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.libraryAutomation.pages.AddUserFormPage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class AddUserForm_StepDefinitions {

    AddUserFormPage usersPage = new AddUserFormPage();
    @And("Librarian add user")
    public void librarian_add_user() {
        usersPage.addUser();
    }

    @Then("User should be able to see new user name")
    public void userShouldBeAbleToSeeNewUserName() {
        BrowserUtils.sleep(3);
        Assert.assertTrue(usersPage.verifyNewUser());
    }

    @Then("User should be able to close the add user pop-up window")
    public void userShouldBeAbleToCloseTheAddUserPopUpWindow() {
        usersPage.close();
    }


    @Then("User should be able to edit user information")
    public void userShouldBeAbleToEditUserInformation() {
        BrowserUtils.sleep(3);
        usersPage.editUser();

    }


}
