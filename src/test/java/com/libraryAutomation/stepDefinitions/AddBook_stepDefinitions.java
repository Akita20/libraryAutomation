package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.BooksPage;
import com.libraryAutomation.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import java.util.Map;

public class AddBook_stepDefinitions {
    BooksPage booksPage = new BooksPage();


    @When("I click on books module")
    public void i_click_on_books_module() {
      booksPage.booksPageLink.click();
    }

    @When("I click on Add Book")
    public void i_click_on_add_book() {
        BrowserUtils.waitForClickability(booksPage.buttonAddBook,7);
        booksPage.buttonAddBook.click();

    }
    @When("A new window for Add Book should open")
    public void a_new_window_for_add_book_should_open() {
       BrowserUtils.waitForVisibility(booksPage.addBookWindow,10);
        Assert.assertTrue(booksPage.addBookWindow.isDisplayed());

    }

    @When("Enter Book Information")
    public void enter_book_information(Map<String,String> bookInfo) {
        booksPage.inputBookName.sendKeys(bookInfo.get("bookName"));
        booksPage.inputBookAuthor.sendKeys(bookInfo.get("author"));
        booksPage.inputBookISBN.sendKeys(bookInfo.get("ISBN"));
        booksPage.inputBookYear.sendKeys(bookInfo.get("year"));
        booksPage.inputBookDescription.sendKeys(bookInfo.get("description"));

        Select bookCategoryDropdown = new Select(booksPage.selectBookCategoriesAddBook);
        bookCategoryDropdown.selectByVisibleText(bookInfo.get("bookCategory"));
    }

    @When("I click Save changes button")
    public void i_click_save_changes_button() {
        booksPage.buttonBookSaveChanges.click();

    }

    @Then("User verifies {string} is in the list")
    public void user_verifies_is_in_the_list(String string) {

    }
}
