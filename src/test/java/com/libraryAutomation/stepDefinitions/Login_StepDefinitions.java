package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.LoginPage;
import com.libraryAutomation.utilities.ConfigurationReader;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAsLibrary();

    }
    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {

    }

    @Given("I login as a student")
    public void i_login_as_a_student() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAsStudent();

    }


    @When("I enter username {string}")
    public void i_enter_username(String string) {
      loginPage.usernameInput.sendKeys(string);
    }
    @When("I enter password {string}")
    public void i_enter_password(String string) {
        loginPage.passwordInput.sendKeys(string);
    }
    @When("I click the sign in button")
    public void i_click_the_sign_in_button() {
        loginPage.signInButton.click();

    }



}
