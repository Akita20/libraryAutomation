package com.libraryAutomation.pages;

import com.libraryAutomation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class PageBase extends PageGenerator {

    @FindBy(linkText = "Users")
    public WebElement usersPageLink;

    @FindBy(linkText = "Books" )
    public WebElement booksPageLink;


    @FindBy(linkText = "Dashboard" )
    public WebElement dashboardPageLink;

    @FindBy( xpath = "//a[@id='navbarDropdown']/span")
    public WebElement accountUserName;



}
