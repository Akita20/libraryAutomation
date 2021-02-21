package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.BooksPage;
import com.libraryAutomation.pages.LoginPage;
import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class BooksTable_StepDefinitions {
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    BooksPage books = new BooksPage();

    @Given("the user on the homepage")
    public void the_user_on_the_homepage() {
        loginPage.loginAsStudent();
    }


    @Then("the user should see the following column names:")
    public void the_user_should_see_the_following_column_names(List<String> expectedheaderText) {
        List<String>actualHeaderText=BrowserUtils.convertWebElementToString_andGetText(books.header);
        Assert.assertEquals(expectedheaderText, actualHeaderText);
    }
}
