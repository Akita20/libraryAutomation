package com.libraryAutomation.pages;

import com.libraryAutomation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends PageBase{

    public LandingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user_count")
    public WebElement userCount;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public WebElement logOutButton;

    @FindBy(xpath = "//a[@id='navbarDropdown']/span")
    public WebElement userIDName;


    @FindBy(xpath = "//*[@id='navbarDropdown']")
    public WebElement logoutDropdown;

}
