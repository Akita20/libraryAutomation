package com.libraryAutomation.pages;

import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BooksPage extends PageBase {
    public BooksPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "book_categories")
    public WebElement selectBookCategories;

    @FindBy(xpath = "//table//tr//td[5]")
    public List<WebElement> listOfSelectedCategories;

    @FindBy(name= "tbl_books_length")
    public WebElement showRecords;

    public List<String> getAllBookCategories() {
        List<String> categoriesText = new ArrayList<>();
        Select select = new Select(selectBookCategories);
        select.getOptions().forEach(p -> categoriesText.add(p.getText()));
        BrowserUtils.sleep(3);
        return categoriesText;
    }

    public void selectCategory(String string) {
        Select select = new Select(selectBookCategories);
        select.selectByVisibleText(string);
        BrowserUtils.sleep(3);
    }


//    public String getCategoryText() {
//        String category = "";
//        List<String> categories = new ArrayList<>();
//        // WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
//        // wait.until(ExpectedConditions.visibilityOfAllElements(listOfSelectedCategories));
//        //listOfSelectedCategories.forEach(p -> categories.add(p.getText()));
////        int j=0;
////        for (WebElement element : listOfSelectedCategories) {
////           String text =BrowserUtils.clickOn((//table//tr//td[5])[j++],30);
////           categories.add(text);
////        }
////        for (int i = 0; i < categories.size(); i++) {
////            if (categories.get(0).equals(categories.get(i)))
////                category = categories.get(0);
////        }
////        return category;
////    }
//
////    public String getCategory(String categoryName){
////
////    }
//
//    }
}

