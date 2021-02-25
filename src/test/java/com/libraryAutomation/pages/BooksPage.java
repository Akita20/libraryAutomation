package com.libraryAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class BooksPage extends PageBase {

    @FindBy(id="book_categories")
    public WebElement selectBookCategories;

    @FindBy(xpath = "//thead/tr/th")
    public List<WebElement> header;

    @FindBy(xpath = "//section[@id='dashboard']")
    public WebElement sectionDashboard;//used to verify that librarian land to dashboard


    @FindBy(xpath = "//section[@id='books']")
    public WebElement sectionBooks;//used to verify that student land on books page

    @FindBy(name = "tbl_books_length")
    public WebElement selectRecords;
}
