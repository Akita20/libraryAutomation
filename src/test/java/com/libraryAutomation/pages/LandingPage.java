package com.libraryAutomation.pages;

import com.libraryAutomation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage extends PageBase{

    @FindBy(xpath = "//a[@id='navbarDropdown']/span")
    public WebElement accountUserName;

    @FindBy(xpath = "//section[@id='dashboard']")
    public WebElement sectionDashboard;//used to verify that librarian land to dashboard


    @FindBy(id = "user_count")
    public WebElement userCount;

   ;

}
