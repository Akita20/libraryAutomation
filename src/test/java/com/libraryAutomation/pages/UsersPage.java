package com.libraryAutomation.pages;

import com.libraryAutomation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UsersPage extends PageBase {
    public UsersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//select[@name='tbl_users_length']")
    public WebElement showRecordsDropdown;

    @FindBy(xpath = "//a[@class='btn btn-lg btn-outline btn-primary btn-sm']")
    public WebElement addUser;

    @FindBy(id = "user_groups")
    public WebElement userGroup;


    @FindBy(id = "tbl_users_processing")
    public WebElement search;


    @FindBy(xpath = "//th[@class='sorting_disabled']")
    public WebElement action;

    @FindBy(xpath = "//th[@class='sorting_desc']")
    public WebElement userID;

    @FindBy(xpath = "//th[@class='sorting_asc']")
    public WebElement fullName;

    @FindBy(xpath = "/thead/tr/th[4]")
    public WebElement email;

    @FindBy(xpath = "/thead/tr/th[5]")
    public WebElement group;
    @FindBy(xpath = "thead/tr/th[6]")
    public WebElement status;


    @FindBy(xpath = "//thead/tr/th")
    public List<WebElement> tableHeaders;

    @FindBy(xpath = "//tbody/tr/td")
    public WebElement firstEditButton;

    @FindBy(xpath = "//h5[.='Edit User Information']")
    public WebElement editUserInformationHeader;


}
