package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.LandingPageStudent_BooksPage;
import com.libraryAutomation.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import java.util.Map;

public class AddBook_stepDefinitions {
    LandingPageStudent_BooksPage landingPageStudentBooksPage = new LandingPageStudent_BooksPage();


    @When("I click on books module")
    public void i_click_on_books_module() {
      landingPageStudentBooksPage.booksPageLink.click();
    }

    @When("I click on Add Book")
    public void i_click_on_add_book() {
        BrowserUtils.waitForClickability(landingPageStudentBooksPage.buttonAddBook,7);
        landingPageStudentBooksPage.buttonAddBook.click();

    }
    @When("A new window for Add Book should open")
    public void a_new_window_for_add_book_should_open() {
       BrowserUtils.waitForVisibility(landingPageStudentBooksPage.addBookWindow,10);
        Assert.assertTrue(landingPageStudentBooksPage.addBookWindow.isDisplayed());

    }

    @When("Enter Book Information")
    public void enter_book_information(Map<String,String> bookInfo) {
        landingPageStudentBooksPage.inputBookName.sendKeys(bookInfo.get("bookName"));
        landingPageStudentBooksPage.inputBookAuthor.sendKeys(bookInfo.get("author"));
        landingPageStudentBooksPage.inputBookISBN.sendKeys(bookInfo.get("ISBN"));
        landingPageStudentBooksPage.inputBookYear.sendKeys(bookInfo.get("year"));
        landingPageStudentBooksPage.inputBookDescription.sendKeys(bookInfo.get("description"));

        Select bookCategoryDropdown = new Select(landingPageStudentBooksPage.selectBookCategoriesAddBook);
        bookCategoryDropdown.selectByVisibleText(bookInfo.get("bookCategory"));
    }

    @When("I click Save changes button")
    public void i_click_save_changes_button() {
        landingPageStudentBooksPage.buttonBookSaveChanges.click();

    }

    @Then("User verifies {string} is in the list")
    public void user_verifies_is_in_the_list(String string) {

    }
}
