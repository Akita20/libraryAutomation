package com.libraryAutomation.pages;

import com.libraryAutomation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageLibrarian_DashboardPage extends PageBase{

    @FindBy(id = "user_count")
    public WebElement userCount;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public WebElement logOutButton;

    @FindBy(linkText = "Dashboard" )
    public WebElement dashboardPageLink;

    @FindBy(linkText = "Users")
    public WebElement usersPageLink;

}
