package com.libraryAutomation.pages;

import com.github.javafaker.Faker;
import com.libraryAutomation.utilities.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UsersPage extends PageBase {


    @FindBy(xpath = "//select[@name='tbl_users_length']")
    public WebElement showRecordsDropdown;

    @FindBy(xpath = "//a[@class='btn btn-lg btn-outline btn-primary btn-sm']")
    public WebElement addUser;

    @FindBy(id = "user_groups")
    public WebElement userGroup;


    @FindBy(xpath = "//input[@type='search']")
    public WebElement search;


    @FindBy(xpath = "//th[@class='sorting_disabled']")
    public WebElement action;

    @FindBy(xpath = "//th[@class='sorting_desc']")
    public WebElement userID;

    @FindBy(xpath = "//tr/td[3]")
    public WebElement fullName;

    @FindBy(xpath = "/thead/tr/th[4]")
    public WebElement emailInTable;

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
