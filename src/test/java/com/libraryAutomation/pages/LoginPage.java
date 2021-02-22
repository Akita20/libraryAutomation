package com.libraryAutomation.pages;

import com.libraryAutomation.utilities.ConfigurationReader;
import com.libraryAutomation.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver =Driver.getDriver();
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "login-form")
    public WebElement loginPage;
    @FindBy(xpath = "//input[@id='inputEmail']")
    public WebElement usernameInput;
    @FindBy(xpath = "//input[@id='inputPassword']")
    public WebElement passwordInput;
    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;

    public void login(String username, String password) {
        driver.get(ConfigurationReader.getProperty("url"));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButton.click();

    }
    public void loginAsLibrary() {
        driver.get(ConfigurationReader.getProperty("url"));
        String username = ConfigurationReader.getProperty("libUserName");
        String password = ConfigurationReader.getProperty("libPassword");
        usernameInput.sendKeys(username);
       passwordInput.sendKeys(password);
       signInButton.click();

    }
    public void loginAsStudent() {
        driver.get(ConfigurationReader.getProperty("url"));
        String username = ConfigurationReader.getProperty("stuUserName11");
        String password = ConfigurationReader.getProperty("stuPassword11");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButton.click();

    }

}
