package com.libraryAutomation.pages;

import com.libraryAutomation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class PageBase extends PageGenerator {


    @FindBy(xpath = "//a[@id='navbarDropdown']/span")
    public WebElement avatarUserName;

    @FindBy(xpath = "//a[@class='nav-link']/span[1]")
    public List<WebElement> navigationBar;//this does not include the avatar

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public WebElement buttonLogOut;


    public void navigatingThroughNavigationBar(String text) {//type which module you want to click ass a parameter it will click
        for (WebElement element : navigationBar) {
            if (element.getText().equalsIgnoreCase(text)) {
                element.click();
            }
        }
    }

    public void logOut() {
        avatarUserName.click();
        buttonLogOut.click();
    }




}
