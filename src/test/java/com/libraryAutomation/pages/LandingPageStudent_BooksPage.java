package com.libraryAutomation.pages;

import com.libraryAutomation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPageStudent_BooksPage extends PageBase {
    public LandingPageStudent_BooksPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="book_categories")
    public WebElement selectBookCategories;

    @FindBy(xpath = "//thead/tr/th")
    public List<WebElement> header;

    @FindBy (xpath = "//th[@data-name='B.name']")
    public List<WebElement> listBookName;

    @FindBy(xpath = "//a[@href='tpl/add-book.html']")
    public WebElement buttonAddBook;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement inputBookName;

    @FindBy(xpath = "//input[@name='isbn']")
    public WebElement inputBookISBN;

    @FindBy(xpath = "//input[@name='year']")
    public WebElement inputBookYear;

    @FindBy(xpath = "//input[@name='author']")
    public WebElement inputBookAuthor;

    @FindBy(id = "description")
    public WebElement inputBookDescription;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement buttonBookSaveChanges;

    @FindBy (id = "book_group_id")
    public WebElement selectBookCategoriesAddBook;

    @FindBy (className = "modal-content")
    public WebElement addBookWindow;


    @FindBy(linkText = "Books" )
    public WebElement booksPageLink;



}
