package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.LandingPageStudent_BooksPage;
import com.libraryAutomation.pages.LoginPage;
import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BookCategory_StepDefinitions {

    LandingPageStudent_BooksPage booksPage = new LandingPageStudent_BooksPage();
    @Given("User logs in as Student")
    public void user_logs_in_as_student() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStudent();
    }

    @Then("Student should see below info in book categories dropdown")
    public void student_should_see_below_info_in_book_categories_dropdown(List<String> expectedCategories) {
        List<String> actualCategories = booksPage.getAllBookCategories();
        Assert.assertEquals(expectedCategories, actualCategories);
    }

    @Then("Student selects {string} from category dropdown")
    public void student_selects_from_category_dropdown(String category) {
        booksPage.selectCategory(category);
    }

    @Then("Student should see all the books from that category")
    public void student_should_see_all_the_books_from_that_category() {
        String actual = booksPage.getSelectedCategory();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.textToBePresentInElement(booksPage.listOfSelectedCategories.get(booksPage.listOfSelectedCategories.size()-1),actual));
        for (WebElement each : booksPage.listOfSelectedCategories) {
            Assert.assertEquals(each.getText(), actual);
        }
    }

}
