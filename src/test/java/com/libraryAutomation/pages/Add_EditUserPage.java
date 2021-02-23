package com.libraryAutomation.pages;

import com.github.javafaker.Faker;
import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.Memory;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Add_EditUserPage extends UsersPage {
    @FindBy(name = "full_name")
    public WebElement inputFullName;

    @FindBy(name = "password")
    public WebElement inputPassword;

    @FindBy(name = "email")
    public WebElement inputEmail;

    @FindBy(id = "user_group_id")
    public WebElement selectUserGroup;

    @FindBy(id = "status")
    public WebElement selectStatus;

    @FindBy(name = "start_date")
    public WebElement inputStartDate;

    @FindBy(name = "end_date")
    public WebElement inputEndDate;

    @FindBy(id = "address")
    public WebElement inputAdress;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonSaveChanges;
    @FindBy(xpath = "//button[@type='cancel']")
    public WebElement buttonCancel;

    @FindBy(xpath = "//form[contains(@id,'user_form')]")
    public WebElement addOrEditForm;


    Faker faker = new Faker();
    String name = faker.name().fullName();
    String password = faker.internet().password();
    String email = faker.internet().emailAddress();
    String startDate = faker.date().past(10, TimeUnit.DAYS).toString();
    String endDate = faker.date().future(40, TimeUnit.DAYS).toString();
    String address = faker.address().fullAddress();


    public void addUser() {
        Select select = new Select(selectUserGroup);
        Random rnd = new Random();
        inputFullName.sendKeys(name);
        inputPassword.sendKeys(password);
        inputEmail.sendKeys(email);
        select.selectByIndex(rnd.nextInt(1));
        select = new Select(selectStatus);
        select.selectByIndex(rnd.nextInt(1));
        inputStartDate.sendKeys(Keys.BACK_SPACE + startDate);
        inputEndDate.sendKeys(Keys.BACK_SPACE + endDate);
        inputAdress.sendKeys(address);
        buttonSaveChanges.click();
        Memory.saveValue("name", name);


    }


    public void buttonCancelClick() {
        buttonCancel.click();
        Assert.assertTrue("Couldnt cancel the add or edit user",BrowserUtils.waitForInVisibility(addOrEditForm, 15));
    }

    public void searchAddedUser() {
        search.sendKeys(Memory.retrieveValue("name") + Keys.ENTER);
        Assert.assertEquals("couldnt find the added user",Memory.retrieveValue("name"), fullName.getText());
        Memory.refresh();
    }


}
