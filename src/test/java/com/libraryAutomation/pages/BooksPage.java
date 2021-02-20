package com.libraryAutomation.pages;

import com.libraryAutomation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage extends PageBase {
    public BooksPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="book_categories")
    public WebElement selectBookCategories;

}
